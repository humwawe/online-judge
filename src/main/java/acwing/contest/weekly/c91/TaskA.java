package acwing.contest.weekly.c91;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    String s = String.valueOf(n);
    List<String> res = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != '0') {
        res.add(s.charAt(i) + "" + "0".repeat(s.length() - i - 1));
      }
    }
    out.println(res.size());
    for (String re : res) {
      out.print(re, "");
    }
    out.println();
  }
}
