package acwing.contest.weekly.c82;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    String s = in.nextString();
    int res = 0;
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == '.') {
        int j = i;
        int k = i;
        while (j >= 0 && s.charAt(j) == '.') {
          j--;
        }
        while (k < n && s.charAt(k) == '.') {
          k++;
        }
        if (j == -1 && k == n) {
          res++;
        } else if (j == -1) {
          if (s.charAt(k) == 'R') {
            res++;
          }
        } else if (k == n) {
          if (s.charAt(j) == 'L') {
            res++;
          }
        } else {
          if (s.charAt(j) == 'L' && s.charAt(k) == 'R') {
            res++;
          } else if (i - j == k - i) {
            res++;
          }
        }
      }
    }
    out.println(res);
  }
}
