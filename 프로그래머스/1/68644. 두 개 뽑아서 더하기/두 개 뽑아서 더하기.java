import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> a = new HashSet<>();
        for(int i = 0; i<numbers.length; i++ ){
            for(int j = i+1; j < numbers.length; j++) {
                a.add(numbers[i]+numbers[j]);
            }
        }
        IntStream intStream = a.stream().mapToInt(Integer::intValue);
        int[] answer = intStream.sorted().toArray();
        return answer;
    }
}