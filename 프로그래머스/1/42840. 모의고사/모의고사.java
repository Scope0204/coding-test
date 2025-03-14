class Solution {
    private int successCnt(int[] stdAnswer, int[] answers) {
        int result = 0;
        for(int i = 0 ; i<answers.length ; i++) {
            if(stdAnswer[i%stdAnswer.length] == answers[i]) result++;
        }
        return result;
    }
    public int[] solution(int[] answers) {
        // 1,2,3 이 다음순으로 찍음.
        // 1. 12345
        // 2. 21232425
        // 3. 3311224455
        // 가장 많이 맞춘 학생의 번호 표시
        int[][] stdAnswers = {{1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};
        int[] stdSuccess = new int[stdAnswers.length];
        int maxSuccessCnt = 0;
        int answerLength = 0;

        for(int i = 0 ; i < stdAnswers.length ; i++) {
            int result = successCnt(stdAnswers[i], answers);
            if(maxSuccessCnt < result) {
                maxSuccessCnt = result;
                answerLength = 1;
            }
            else if(maxSuccessCnt == result){
                answerLength++;
            }
            stdSuccess[i] = result;
        }
        int[] answer = new int[answerLength];
        int cnt= 0;
        for(int j = 0 ; j<stdSuccess.length; j++){
            if(stdSuccess[j] == maxSuccessCnt){
                answer[cnt] = j+1;
                cnt++;
            }
        }
        return answer;
    }
    
}