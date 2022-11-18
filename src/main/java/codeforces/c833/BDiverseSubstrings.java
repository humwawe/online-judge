package codeforces.c833;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BDiverseSubstrings {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    String s = in.nextString();
    long res = 0;
    int[] cnt = new int[10];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < 10; j++) {
        cnt[j] = 0;
      }
      int num = 0;
      int max = 0;
      for (int j = i; j <= 100 + i && j < n; j++) {
        int x = s.charAt(j) - '0';
        cnt[x]++;
        max = Math.max(max, cnt[x]);
        if (cnt[x] == 1) {
          num++;
        }
        if (max <= num) {
          res++;
        }
      }
    }
    out.println(res);
  }
}
