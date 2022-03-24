import java.util.ArrayList;

/* 
Sliding window:
The sliding window technique is used to find a consecutive subarray or substring.
It may have a fixed size or variable size.
Time complexity: O(n)
Space complexity: O(1)
*/

/* 
To solve this problem we need to keep in mind two things. One that we will use the sliding window technique, and
the other is that we need to keep track of the position of the window.

Description:
1. The outer while loop iterates through the entire substring. Keeping in mind that the end of the window is what does
the iteration. Once the end of the window reaches the end of the string, the while loop ends and we get the max.
2. Everytime we add a new character to the window, we can evaluate if the size of the substring has increased with
the previous max. If it has, we update the max.

Pseudocode:
1. initialize all the variables(max, start, end) to 0
2. while end < s.length
    a. if: the substring does not contain the character then add to the substring and evaluate the max
    b. else: remove the first character of the substring until it doesnt contain the desired character
       once all the desired character is removed add the desired character to the substring.
    c. increase the end by one to keep the window moving
*/
public class Leetcode3 {

  static int longestSubstring(String s) {
    ArrayList<Character> substring = new ArrayList<>();
    int max = 0;
    int window_start = 0;
    int window_end = 0;

    while (window_end < s.length()) {
      if (!substring.contains(s.charAt(window_end))) {
        substring.add(s.charAt(window_end));
        max = Math.max(max, substring.size());
      } else {
        while (substring.contains(s.charAt(window_end))) {
          substring.remove(0);
          window_start = window_start + 1;
        }
        substring.add(s.charAt(window_end));
      }
      window_end++;
    }
    return max;
  }

  public static void main(String[] args) {
    // input:
    String s = "a";
    // output: 3
    int ans = longestSubstring(s);
    System.out.println(ans);
  }
}
