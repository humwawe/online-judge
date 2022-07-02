package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DMultiset {

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int q = in.nextInt();
    int[] num = new int[n + 1];
    int[] fa = new int[n / 1000 + 1];
    int max = 0;

    for (int i = 0; i < n; i++) {
      int x = in.nextInt();
      num[x]++;
      fa[(x - 1) / 1000]++;
      max = Math.max(max, x);
    }
    for (int i = 0; i < q; i++) {
      int x = in.nextInt();
      if (x > 0) {
        num[x]++;
        fa[(x - 1) / 1000]++;
        max = Math.max(max, x);
      } else {
        x = -x;
        int idx = 0;
        while (x > fa[idx]) {
          x -= fa[idx];
          idx++;
        }

        for (int j = idx * 1000 + 1; j <= (idx + 1) * 1000; j++) {
          if (x > num[j]) {
            x -= num[j];
          } else {
            num[j]--;
            fa[(j - 1) / 1000]--;
            break;
          }
        }
      }
    }
    for (int i = 1; i <= max; i++) {
      if (num[i] > 0) {
        out.println(i);
        return;
      }
    }
    out.println(0);

  }
}
