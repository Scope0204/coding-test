class Solution {
    private final static int dx[] = {0,-1,1,0};
    private final static int dy[] = {-1,0,0,1};
    
    // 해당 대기실이 거리두기를 실시하는지 검증
    private boolean isDistanced(char[][] room) {
        for(int y = 0 ; y < room.length ; y++) {
            for (int x = 0 ; x < room[y].length ; x++) {
                // 각 좌표 별로 맨해튼 거리 검사 실시 (최대 8방향)
                if(room[y][x] != 'P') continue;
                if(!isDistanced(room, x,y)) return false;
            }
        }
        return true;
    }
    // 해당 좌표가 거리두기를 지키는 지를 검사
    // 맨해튼 검사 : 행렬 (r1, c1), (r2, c2)에 각각 위치하고 있다면, T1, T2 사이의 맨해튼 거리는 |r1 - r2| + |c1 - c2|
    private boolean isDistanced(char[][] room, int x, int y) {
        // 상하좌우를 검사
        for(int d = 0; d < 4 ; d ++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            // 다음처럼 응시자가 앉아있지 않은 위치들은 검사를 건너뜀(y를 x보다 먼저 검사해야 인덱스 에러 발생하지않음)
            if(ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;

            // X(파티션)의 경우에는 해당 위치이후에 응시자가 있더라도 거리두기를 지킨것이므로 별도의 처리를 하지않음
            switch(room[ny][nx]) {
                case 'P': return false; // 응시자가 있음 -> 거리두기를 지키지않음
                case 'O':
                    // 인접한 곳에 다른 응시자가 있는지 한번더 검사
                    if (isNextToVolunteer(room, nx, ny, 3-d)) return false; 
                    break;
            }
        }
        return true;
    }

    private boolean isNextToVolunteer(char[][] room, int x, int y, int exclude) {
        for(int d = 0 ; d < 4 ; d++) {
            if (d==exclude) continue; // 자신에 대한 방향에 대해서는 검사를 제외

            int nx = x + dx[d];
            int ny = y + dy[d];
            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;

            if (room[ny][nx] == 'P') return true;
        }
        return false;
    }
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for(int i = 0 ; i < answer.length; i ++) {
            String[] place = places[i];
            char[][] room = new char[place.length][];
            for(int j = 0 ; j < room.length; j++) {
                room[j] = place[j].toCharArray();
            }
            // 거리 두기 검사 후 answer에 기록
            if(isDistanced(room)) {
                answer[i] = 1;
            }
            else {
                answer[i] = 0;
            }
        }
        return answer;
    }
}
