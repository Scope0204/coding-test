class Solution {
    public int[] solution(int brown, int yellow) {
        
        // 최소 조건 갈색 8, 노랑 1 -> width = 3 , height = 3
        for (int width = 3; width <= 5000 ; width ++){
            for (int height = 3 ; height <= width; height ++) {
                int boundary = (width + height -2) * 2 ; // brown 
                int center = width * height - boundary ; // yellow 
                if( brown == boundary && yellow == center) {
                    return new int[] {width, height};
                }
            }
        }
        
        return null;
    }
}

// 총 개수 width * height 
// 갈색 개수 width * 2 + (height-2) * 2 = (width+height-2) * 2
// 노란색 개수 (width * height) - (width+height-2)*2  = xy - 2x - 2y -4
