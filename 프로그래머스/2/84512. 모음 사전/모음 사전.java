import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final char[] CHARS ="AEIOU".toCharArray();

    private List<String> generate(String word) {
        List<String> words = new ArrayList<>();
        words.add(word);

        // 종료 조건 : 길이가 5 이상
        if(word.length() == 5) return words;

        // 점화식
        for(char c : CHARS) {
            words.addAll(generate((word + c)));
        }
        return words;
    }

    public int solution(String word) {
        return generate("").indexOf(word);
    }
}
