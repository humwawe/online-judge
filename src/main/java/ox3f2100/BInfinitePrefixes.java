package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BInfinitePrefixes {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int x = in.nextInt();
    String s = in.nextString();
    int sum = 0;
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == '0') {
        sum++;
      } else {
        sum--;
      }
    }

    int cnt = 0;
    int res = 0;

    for (int i = 0; i < n; i++) {
      if (sum == 0) {
        if (cnt == x) {
          out.println(-1);
          return;
        }
      } else {
        if ((long) (x - cnt) * sum >= 0 && (x - cnt) % sum == 0) {
          res++;
        }
      }

      if (s.charAt(i) == '0') {
        cnt++;
      } else {
        cnt--;
      }
    }
    out.println(res);
  }
}
