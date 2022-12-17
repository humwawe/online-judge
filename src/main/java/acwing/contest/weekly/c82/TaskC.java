package acwing.contest.weekly.c82;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    StringBuilder sb = new StringBuilder();
    sb.append("01".repeat(n));
    sb.deleteCharAt(sb.length() - 1);
    m -= n - 1;
    if (m < 0 || m > n - 1 + 4) {
      out.println(-1);
      return;
    }
    StringBuilder nsb = new StringBuilder();
    for (int i = 0; i < sb.length(); i++) {
      if (sb.charAt(i) == '1') {
        if (m > 0) {
          m--;
          nsb.append("11");
        } else {
          nsb.append("1");
        }
      } else {
        nsb.append("0");
      }
    }
    if (m == 0) {
      out.println(nsb);
    } else if (m == 1) {
      nsb.append("1");
      out.println(nsb);
    } else if (m == 2) {
      nsb.append("11");
      out.println(nsb);
    } else if (m == 3) {
      nsb.insert(0, "1");
      nsb.append("11");
      out.println(nsb);
    } else {
      nsb.insert(0, "11");
      nsb.append("11");
      out.println(nsb);
    }
  }
}
