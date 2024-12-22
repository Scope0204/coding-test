import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int [] s = new int[l];
        for(int i=0; i<l; i++){
            s[i] = sc.nextInt();
        }
        int n = sc.nextInt();

        Arrays.sort(s); // 순서 보장을 위한 정렬

        // n이 s의 어느 index 사이에 있나 구하기 위함
        int index = 0;
        for(int num : s){
            if(n>num) {
                index++;
            }
        }

        // n은 A와 B사이에 있음
        int A = 0;
        if(index==0){ // index가 0이라면
            A=0; // n은 0과 s[0]사이에 있음
        }
        else {
            A = s[index-1];
        }
        int B = s[index];

        // [x,y] 인 경우
        int sum = 0;
        for(int i=A+1; i<=n; i++){ // x의 범위
            for(int j = n; j<B; j++){ // y의 범위
                if(i==j) // 같으면 좋은 구간이 아님
                    continue;
                else
                    sum++;
            }
        }
        System.out.println(sum);
    }

}