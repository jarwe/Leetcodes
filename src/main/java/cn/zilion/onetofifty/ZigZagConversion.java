package cn.zilion.onetofifty;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if(numRows <= 1) {
            return s;
        }
        String[] groups = new String[numRows];
        for(int i = 0; i < numRows; i++) {
            groups[i] = "";
        }
        int len = numRows * 2 - 2;
        int splitTimes = s.length() % len == 0 ? s.length() / len : s.length() / len + 1;
        for(int i = 0; i < splitTimes; i++) {
            int indexS = i * len, indexE = (i + 1) * len > s.length() ? s.length() : (i + 1) * len;
            String subString = s.substring(indexS, indexE);
            int start = 0, end = len - 1;
            groups[start] += subString.charAt(start++);
            while(start <= end) {
                if(start != end) {
                    if(start < subString.length()) {
                        groups[start] += subString.charAt(start++);
                    } else {
                        start++;
                    }
                    if(end < subString.length()) {
                        groups[start - 1] += subString.charAt(end--);
                    } else {
                        end--;
                    }
                } else {
                    if(start < subString.length()) {
                        groups[start] += subString.charAt(start++);
                    } else {
                        start++;
                    }
                }
            }
        }
        String res = "";
        for(String group : groups) {
            res += group;
        }
        return res;
    }

    public static void main(String[] args) {
        ZigZagConversion zigZagConversion = new ZigZagConversion();
        String[] a = {"PAYPALISHIRING", "PAYPALISHIRING", "ABCDE", "ABCD"};
        int[] n = {3, 4, 4, 4};
        for(int i = 0; i < a.length; i++) {
            System.out.println(zigZagConversion.convert(a[i], n[i]));
        }
    }
}
