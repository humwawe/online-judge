package nowcoder.c79;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    String s = String.valueOf(n);
    int res = s.length();
    int cnt = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      if ((s.charAt(i) - '0') % 2 != 0) {
        cnt++;
      } else {
        break;
      }
    }
    out.println(Math.min(res, cnt));
  }
}
