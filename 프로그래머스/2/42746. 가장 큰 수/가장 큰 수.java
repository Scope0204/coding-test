import java.util.Arrays;
import java.util.stream.Collectors;
class Solution {
    public String solution(int[] numbers) {
        String[] strNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strNumbers, (s1, s2) -> {
            int original = Integer.parseInt(s1 + s2);
            int reversed = Integer.parseInt(s2 + s1);
            return reversed - original;
        });

        StringBuilder result = new StringBuilder();
        for (String s : strNumbers) {
            result.append(s);
        }
        
        return result.toString().replaceAll("^0+", "0");
    }
}

