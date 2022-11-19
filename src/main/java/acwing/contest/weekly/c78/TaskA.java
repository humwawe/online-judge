package acwing.contest.weekly.c78;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashSet;
import java.util.Set;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    Set<String> set = new HashSet<>();
    int n = in.nextInt();
    for (int i = 0; i < n; i++) {
      String a = in.nextString();
      String b = in.nextString();
      set.add(a + "||" + b);
    }
    out.println(set.size());
  }
}
