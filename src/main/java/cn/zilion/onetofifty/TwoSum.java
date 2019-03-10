package cn.zilion.onetofifty;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /**
     * @Description: Two SUM problem, we can put all of members into Map at first
     *               then, we just calculate division by target divided by member of nums, if we get its result
     *               from hashmap it means target can be calculated. Its complexity is O(n).
     *               Another way is force found member one by one, its complexity is O(n^2).
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for(int n : nums) {
            map.put(n, true);
        }
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                res[0] = nums[i];
                res[1] = target - nums[i];
                break;
            }
        }
        return res;
    }
}
