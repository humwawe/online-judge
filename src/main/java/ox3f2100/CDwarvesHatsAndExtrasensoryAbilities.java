package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CDwarvesHatsAndExtrasensoryAbilities {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int l = 0;
    int r = 1000000000;
    out.println(l, 1);
    out.flush();
    String c = in.nextString();
    for (int i = 1; i < n; i++) {
      int mid = l + r >> 1;
      out.println(mid, 1);
      out.flush();
      String cur = in.nextString();
      if (cur.equals(c)) {
        l = mid;
      } else {
        r = mid;
      }
    }
    out.println(l, 0, l + 1, 2);
  }
}
