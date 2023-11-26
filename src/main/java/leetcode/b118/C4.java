package leetcode.b118;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author hum
 */
public class C4 {
  public int findMaximumLength(int[] nums) {
    Deque<Integer> deque = new ArrayDeque<>();
    int n = nums.length;
    long[] sum = new long[n + 1];
    for (int i = 0; i < n; i++) {
      sum[i + 1] = sum[i] + nums[i];
    }
    int j = 0;
    int[] dp = new int[n + 1];
    long[] last = new long[n + 1];
    for (int i = 1; i <= n; i++) {
      while (!deque.isEmpty() && sum[deque.peekFirst()] + last[deque.peekFirst()] <= sum[i]) {
        j = deque.pollFirst();
      }
      dp[i] = dp[j] + 1;
      last[i] = sum[i] - sum[j];

      while (!deque.isEmpty() && sum[deque.peekLast()] + last[deque.peekLast()] >= sum[i] + last[i]) {
        deque.pollLast();
      }
      deque.addLast(i);
    }
    return dp[n];
  }
}
