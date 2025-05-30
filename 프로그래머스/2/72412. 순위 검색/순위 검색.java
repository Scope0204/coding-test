import java.util.*;
import java.util.function.Consumer;

class Solution {
    // info를 사용하여 조건별 리스트를 생성
    private Map<String, List<Integer>> buildScoresMap(String[] info){
        // key : 문자열로 표현한 검색 조건, values: 해당 검색 조건에 들어있는 점수 리스트
        Map<String, List<Integer>> scoresMap = new HashMap<>();
        // 전처리 과정
        for (String s : info) {
            String[] tokens = s.split(" "); // 공백으로 지원자 조건 구분
            int score = Integer.parseInt(tokens[tokens.length -1]); // last index에 점수가 존재
            // scoresMap에 추가
            forEachKey(0, "", tokens, key -> { // Consumer는 accept 함수를 제공하여 원하는 동작을 구현할 수 있음
                scoresMap.putIfAbsent(key, new ArrayList<>()); // 키 값이 존재하는 경우, 빈 arraylist반환
                scoresMap.get(key).add(score); // 그 후 해당 키에 점수를 추가
            });
        }
        for (List<Integer> list : scoresMap.values()) {
            Collections.sort(list); // 만든 리스트를 정렬
        }

        return scoresMap;
    }

    // tokens로 만들 수 있는 모든 조건을 찾는 함수 (tokens에는 총 4개의 조건이 있고, 각 조건마다 -를 이용할 수 있음)
    private void forEachKey(int index, String prefix, String[] tokens,
                            Consumer<String> action) {
        if(index == tokens.length -1) { // tokens의 마지막에는 지원자 점수가들어있으므로 , last-1까지만 재귀 수행.
            // prefix가 만들어진 검색 조건
            action.accept(prefix);
            return;
        }

        // 재귀를 통해 만들 수 있는 모든 조건을 찾음
        forEachKey(index + 1, prefix + tokens[index], tokens, action);
        forEachKey(index + 1, prefix + "-", tokens, action);

    }
    // 조건에 맞는 지원자 수를 세는 메서드
    private int count(String query, Map<String, List<Integer>> scoresMap) {
        // scoresMap을 이용하여 query에 맞는 지원자 수 세기
        String[] tokens = query.split(" (and )?");  // 공백이나 " and "로 구분된 쿼리를 정규표현식으로 구분
        String key = String.join("", Arrays.copyOf(tokens, tokens.length -1)); // token의 마지막 원소는 점수이므로 key에 포함하지 앟음 따라서 Arrays.copyOf()메서드로 마지막원소를 제외한 나머지 원소를 복사하여 전달.(조건이 작아서 copy씀)
        if (!scoresMap.containsKey(key)) return 0;
        List<Integer> scores = scoresMap.get(key);
        int score = Integer.parseInt(tokens[tokens.length-1]);
        
        return scores.size() - binarySearch(score, scoresMap.get(key));
    }
    // 조건을 만족하는 점수의 리스트와 검사할 점수를 통해 이진탐색을 수행
    private int binarySearch(int score, List<Integer> scores) {
        int start = 0;
        int end = scores.size() -1;

        while(end > start) {
            int mid = (start+end) / 2;

            if(scores.get(mid) >= score) {
                end = mid;
            } else {
                start = mid + 1;
            }

        }
        if(scores.get(start) < score ) {
            return scores.size();
        }
        return start;
    }

    public int[] solution(String[] info, String[] query) {
        // 전처리 메서드를 호출
        Map<String, List<Integer>> scoresMap = buildScoresMap(info);
        int[] answer = new int[query.length];
        for(int i = 0; i < answer.length ; i++) {
            answer[i] = count(query[i], scoresMap);
        }
        return answer;
    }
}