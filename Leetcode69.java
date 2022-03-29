/* 
Sqrt(x) - https://leetcode.com/problems/sqrtx/
In this problem we need to find the square root of a number without using the sqrt function or math library.
We can use binary search to find the square root by defining out start pointer to 0 and end pointer to the target.
After every iteration the mid pointer is calculated as a function of the left and right pointers and it sets the new right or left pointer as follows:
    If the mid pointer squared is less than the target, then the left pointer is set to mid + 1.
    If the mid point squared is greater than the target, then the right pointer is set to mid - 1.
    If the mid pointer squared is equal to the target, then we return the mid pointer.

In case is not found we return the right pointer since it is the last position of the target.
*/

public class Leetcode69 {
  public static int mySqrt(int x) {
    int start = 0;
    int end = x;
    int mid = 0;
    int mid_sq = 0;
    while (start <= end) {
      mid = (start + end) / 2;
      mid_sq = mid * mid;
      if (mid_sq == x) {
        return mid;
      } else if (mid_sq < x) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }

    }
    return end;
  }

  public static void main(String[] args) {
    int x = 25;
    int ans = mySqrt(x);
    System.out.println(ans);
  }

}
