package cn.zilion.onetofifty;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 * Example 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 */
public class MedianOfTwoSortedArrays {
    /**
     * @description: Use insert sort method to merge two sorted array as one sorted array.
     * @param nums1
     * @param nums2
     * @return sorted array.
     */
    private int[] mergeArray(int[] nums1, int[] nums2) {
        int len = 0;
        int index1 = -1, index2 = -1;
        if(nums1 != null && nums1.length != 0) {
            len += nums1.length;
            index1 = 0;
        } else {
            return nums2;
        }
        if(nums2 != null && nums2.length != 0) {
            len += nums2.length;
            index2 = 0;
        } else {
            return nums1;
        }
        int[] res = new int[len];
        for(int i = 0; i < len; i++) {
            if(index1 < nums1.length && index2 < nums2.length) {
                if(nums1[index1] > nums2[index2]) {
                    res[i] = nums2[index2++];
                } else {
                    res[i] = nums1[index1++];
                }
            } else if(index1 < nums1.length) {
                res[i] = nums1[index1++];
            } else {
                res[i] = nums2[index2++];
            }
        }
        return res;
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] array = mergeArray(nums1, nums2);
        //To handle different scenario such as only one number in array, two numbers in array and so on.
        if(array.length == 0) {
            return 0;
        } else if(array.length == 1) {
            return array[0];
        } else if(array.length == 2) {
            return (array[0] + array[1]) / 2;
        } else {
            if(array.length % 2 == 0) {
                return (array[array.length / 2 - 1] + array[array.length / 2]) / 2;
            } else {
                return array[array.length / 2];
            }
        }
    }
}
