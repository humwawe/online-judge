package lanqiao.b2;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    int[] a = in.nextInt(n);
    int[] diff = new int[n - 1];
    long sum = 0;
    for (int i = 0; i < n - 1; i++) {
      diff[i] = a[i + 1] - a[i];
      sum += diff[i];

    }

    Arrays.sort(diff);
    int idx = n - 2;
    for (int i = k - 2; i >= 0; i--) {
      sum -= diff[idx];
      idx--;
    }
    out.println(sum);
  }
}
