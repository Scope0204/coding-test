import java.util.ArrayList;
import java.util.Arrays;
import java.util.List; 

public class Solution {
    private static class Point {
        public final long x, y;

        private Point(long x, long y) {
            this.x = x;
            this.y = y; 
        }
    }
    // 1-A. 교점 좌표 구하기 : 교점이 정수이면 Point 객체 반환
    private Point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {
        double x = (double) (b1*c2 - b2*c1) / (a1 * b2 - a2 * b1);
        double y = (double) (a2*c1 - a1*c2) / (a1 * b2 - a2 * b1);

        // 교점이 정수인지 확인
        if (x % 1 != 0 || y % 1 != 0) return null;

        return new Point((long)x, (long)y);
    }

    // 2-1. 교점에서 가장 작은 좌표 찾기
    private Point getMinimumPoint(List<Point> points) {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;

        for (Point p : points) {
            if(p.x < x) x = p.x;
            if(p.y < y) y = p.y;
        }

        return new Point(x,y);
    }
    // 2-2. 교점에서 가장 큰 좌표 찾기
    private Point getMaximumPoint(List<Point> points) {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;

        for (Point p : points) {
            if(p.x > x) x = p.x;
            if(p.y > y) y = p.y;
        }

        return new Point(x,y);
    }
    
    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            for (int j = i+1; j < line.length; j++) {
                // line을 이용하여 1-A, 1-B 수행
                // 1-B. 정수 좌표만 저장
                Point intersection = intersection(line[i][0], line[i][1], line[i][2], 
                                                  line[j][0], line[j][1], line[j][2]); 
                
                if (intersection != null) {
                    points.add(intersection);
                }
            }
        }
        
        // 2. 저장된 정수들에 대해 x, y 좌표값 최소값 구하기
        Point minimum = getMinimumPoint(points);
        Point maximum = getMaximumPoint(points);
        
        // 3. 구한 최댓값, 최솟값을 이용하여 2차원 배열의 크기 결정
        int width = (int) (maximum.x - minimum.x + 1);
        int height = (int) (maximum.y - minimum.y + 1);
        
        char[][] arr = new char[height][width];
        for (char[] row : arr) {
            Arrays.fill(row, '.');
        }
        
        // 4. 준비된 2차원 배열에 별 찍기
        for(Point p : points) {
            // 좌표 변환 
            int x = (int) (p.x - minimum.x);
            int y = (int) (maximum.y - p.y);
            arr[y][x] = '*';
        }
             
        String[] answer = new String[arr.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = new String(arr[i]);
        }
        return answer;
    }
}