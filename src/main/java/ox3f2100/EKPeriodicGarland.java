package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class EKPeriodicGarland {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    int sum = 0;
    String s = in.nextString();
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == '1') {
        sum++;
      }
    }
    int res = (int) 1e8;
    for (int i = 0; i < k; i++) {
      int tmp = 0;
      int t = 0;
      for (int j = i; j < n; j += k) {
        int x = 1;
        if (s.charAt(j) != '1') {
          x = -1;
        }
        t += x;
        if (t < 0) {
          t = 0;
        }
        tmp = Math.max(tmp, t);
      }
      res = Math.min(res, sum - tmp);
    }
    out.println(res);
  }
}
