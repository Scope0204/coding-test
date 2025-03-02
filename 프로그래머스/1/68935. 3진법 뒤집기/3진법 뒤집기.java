class Solution {
    public int solution(int n) {
        String str = Integer.toString(n,3); // 3진법으로 변환
        String reversed = new StringBuilder(str).reverse().toString();
        return Integer.valueOf(reversed,3);
    }
        
}