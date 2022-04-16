package acwing.contest.weekly.c47;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashSet;
import java.util.Set;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.readLine();
    s = s.substring(1, s.length() - 1);
    String[] split = s.split(",");
    Set<String> set = new HashSet<>();
    for (String s1 : split) {
      if (s1 != null && !s1.isEmpty()) {
        set.add(s1.trim());
      }

    }
    out.println(set.size());
  }
}
