package codeforces.c738;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AMochaAndMath {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] cnt = new int[32];
    for (int i = 0; i < n; i++) {
      int num = in.nextInt();
      for (int j = 0; j < 32; j++) {
        if (((num >> j) & 1) == 1) {
          cnt[j]++;
        }
      }
    }
    long res = 0;
    for (int i = 0; i < 32; i++) {
      if (cnt[i] == n) {
        res += 1 << i;
      }
    }
    out.println(res);
  }
}
