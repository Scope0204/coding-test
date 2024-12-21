import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder result = new StringBuilder();

        int index = sc.nextInt();
        sc.nextLine(); // scanner extInt()와 nextLine() 혼용 시 줄바꿈 문자를 명시적으로 처리해야함.
        // 비밀번호를 입력
        for(int i = 0; i < index; i++) {
            Stack<String> left = new Stack<>();
            Stack<String> right = new Stack<>();

            String[] input = sc.nextLine().split("");
            for(String str : input) {
                switch (str) {
                    case "<":
                        if (!left.isEmpty()) {
                            right.push(left.pop());
                        }
                        break;

                    case ">":
                        if (!right.isEmpty()) {
                            left.push(right.pop());
                        }
                        break;

                    case "-":
                        if (!left.isEmpty()) {
                            left.pop();
                        }
                        break;
                    default:
                        left.push(str);
                }
            }
            while (!left.isEmpty()) {
                right.push(left.pop());
            }
            while (!right.isEmpty()) {
                result.append(right.pop());
            }
            result.append("\n");
        }
        System.out.println(result.toString());
    }
}