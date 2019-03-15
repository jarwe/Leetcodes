package cn.zilion.onetofifty;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * @description: Considering unrepeat string character, user hashset to record substring which extracted from source
     *              string, if character appear in hashset means current substring is longest unrepeat string.
     * @param a character array which converted from source string.
     * @param index search beginning.
     * @return from beginning index longest unrepeat string length.
     */
    private int getLongestSubstring(char[] a, int index) {
        Set<Character> set = new HashSet<Character>();
        int res = 0;
        for(int i = index; i < a.length; i++){
            if(!set.contains(a[i])) {
                set.add(a[i]);
                res++;
            } else {
                break;
            }
        }
        return res;
    }

    /**
     * @description: From head of string search longest substring without repeat character.
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int max = 0, len = s.length();
        for(int i = 0; i < len; i++) {
            int m = getLongestSubstring(s.toCharArray(), i);
            max = max > m ? max : m;
            if(len - i < max) {
                break;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
        String[] tests = {"abcabcbb", "bbbbb", "pwwkew"};
        for(String test : tests) {
            System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(test));
        }
    }
}
