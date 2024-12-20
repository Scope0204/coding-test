import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        // 계산 수행 binary sum
        for(int i = 0; i < input; i++) {
            StringBuilder result = new StringBuilder();
           /* int a = sc.nextInt();
            int b = sc.nextInt();*/
            // BigInteger로 입력 받기
            BigInteger a = sc.nextBigInteger();
            BigInteger b = sc.nextBigInteger();

            char[] binarySum = String.valueOf(a.add(b)).toCharArray();

            int plus = 0;
            int length = binarySum.length;
            for (int j = length - 1; j >= 0; j--) {
                int sum = binarySum[j] - '0' + plus;
                result.append(sum%2);
                plus = sum/2;
            }
            if(plus == 1) result.append(plus); // 마지막에 2가 남은 경우 추가

            // 결과 출력
            System.out.println(result.reverse().toString());
        }
    }
}