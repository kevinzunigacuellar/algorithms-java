/* 
Search insert position - https://leetcode.com/problems/search-insert-position/
In this problem we need to find position of the target in a sorted array or the position where the target should be inserted.
To solve this problem we use binary search, using two pointers, left and right.
If the algoritm is not found, then we return the left pointer which would be the position where the target should be inserted.

Why left and not mid or right?
The left pointer is the trailing pointer which keeps track of the current position of the target.
Whereas the mid pointer is calculated in each iteration of the loop as a function of the left and right pointers.
And the right pointer can overflow our array at the end of the loop.

*/

public class Leetcode35 {
  public static int searchInsert(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    int mid = 0;
    while (left <= right) {
      mid = (left + right) / 2;
      if (target == nums[mid])
        return mid;
      else if (target < nums[mid])
        right = mid - 1;
      else
        left = mid + 1;
    }
    return left;
  }

  public static void main(String[] args) {
    int nums[] = { 1, 3, 5, 6 };
    int target = 5;
    int ans = searchInsert(nums, target);
    System.out.println(ans);
  }

}
