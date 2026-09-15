class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;

        // Move all non-zero elements to the front
        for (int num : nums) {
            if (num != 0) {
                nums[index] = num;
                index++;
            }
        }

        // Fill the remaining positions with zeros
        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }
    }
}
