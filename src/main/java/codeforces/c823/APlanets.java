package codeforces.c823;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class APlanets {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int c = in.nextInt();
    int[] cnt = new int[105];
    for (int i = 0; i < n; i++) {
      cnt[in.nextInt()]++;
    }
    int res = 0;
    for (int i = 0; i < 105; i++) {
      res += Math.min(cnt[i], c);
    }
    out.println(res);
  }
}
