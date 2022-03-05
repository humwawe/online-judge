package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DZookeeperAndTheInfiniteZoo {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int q = in.nextInt();
    for (int i = 0; i < q; i++) {
      int u = in.nextInt();
      int v = in.nextInt();
      if (check(u, v)) {
        out.println("YES");
      } else {
        out.println("NO");
      }
    }
  }

  private boolean check(int u, int v) {
    if (u > v) {
      return false;
    }
    int a = 0;
    int b = 0;
    for (int i = 0; i < 31; i++) {
      if (((u >> i) & 1) == 1) {
        a++;
      }
      if (((v >> i) & 1) == 1) {
        b++;
      }
      if (b > a) {
        return false;
      }
    }
    return true;
  }
}
