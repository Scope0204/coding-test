class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        int i = 0;
        for(char ch : arr) {
            if(Character.isWhitespace(ch)) { // 공백인 경우
                i = 0; // 인덱스 초기화
                sb.append(" ");
                continue;
            }
            if(i%2==0) {
                sb.append(Character.toUpperCase(ch)); // 대문자로 변경
            }
            else {
                sb.append(Character.toLowerCase(ch)); // 소문자로 변경
            }
            i++;
        }
        
        String answer = sb.toString();
        return answer;
    }
    
}