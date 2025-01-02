class Solution {
    private static final int[] dx = {0,1,-1};
    private static final int[] dy = {1,0,-1}; 
    
    public int[] solution(int n) {
        
        int [][] arr = new int[n][n];
        int num = 1;
        int x=0;
        int y=0;
        int d=0; // 방향 변수

        while(true) {
            arr[y][x] = num++;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx == n || ny == n || nx == -1 || ny == -1 || arr[ny][nx] != 0){ // 더 이상 갈 수있는 방향이 없는 경우
                d = (d+1) % 3; // 방향 전환
                nx = x + dx[d];
                ny = y + dy[d];
                if(nx == n || ny == n || nx == -1 || ny == -1 || arr[ny][nx] != 0) break;
            }
            // 좌표 이동
            x = nx;
            y = ny;
            
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