package leetcode.c364;

import java.util.List;
import java.util.Stack;

/**
 * @author hum
 */
public class C3 {
  public long maximumSumOfHeights(List<Integer> maxHeights) {
    int n = maxHeights.size();
    long[] pre = new long[n];
    pre[0] = maxHeights.get(0);
    Stack<Integer> stack = new Stack<>();
    stack.push(0);
    for (int i = 1; i < n; i++) {
      while (!stack.isEmpty() && maxHeights.get(stack.peek()) > maxHeights.get(i)) {
        stack.pop();
      }

      if (stack.isEmpty()) {
        pre[i] = (long) (i + 1) * maxHeights.get(i);
      }
      if (!stack.isEmpty()) {
        pre[i] = (long) (i - stack.peek()) * maxHeights.get(i) + pre[stack.peek()];

      }

      stack.push(i);
    }

    long[] suf = new long[n];
    suf[n - 1] = maxHeights.get(n - 1);
    stack.clear();
    stack.push(n - 1);
    for (int i = n - 2; i >= 0; i--) {

      while (!stack.isEmpty() && maxHeights.get(stack.peek()) > maxHeights.get(i)) {
        stack.pop();
      }

      if (stack.isEmpty()) {
        suf[i] = (long) (n - i) * maxHeights.get(i);
      } else {
        suf[i] = (long) (stack.peek() - i) * maxHeights.get(i) + suf[stack.peek()];
      }
      stack.push(i);
    }
    long res = 0;
    for (int i = 0; i < n; i++) {
      res = Math.max(res, pre[i] + suf[i] - maxHeights.get(i));
    }
    return res;

  }
}
