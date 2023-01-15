package lesson_one_homework;

public class MoveZeroes {
    /*
    Given an integer array nums, move all 0 `s to
    the end of it while maintaining the relative order
    of the non-zero elements.
    Note that you must do this in-place without making a
    copy of the array.

    Example 1:
    Input: nums = [0, 1, 0, 3, 12]
    Output: [1, 3, 12, 0, 0]
    */

    public void moveZeroes(int[] nums) {
        int copyIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[copyIndex] = nums[i];
                copyIndex++;
            }
        }
        while (copyIndex < nums.length) {
            nums[copyIndex] = 0;
            copyIndex++;
        }
    }
}
