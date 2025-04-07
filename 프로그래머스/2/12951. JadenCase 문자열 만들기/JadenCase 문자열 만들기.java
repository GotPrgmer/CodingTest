class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isStart = true;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ' ') {
                sb.append(ch);
                isStart = true;
            } else {
                if (isStart) {
                    sb.append(Character.toUpperCase(ch));
                } else {
                    sb.append(Character.toLowerCase(ch));
                }
                isStart = false;
            }
        }

        return sb.toString();
    }
}