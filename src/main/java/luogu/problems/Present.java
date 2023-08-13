package luogu.problems;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class Present {
  OutputWriter out;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = in.nextInt(n);
    this.out = out;
    int[] b = new int[n];
    int res = 0;
    for (int i = 0; i <= 25; i++) {
      for (int j = 0; j < n; j++) {
        b[j] = a[j] % (1 << (i + 1));
      }
      Arrays.sort(b);
      int cnt = helper(b, 1 << i, (1 << (i + 1)) - 1) ^ helper(b, 3 << i, (1 << (i + 2)) - 2);
      res |= cnt * (1 << i);
    }
    out.println(res);

  }

  private int helper(int[] b, int i, int j) {
    long cnt = h(b, j) - h(b, i - 1);
    return (int) (cnt % 2);
  }

  private long h(int[] b, int v) {
    int j = b.length - 1;
    long res = 0;
    for (int i = 0; i < b.length; i++) {
      while (j >= 0 && b[i] + b[j] > v) {
        j--;
      }
      if (j <= i) {
        break;
      }
      res += j - i;
    }
    return res;
  }
}
