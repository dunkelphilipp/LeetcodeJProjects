public class LongestCommonPrefix {

    public static void main (String[] args) {
        String [] strs = {"flower","flow","flight"};

        String longestCommonPrefix = longestCommonPrefix(strs);
        System.out.println(longestCommonPrefix);
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return findLongestCommonPrefix(strs, 0, strs.length - 1);
    }

    private static String findLongestCommonPrefix(String[] strs, int left, int right) {
        if (left == right) {
            return strs[left];
        }

        int mid = (left + right) / 2;
        String leftPrefix = findLongestCommonPrefix(strs, left, mid);
        String rightPrefix = findLongestCommonPrefix(strs, mid + 1, right);

        return commonPrefix(leftPrefix, rightPrefix);
    }

    private static String commonPrefix(String left, String right) {
        int minLength = Math.min(left.length(), right.length());

        for (int i = 0; i < minLength; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }

        return left.substring(0, minLength);
    }
}
