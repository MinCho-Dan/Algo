import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class test {

	static final String NICKNAME = "D0006_CHOIGYUJIK_";
	static final String HOST = "127.0.0.1";
	static final int PORT = 1447;
	static final int CODE_SEND = 9901;
	static final int CODE_REQUEST = 9902;
	static final int SIGNAL_ORDER = 9908;
	static final int SIGNAL_CLOSE = 9909;

	static final int TABLE_WIDTH = 254;
	static final int TABLE_HEIGHT = 127;
	static final int NUMBER_OF_BALLS = 6;
	static final float BALL_RADIUS = 5.73f / 2; // 공의 반지름
	static final int[][] HOLES = { { 0, 0 }, { 127, 0 }, { 254, 0 }, { 0, 127 }, { 127, 127 }, { 254, 127 } };

	public static void main(String[] args) {
		Socket socket = null;
		String recv_data = null;
		byte[] bytes = new byte[1024];
		float[][] balls = new float[NUMBER_OF_BALLS][2];
		int order = 0;

		try {
			socket = new Socket();
			System.out.println("Trying Connect: " + HOST + ":" + PORT);
			socket.connect(new InetSocketAddress(HOST, PORT));
			System.out.println("Connected: " + HOST + ":" + PORT);

			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			String send_data = CODE_SEND + "/" + NICKNAME + "/";
			bytes = send_data.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("Ready to play!\n--------------------");

			while (socket != null) {
				bytes = new byte[1024];
				int count_byte = is.read(bytes);
				recv_data = new String(bytes, 0, count_byte, "UTF-8");
				System.out.println("Data Received: " + recv_data);

				String[] split_data = recv_data.split("/");
				int idx = 0;
				try {
					for (int i = 0; i < NUMBER_OF_BALLS; i++) {
						for (int j = 0; j < 2; j++) {
							balls[i][j] = Float.parseFloat(split_data[idx++]);
						}
					}
				} catch (Exception e) {
					bytes = (CODE_REQUEST + "/" + CODE_REQUEST).getBytes("UTF-8");
					os.write(bytes);
					os.flush();
					System.out.println("Received Data has been currupted, Resend Requested.");
					continue;
				}

				if (balls[0][0] == SIGNAL_ORDER) {
					order = (int) balls[0][1];
					System.out.println("\n* You will be the " + (order == 1 ? "first" : "second") + " player. *\n");
					continue;
				} else if (balls[0][0] == SIGNAL_CLOSE) {
					break;
				}

				for (int i = 0; i < NUMBER_OF_BALLS; i++) {
					System.out.println("Ball " + i + ": " + balls[i][0] + ", " + balls[i][1]);
				}

				float whiteBall_x = balls[0][0];
				float whiteBall_y = balls[0][1];

				float targetBall_x = -1, targetBall_y = -1;

				if (order == 1) {
					// 선공: 1번 -> 3번 -> 5번(검정공)
					if (balls[1][0] != -1) {
						targetBall_x = balls[1][0];
						targetBall_y = balls[1][1];
					} else if (balls[3][0] != -1) {
						targetBall_x = balls[3][0];
						targetBall_y = balls[3][1];
					} else {
						targetBall_x = balls[5][0];
						targetBall_y = balls[5][1];
					}
				} else {
					// 후공: 2번 -> 4번 -> 5번(검정공)
					if (balls[2][0] != -1) {
						targetBall_x = balls[2][0];
						targetBall_y = balls[2][1];
					} else if (balls[4][0] != -1) {
						targetBall_x = balls[4][0];
						targetBall_y = balls[4][1];
					} else {
						targetBall_x = balls[5][0];
						targetBall_y = balls[5][1];
					}
				}

				float angle = 0.0f;
				float power = 0.0f;

				// 6개 홀 중 가장 가까운 홀을 선택
				double minDistance = Double.MAX_VALUE;
				int bestHoleIdx = -1;
				
				for (int i = 0; i < HOLES.length; i++) {
				    double dist = Math.sqrt(Math.pow(targetBall_x - HOLES[i][0], 2) + Math.pow(targetBall_y - HOLES[i][1], 2));
				    if (dist < minDistance) {
				        minDistance = dist;
				        bestHoleIdx = i;
				    }
				}

				int holeX = HOLES[bestHoleIdx][0];
				int holeY = HOLES[bestHoleIdx][1];

				// 목적구와 홀의 각도를 계산 (b 벡터의 각도)
				double targetToHoleAngleRad = Math.atan2(holeY - targetBall_y, holeX - targetBall_x);
				
				// 목적구와 홀 사이의 거리 (b)
				double distanceTargetToHole = Math.sqrt(Math.pow(targetBall_x - holeX, 2) + Math.pow(targetBall_y - holeY, 2));

				// 흰 공과 목적구 사이의 거리 (c)
				double distanceWhiteToTarget = Math.sqrt(Math.pow(whiteBall_x - targetBall_x, 2) + Math.pow(whiteBall_y - targetBall_y, 2));

				// 흰 공이 목적구를 쳐서 홀로 향하게 하기 위한 충돌 지점 계산
				// 충돌 지점은 목적구와 홀을 잇는 직선 위에 있으며, 목적구 중심에서 2 * BALL_RADIUS 만큼 떨어진 곳
				double strikePointX = targetBall_x - (2 * BALL_RADIUS * Math.cos(targetToHoleAngleRad));
				double strikePointY = targetBall_y - (2 * BALL_RADIUS * Math.sin(targetToHoleAngleRad));
				
				// 흰 공과 충돌 지점 사이의 거리
				double distanceWhiteToStrike = Math.sqrt(Math.pow(whiteBall_x - strikePointX, 2) + Math.pow(whiteBall_y - strikePointY, 2));
				
				// 흰 공과 목적구 사이의 각도 (d)
				double whiteToTargetAngleRad = Math.atan2(targetBall_y - whiteBall_y, targetBall_x - whiteBall_x);
				
				// 최종 각도 계산 (white ball에서 strike point로 향하는 각도)
				double finalAngleRad = Math.atan2(strikePointY - whiteBall_y, strikePointX - whiteBall_x);
				angle = (float) Math.toDegrees(finalAngleRad);
				if (angle < 0) {
					angle += 360;
				}

				// 파워 계산 (거리 c에 기반하여)
				power = (float) distanceWhiteToTarget * 0.8f; // 거리에 비례하도록 조정
				power = (float) Math.max(10, Math.min(100, power)); // 최소 10, 최대 100으로 제한
				
				// 뱅크샷과 같은 복잡한 상황을 위해 여유 파워 추가
				if(Math.abs(angle - Math.toDegrees(whiteToTargetAngleRad)) > 5) { // 충돌각이 클 경우
				    power += 10;
				}
				
				System.out.printf("Best Hole: %d, Target to Hole Dist: %.2f, White to Target Dist: %.2f\n", bestHoleIdx, distanceTargetToHole, distanceWhiteToTarget);
				System.out.printf("Final Angle: %.2f, Final Power: %.2f\n", angle, power);

				String merged_data = angle + "/" + power + "/";
				bytes = merged_data.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println("Data Sent: " + merged_data);
			}

			os.close();
			is.close();
			socket.close();
			System.out.println("Connection Closed.\n--------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}