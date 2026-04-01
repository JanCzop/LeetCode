import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> helper = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            Integer index = helper.get(complement);
            if (index != null) {
                return new int[]{index, i};
            }
            helper.put(nums[i], i);
        }
        throw new IllegalArgumentException("No solution found");
    }
}