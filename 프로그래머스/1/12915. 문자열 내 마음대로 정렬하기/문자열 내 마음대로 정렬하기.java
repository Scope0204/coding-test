import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (s1,s2) -> {
            if(s1.charAt(n) != s2.charAt(n)) {
                return s1.charAt(n) - s2.charAt(n); // 내림차순
            }
            return s1.compareTo(s2); // 같은 경우 사전 순으로 정렬 
            });
        return strings;
    }
}
