package acwing.contest.weekly.c41;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s1 = in.nextString();
    String s2 = in.nextString();

    StringBuilder res = new StringBuilder(s1).append(s2);

    for (int i = 0; i < s1.length(); i++) {
      for (int j = 0; j < s2.length(); j++) {
        StringBuilder tmp = new StringBuilder(s1.substring(0, i + 1));
        tmp.append(s2.substring(0, j + 1));
        if (res.toString().compareTo(tmp.toString()) > 0) {
          res = tmp;
        }
      }
    }
    out.println(res);
  }
}
