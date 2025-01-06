class Solution {
    private char push(char c, int n) {
        if(!Character.isAlphabetic(c)) return c;

        int offset = Character.isUpperCase(c) ? 'A' : 'a'; // 대소문자 구분함수
        int position = c - offset;
        System.out.println("first:"+position);
        // position 만큼 push. 이때 마지막 위치에 도달하면 0부터 다시 시작해야함.
        position = (position + n) % ('Z' - 'A' + 1); //
        System.out.println(position);

        return (char) (offset + position);
    }

    public String solution(String s, int n) {
        StringBuilder builder = new StringBuilder();
        for(char c : s.toCharArray()) {
            builder.append(push(c, n));
        }
        return builder.toString();
    }

}

