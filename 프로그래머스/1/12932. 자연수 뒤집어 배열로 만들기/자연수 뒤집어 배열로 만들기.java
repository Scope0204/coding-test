class Solution {
    public int[] solution(long n) {
        String str = Long.toString(n);
        String reserved = new StringBuilder(str).reverse().toString();
        char[] arr = reserved.toCharArray();
        int[] answer = new int[arr.length];
        for(int i = 0 ; i<answer.length ; i++) {
            answer[i] = arr[i] - '0'; // 아스키 코드를 사용하여 문자를 정수로 변환(숫자이기 때문에 가능)
        }
        return answer;
    }
}
