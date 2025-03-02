class Solution {
    private int countZeros(String s) {
        int zeros = 0;
        for (char c : s.toCharArray()) {
            if ( c == '0') zeros++;
        }

        return zeros;
    }

    public int[] solution(String s) {
        int loop = 0; // 이진 변환 횟수
        int removed = 0; // 0 이 제거된 횟수

        while (!s.equals("1")) {
            // s 변환하며 loop, removed 누적

            // 1-a. 문자열에 포함된 0의 개수 세기
            int zeros = countZeros(s); // 0의 개수 조회
            loop += 1; // 이진 변환 시도
            removed += zeros; // 0 개수만큼 제거

            // 1-b. 나머지 1의 개수를 사용해서 2진법으로 변환하여 1부터 반복
            int ones = s.length() - zeros; // 1의 개수를 구함(0이 제거된 수 = 1의 개수)
            s = Integer.toString(ones,2); // 해당 길이를 이진법으로 표현
        }

        return new int[] { loop, removed };
    }
}
