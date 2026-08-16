class Solution {

    public String solution(String play_time, String adv_time, String[] logs) {
        if (play_time.equals(adv_time))
            return intToStr(0);

        // 문자열을 숫자로 변환
        int playTime = strToInt(play_time);
        int advTime = strToInt(adv_time);

        int len = playTime + 1;
        long[] timeLine = new long[len];

        // 각 로그 시작 시점 +1, 종료 시점 -1 -> 누적합을 구하면 시간별 시청자 수가 됨
        for (String log : logs) {
            String[] parts = log.split("-");
            int start = strToInt(parts[0]);
            int end = strToInt(parts[1]);

            timeLine[start] += 1;
            timeLine[end] -= 1;
        }

        // 시간별 시청자 수 -> 누적합을 한번 더 구하면 누적 시청시간이 됨
        for (int i = 1; i < len; i++)
            timeLine[i] += timeLine[i - 1];

        // 0초부터 i초까지 누적 시청 시간
        for (int i = 1; i < len; i++)
            timeLine[i] += timeLine[i - 1];

        long max = timeLine[advTime];
        int startTime = 0;

        // 슬라이딩 윈도우로 최대 누적 시청 시간 구간 탐색
        for (int i = 1; i < len - advTime; i++) {
            long cur = timeLine[advTime + i - 1] - timeLine[i - 1];
            if (cur > max) {
                max = cur;
                startTime = i;
            }
        }

        return intToStr(startTime);
    }

    // 숫자->문자
    public String intToStr(int sec) {
        int hour = sec / (60 * 60);
        sec %= 60 * 60;
        int min = sec / 60;
        sec %= 60;

        return String.format("%02d:%02d:%02d", hour, min, sec);
    }

    // 문자->숫자
    public int strToInt(String time) {
        String[] s = time.split(":");
        int hour = Integer.parseInt(s[0]);
        int min = Integer.parseInt(s[1]);
        int sec = Integer.parseInt(s[2]);

        return hour * 60 * 60 + min * 60 + sec;
    }

}