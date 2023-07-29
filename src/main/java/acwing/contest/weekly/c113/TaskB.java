package acwing.contest.weekly.c113;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s1 = helper(in.nextString());
    String s2 = helper(in.nextString());
    String s3 = helper(in.nextString());
    int q = in.nextInt();
    String[] s = new String[6];
    s[0] = s1 + s2 + s3;
    s[1] = s1 + s3 + s2;
    s[2] = s2 + s1 + s3;
    s[3] = s2 + s3 + s1;
    s[4] = s3 + s1 + s2;
    s[5] = s3 + s2 + s1;
    f:
    for (int i = 0; i < q; i++) {
      String x = helper(in.nextString());
      for (int j = 0; j < s.length; j++) {
        if (x.equals(s[j])) {
          out.println("ACC");
          continue f;
        }
      }
      out.println("WA");
    }

  }

  private String helper(String s1) {
    s1 = s1.toLowerCase();
    s1 = s1.replaceAll("-", "");
    s1 = s1.replaceAll(";", "");
    s1 = s1.replaceAll("_", "");
    return s1;
  }
}
