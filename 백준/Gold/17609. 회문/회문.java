import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // scanner 줄바꿈 시 형태에 따른 명시적 처리
        String[] strs = new String[t];
        for (int i = 0; i < t; i++) {
            strs[i] = sc.nextLine();
        }
        for (String s : strs) {
            System.out.println(palindrome(0,s.length()-1,s,0)); // failCount 0이면 회문, 1이면 유사 회문, 2이면 둘 다 아님
        }
    }

    private static int palindrome(int left, int right, String s, int failCount){
        if(failCount == 2) { // 2번이상 틀리면 회문이 아님.
            return failCount;
        }
        while (left < right){
            if(s.charAt(left) == s.charAt(right)){ // 같은 경우 포인터 진행
                left++;
                right--;
            }
            else { // 다른 경우, 양쪽으로 한번 더 실시. 회문이 되는 곳을 반환
                return Math.min(palindrome(left + 1, right, s, failCount + 1), palindrome(left, right - 1, s, failCount + 1));
            }
        }
        return failCount;
    }
}