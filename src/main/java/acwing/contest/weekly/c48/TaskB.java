package acwing.contest.weekly.c48;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int x = in.nextInt();
    n = n % 6;
    String[] t = new String[]{"012", "102", "120", "210", "201", "021"};
    out.println(t[n].charAt(x));
  }
}
