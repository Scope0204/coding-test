import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("-", 0);
        map.put("\\", 1);
        map.put("(", 2);
        map.put("@", 3);
        map.put("?", 4);
        map.put(">", 5);
        map.put("&", 6);
        map.put("%", 7);
        map.put("/", -1);

        Scanner sc = new Scanner(System.in);

        while (true) {
            String input = sc.nextLine();
            // '#'이 입력되면 종료
            if (input.equals("#")) {
                break;
            }

            int strLength = input.length(); // 길이 확인
            int resultNum = 0;
            for(int i = 1; strLength-i >= 0 ; i++) {
                String a = String.valueOf(input.charAt(i-1));
                int b = map.get(a);
                int result= (int) Math.pow(8, strLength-i);
                resultNum += b * result;
            }
            System.out.println(resultNum);
        }
    }
}