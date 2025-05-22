import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] array, int[][] commands){
        int[] answer = new int[commands.length];

        for(int idx = 0 ; idx < commands.length ; idx++) {
            int[] command = commands[idx];

            int i = command[0];
            int j = command[1];
            int k = command[2];

            int[] arr = new int[j-i+1];
            int index = 0;
            while(i<=j){
                arr[index] = array[i-1];
                i++;
                index++;
            }
            IntStream sorted = Arrays.stream(arr).sorted();
            answer[idx] = sorted.toArray()[k-1];
        }

        return answer;
    }
}