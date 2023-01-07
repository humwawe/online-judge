package acwing.contest.weekly.c85;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    int k = in.nextInt();
    int[] w = new int[26];
    int max = 0;
    for (int i = 0; i < 26; i++) {
      w[i] = in.nextInt();
      max = Math.max(w[i], max);
    }
    long res = 0;
    if (max > 0) {
      for (int i = 0; i < s.length(); i++) {
        int c = s.charAt(i) - 'a';
        res += w[c] * (i + 1);
      }
      for (int i = 1; i <= k; i++) {
        res += max * (i + s.length());
      }
      out.println(res);
    } else {
      for (int i = 0; i < s.length(); i++) {
        int c = s.charAt(i) - 'a';
        res += w[c] * (i + 1 + k);
      }
      out.println(res);
    }

  }
}
