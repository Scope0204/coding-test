import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 재료 수
        int m = sc.nextInt(); // 갑옷을 만드는데 필요한 수
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt(); // 한 숫자씩 입력받기
        }
        Arrays.sort(numbers); // 숫자 크기만큼 정렬

        // 투 포인터 알고리즘 적용
        int left = 0;
        int right = numbers.length -1;
        int result = 0;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if(sum == m) {
                result++;
                left++;
                right--;
            }
            else if (sum < m) {
                left++;
            }
            else {
                right--;
            }
        }
        System.out.println(result);
    }
}