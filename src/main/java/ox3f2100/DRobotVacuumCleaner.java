package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class DRobotVacuumCleaner {

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    String[] a = new String[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextString();
    }
    Arrays.sort(a, (x, y) -> Long.compare(helper(y + x), helper(x + y)));
    int s = 0;
    long res = 0;
    for (int i = 0; i < n; i++) {
      for (char c : a[i].toCharArray()) {
        if (c == 's') {
          s++;
        } else {
          res += s;
        }
      }
    }
    out.println(res);

  }

  private long helper(String x) {
    long res = 0;
    int s = 0;
    for (char c : x.toCharArray()) {
      if (c == 's') {
        s++;
      } else {
        res += s;
      }
    }
    return res;
  }
}
