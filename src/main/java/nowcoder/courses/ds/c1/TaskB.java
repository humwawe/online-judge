package nowcoder.courses.ds.c1;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[] a = in.nextInt(n);
    int lim = 1 << n;
    long[] sum = new long[lim];
    for (int i = 0; i < lim; i++) {
      for (int j = 0; j < n; j++) {
        if ((i >> j & 1) == 1) {
          sum[i] ^= a[j];
        }
      }
    }

    long[] sum1 = sosDp(n, sum);
    long[] sum2 = sosDp2(n, sum);


    for (int i = 0; i < m; i++) {
      int k = in.nextInt();
      int t = 0;
      for (int j = 0; j < k; j++) {
        int x = in.nextInt() - 1;
        t |= (1 << x);
      }
      out.println(sum1[t], sum2[t]);
    }
  }

  long[] sosDp(int n, long[] a) {
    int lim = 1 << n;
    // 初始化
    long[] sum = Arrays.copyOf(a, lim);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < lim; j++) {
        if (((j >> i) & 1) == 1) {
          sum[j] += sum[j - (1 << i)];
        }
      }
    }
    return sum;
  }

  long[] sosDp2(int n, long[] a) {
    int lim = 1 << n;
    // 初始化
    long[] sum = Arrays.copyOf(a, lim);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < lim; j++) {
        if (((j >> i) & 1) == 1) {
          sum[j - (1 << i)] += sum[j];
        }
      }
    }
    return sum;
  }
}
