class Solution {
    public String solution(String s) {
         String answer = s.chars()
                .boxed()
                .sorted((v1, v2) -> v2 - v1)
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
        
        return answer;
    }
}