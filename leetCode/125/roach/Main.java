public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome("0P"));
    }

    static class Solution {
        public boolean isPalindrome(String s) {
            String word = s.toLowerCase();
            word = word.replaceAll("[^a-z0-9]", "");
            word = word.replaceAll(" ", "");
            char[] w_array = word.toCharArray();
            for (int i = 0; i < w_array.length / 2; i++) {
                if (w_array[i] != w_array[(w_array.length - 1) - i]) {
                    return false;
                }
            }
            return true;
        }
    }
}
