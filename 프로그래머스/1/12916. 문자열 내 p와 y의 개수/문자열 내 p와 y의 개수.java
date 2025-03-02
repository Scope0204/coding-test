class Solution {
    boolean solution(String s) {

        // 1. 문자열을 모두 소문자로 변환
        s = s.toLowerCase();

        // 2. "p"의 개수 세기
        int ps = s.length() - s.replace("p", "").length(); // 원본 길이 - p를 제외한 길이 = p의 개수
        
        // 3. "y"의 개수 세기
        int ys = s.length() - s.replace("y", "").length();
        
        return ps == ys;
    }
}