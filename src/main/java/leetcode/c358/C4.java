package leetcode.c358;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author hum
 */
public class C4 {
  int n;

  public int maximumScore(List<Integer> nums, int k) {
    n = nums.size();
    int[] a = new int[n];
    int[] b = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = nums.get(i);
    }

    for (int i = 0; i < n; i++) {
      b[i] = helper(a[i]);
    }

    int[] left = new int[n];
    int[] right = new int[n];

    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < n; i++) {
      while (!stack.isEmpty() && b[i] > b[stack.peek()]) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        left[i] = -1;
      } else {
        left[i] = stack.peek();
      }
      stack.push(i);
    }
    stack.clear();

    for (int i = n - 1; i >= 0; i--) {
      while (!stack.isEmpty() && b[i] >= b[stack.peek()]) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        right[i] = n;
      } else {
        right[i] = stack.peek();
      }
      stack.push(i);
    }
    long[] c = new long[n];
    for (int i = 0; i < n; i++) {
      c[i] = (long) (right[i] - i) * (left[i] - i);
    }

    Integer[] idx = new Integer[n];
    Arrays.setAll(idx, i -> i);

    Arrays.sort(idx, (x, y) -> a[y] - a[x]);

    int mod = (int) (1e9 + 7);
    long res = 1;
    for (int ii = 0; ii < n; ii++) {
      int i = idx[ii];
      res = res * pow(a[i], Math.min(c[i], k), mod) % mod;
      k -= Math.min(c[i], k);
    }

    return (int) res;
  }

  long pow(long m, long k, long p) {
    long ret = 1;
    int x = 63 - Long.numberOfLeadingZeros(k);
    for (; x >= 0; x--) {
      ret = ret * ret % p;
      if (k << 63 - x < 0) {
        ret = ret * m % p;
      }
    }
    return ret;
  }

  private int helper(int x) {
    int res = 0;
    for (int i = 2; i <= x / i; i++) {
      if (x % i == 0) {
        while (x % i == 0) {
          x /= i;
        }
        res++;
      }
    }
    if (x > 1) {
      res++;
    }
    return res;
  }
}
