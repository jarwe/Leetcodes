package cn.zilion.onetofifty;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindromicSubstring {
    /**
     * @description: Check if current substring begin from index start stop at index end from source string is Palindrome string.
     * @param s source string.
     * @param start beginning index.
     * @param end stopping index.
     * @return is Palindrome.
     */
    boolean isPalindrome(String s, int start, int end) {
        int indexS = start, indexE = end;
        while(indexS < indexE) {
            if(s.charAt(indexS++) != s.charAt(indexE--)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @descripptio: Search palindrome from source string. Search from two side of source string.
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int start = 0, end = 0, max = 0;
        if(s == null || s.length() <= 1) {
            return s;
        }
        for(int i = 0; i < s.length(); i++) {
            for(int j = s.length() - 1; j > i; j--) {
                if(j - i <= max) {
                    break;
                }
                if(isPalindrome(s, i, j)) {
                    if(j - i > max) {
                        max = j - i;
                        start = i;
                        end = j + 1;
                    }
                }
            }
        }
        return s.substring(start, end);
    }
}
