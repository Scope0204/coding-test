import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    private static class Course {
        public final String course; // 코스 구성
        public final int occurrences; // 주문 목록에서 등장한 횟수

        public Course(String course, int occurrences) {
            this.course = course;
            this.occurrences = occurrences;
        }
    }

    private static void getCourses(char nextMenu,
                            Set<String> selectedMenus,
                            List<Set<String>> orderList,
                            Map<Integer, List<Course>> courses ) {
        int occurrences = (int) orderList.stream()
                .filter(order -> order.containsAll(selectedMenus))
                .count();
        if (occurrences <2) return;

        // 현재까지 구한 메뉴 조합에 포함된 메뉴 개수를 size 변수에 담음
        int size = selectedMenus.size();
        if(courses.containsKey(size)) {
            List<Course> courseList = courses.get(size);

            Course course = new Course(selectedMenus.stream()
                    .sorted().collect(Collectors.joining("")),
                    occurrences
            );

            Course original = courseList.get(0); // courseList 가 비어있는 경우 exception
            if(original.occurrences < occurrences) {
                courseList.clear(); // 초기화
                courseList.add(course);
            } else if (original.occurrences == occurrences) {
                courseList.add(course);
            }
        }

        if (size>10) return;

        //
        for (char menuChar = nextMenu ; menuChar <= 'Z' ; menuChar++) {
            String menu = String.valueOf(menuChar);
            selectedMenus.add(menu);
            getCourses((char) (menuChar + 1), selectedMenus, orderList, courses);
            selectedMenus.remove(menu);
        }
    }
    public static String[] solution(String[] orders, int[] course) {

        List<Set<String>> orderList = Arrays.stream(orders)
                .map(String::chars)
                .map(charStream -> charStream
                        .mapToObj(menu -> String.valueOf((char) menu)) // 각 아스키 코드를 문자열로 변환
                        .collect(Collectors.toSet()))
                .collect(Collectors.toList());

        Map<Integer, List<Course>> courses = new HashMap<>(); // 생성된 코스들을 담을 Map
        for(int length : course) {
            List<Course> list = new ArrayList<>();
            list.add(new Course("",0)); // getCourses() 에서 리스트가 비어 있지 않는 조건을 맞추기 위해 추가
            courses.put(length, list);
        }
        getCourses('A', new HashSet<>(), orderList, courses); // 코스 조회 메서드 호출(재귀)

        return courses.values().stream()
                .filter(list -> list.get(0).occurrences > 0)
                .flatMap(List::stream)
                .map(c -> c.course)
                .sorted()
                .toArray(String[]::new);
    }

}