package acwing.contest.weekly.c26;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int res = 1;
    for (int i = 0; i < 7; i++) {
      char c = in.nextCharacter();
      if (i == 0) {
        continue;
      }
      if (c == '1') {
        res += 10;
      } else {
        res += c - '0';
      }
    }
    out.println(res);
  }
}
