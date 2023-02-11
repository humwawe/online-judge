package acwing.contest.weekly.c90;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    String s = in.nextString();
    int len = n;
    for (int i = 1; i < s.length(); i++) {
      if (s.startsWith(s.substring(i))) {
        len = i;
        break;
      }
    }
    int x = n - len;
    out.println(s + s.substring(x).repeat(k - 1));
  }
}
