package lanqiao.b1;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    int[] a = in.nextInt(n);
    Arrays.sort(a);
    int l = 0;
    int r = a[n - 1] - a[0];
    while (l < r) {
      int mid = l + r >> 1;
      int cnt = 0;
      for (int i = 0; i < n; i++) {
        int j = i;
        while (j + 1 < n && a[j + 1] - a[i] <= mid) {
          j++;
        }
        cnt++;
        i = j;
      }
      if (cnt <= k) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    out.println(l);

  }
}
