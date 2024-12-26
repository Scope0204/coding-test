import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine()); // 새로운 입력 라인으로 초기화
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for(int idx = 0; idx < A.length ; idx++) {
            int arrSum = 0;
            for(int i = idx; i<A.length ; i++) {
                arrSum += A[i];
                if(arrSum >= M) break;
            }
            if(arrSum==M){
                result++;
            }
        }
        br.close();

        System.out.println(result);
    }

}