class Solution {
    public int[] solution(int n) {
        int [][] arr = new int[n][n];
        int num = 1;
        int x=0;
        int y=0;

        while(true) {
            // 1. 아래로 이동
            while(true) {
                arr[y][x] = num++;
                if(y + 1 == n || arr[y + 1][x] != 0) break;
                y++;
            }
            if(x + 1 == n || arr[y][x + 1] != 0) break; // 오른쪽으로 이동할 칸이 없는 경우 반복문 종료
            x++;

            // 2. 오른쪽으로 이동
            while(true) {
                arr[y][x] = num++;
                if(x + 1 == n || arr[y][x + 1] != 0) break;
                x++;
            }
            if(arr[y - 1][x - 1] != 0) break;
            x--;
            y--;

            // 3. 왼쪽 위로 이동
            while(true) {
                arr[y][x] = num++;
                if(arr[y - 1][x - 1] != 0) break;
                x--;
                y--;
            }
            if(y + 1 == n || arr[y + 1][x] != 0) break;
            y++;
        }

        int[] result = new int[num-1]; // 추가된 숫자-1 만큼 존재하므로 해당 값으로 배열 크기 지정
        int index = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0 ; j <= i ; j++){
                result[index++] = arr[i][j];
            }
        }
        return result;
    }
}