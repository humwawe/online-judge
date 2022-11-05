package acwing.contest.weekly.c76;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int N = 500;
    int[] cnt = new int[N];
    String s = in.nextString();
    for (int i = 0; i < s.length(); i++) {
      cnt[s.charAt(i)]++;
    }
    long res = s.length();
    for (int i = 0; i < N; i++) {
      res += (long) cnt[i] * (cnt[i] - 1);
    }
    out.println(res);
  }
}
