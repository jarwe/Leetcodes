package cn.zilion.onetofifty;


/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123
 * Output: 321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
public class ReverseInteger {
    int max = Integer.MAX_VALUE / 10;
    private int reverseInt(int s) {
        int sum = 0;
        while(s != 0) {
            sum = sum * 10 + s % 10;
            s = s / 10;
            if(s > 0 && sum > max) {
                sum = 0;
                break;
            }
        }
        return sum;
    }
    public int reverse(int x) {
        if(x == Integer.MIN_VALUE) {
            return 0;
        }
        if(x > 0) {
            return reverseInt(x);
        } else {
            return  0 - reverseInt( 0 - x);
        }
    }
    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        int[] params = {1534236469, -2147483648, 1463847412};
        for(int n : params) {
            System.out.println(reverseInteger.reverse(n));
        }
    }
}
