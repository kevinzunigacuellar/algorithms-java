/* 

Binary Search:

Time complexity: O(log(n))

This algorithm is used to find the position of the target in a sorted array.
It moves two pointers, right and left and evaluates the midpoint of its sum with the target.
- if the sum is greater than the target, then the left pointer moves to the left of the midpoint.
- if the sum is less than the target, then the right pointer moves to the right of the midpoint.
- if the sum is equal to the target, then the target is found.
*/

public class Leetcode704 {

  public static int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    int mid;
    while (left <= right) {
      mid = (right + left) / 2;
      if (target == nums[mid]) {
        return mid;
      } else if (target < nums[mid]) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] nums = { -1, 0, 3, 5, 9, 12 };
    int target = 9;
    int ans = search(nums, target);
    System.out.println(ans);
  }
}
