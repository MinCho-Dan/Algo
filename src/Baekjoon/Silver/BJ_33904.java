package Maraton84;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_33904 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> lines = new ArrayList<>();
		String input;

		while ((input = br.readLine()) != null) {
			lines.add(input);
		}

		if (lines.isEmpty())
			return;

		// 2. 연산식과 for문 분리
		String expression = lines.get(lines.size() - 1);
		List<Character> forVars = new ArrayList<>();
		List<String> forContents = new ArrayList<>();

		for (int i = 0; i < lines.size() - 1; i++) {
			String line = lines.get(i).trim();
			int varIdx = line.indexOf("int ") + 4;
			char varName = line.charAt(varIdx);
			forVars.add(varName);
			forContents.add(line);
		}

		// 3. 유효한 for문 판별
		boolean[] isNecessary = new boolean[forVars.size()];
		for (int i = 0; i < forVars.size(); i++) {
			char currentVar = forVars.get(i);

			// 조건 1: 내부(i 이후)에 같은 변수가 다시 선언되었는지 확인
			boolean reDeclared = false;
			for (int j = i + 1; j < forVars.size(); j++) {
				if (currentVar == forVars.get(j)) {
					reDeclared = true;
					break;
				}
			}

			// 조건 2: 연산식에 변수가 포함되어 있는지 확인
			boolean isUsed = false;
			if (expression.indexOf(currentVar) != -1) {
				isUsed = true;
			}

			// 두 조건을 모두 만족하지 않아야(재선언 X, 사용 O) 필요한 for문
			if (!reDeclared && isUsed) {
				isNecessary[i] = true;
			}
		}

		// 4. 결과 출력 (들여쓰기 적용)
		StringBuilder sb = new StringBuilder();
		int indent = 0;
		for (int i = 0; i < forVars.size(); i++) {
			if (isNecessary[i]) {
				for (int k = 0; k < indent; k++)
					sb.append(" ");
				sb.append(forContents.get(i)).append("\n");
				indent++;
			}
		}

		// 마지막 연산식 출력
		for (int k = 0; k < indent; k++)
			sb.append(" ");
		sb.append(expression.trim());

		System.out.println(sb.toString());
	}
}