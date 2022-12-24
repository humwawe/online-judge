package acwing.contest.weekly.c83;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashSet;
import java.util.Set;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    Set<Character> set = new HashSet<>();
    String s = in.nextString();
    for (int i = 0; i < s.length(); i++) {
      set.add(s.charAt(i));
    }
    if (set.size() % 2 == 0) {
      out.println("even");
    } else {
      out.println("odd");
    }
  }
}
