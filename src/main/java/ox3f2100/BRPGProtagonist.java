package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BRPGProtagonist {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int p = in.nextInt();
    int f = in.nextInt();
    int cnt1 = in.nextInt();
    int cnt2 = in.nextInt();
    int s = in.nextInt();
    int w = in.nextInt();

    if (s > w) {
      int t = cnt1;
      cnt1 = cnt2;
      cnt2 = t;
      t = s;
      s = w;
      w = t;
    }
    int res = 0;
    for (int i = 0; i <= cnt1 && i * s <= p; i++) {

      int t = i;

      t += Math.min(cnt2, (p - i * s) / w);

      int c1 = cnt1 - i;
      int c2 = cnt2 - (t - i);

      t += Math.min(c1, f / s);

      t += Math.min(c2, (f - s * Math.min(c1, f / s)) / w);

      res = Math.max(res, t);

    }
    out.println(res);
  }
}
