package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BColorTheFence {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int v = in.nextInt();
    int[] a = new int[10];
    for (int i = 1; i <= 9; i++) {
      a[i] = in.nextInt();
    }

    int idx = 0;
    int min = (int) 1e8;
    for (int i = 1; i <= 9; i++) {
      if (a[i] < min) {
        min = a[i];
        idx = i;
      }
    }
    int cnt = v / a[idx];
    if (cnt == 0) {
      out.println(-1);
      return;
    }
    StringBuilder sb = new StringBuilder(("" + idx).repeat(cnt));
    int sum = 0;

    f:
    for (int i = 0; i < sb.length(); i++) {

      for (int j = 9; j > idx; j--) {
        if (sum + (cnt - i - 1) * min + a[j] <= v) {
          sb.setCharAt(i, (char) (j + '0'));
          sum += a[j];
          continue f;
        }
      }

      break;
    }
    out.println(sb);
  }
}
