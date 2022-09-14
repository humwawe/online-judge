package acwing.contest.weekly.c66;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Random;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    int N = 105;
    int[] cnt = new int[N];


    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      cnt[a[i]]++;
    }

    int t = 0;
    for (int i = 1; i < N; i++) {
      if (cnt[i] % 2 == 1) {
        t++;
      }
    }
    if (t % 2 == 0) {
      int idx = 0;
      out.println("YES");
      for (int i = 0; i < n; i++) {
        if (cnt[a[i]] == -1) {
          out.print('B');
        } else if (cnt[a[i]] == -2) {
          out.print('A');
        } else if (cnt[a[i]] % 2 == 1) {
          if (idx++ % 2 == 0) {
            out.print('A');
            cnt[a[i]] = -1;
          } else {
            out.print('B');
            cnt[a[i]] = -2;
          }
        } else {
          out.print('B');
        }

      }
    } else {
      boolean f = false;
      int x = 0;
      for (int i = 1; i < N; i++) {
        if (cnt[i] % 2 == 1 && cnt[i] > 1) {
          f = true;
          x = i;
        }
      }
      if (f) {
        cnt[x]--;
        int idx = 0;
        out.println("YES");
        for (int i = 0; i < n; i++) {
          if (cnt[a[i]] == -1) {
            out.print('B');
          } else if (cnt[a[i]] == -2) {
            out.print('A');
          } else if (cnt[a[i]] % 2 == 1) {
            if (idx++ % 2 == 0) {
              out.print('A');
              cnt[a[i]] = -1;
            } else {
              out.print('B');
              cnt[a[i]] = -2;
            }
          } else {
            out.print('B');
          }
        }
      } else {

        for (int i = 1; i < N; i++) {
          if (cnt[i] % 2 == 0 && cnt[i] > 2) {
            f = true;
            x = i;
          }
        }

        if (f) {
          cnt[x]--;
          int idx = 0;
          out.println("YES");
          for (int i = 0; i < n; i++) {
            if (cnt[a[i]] == -1) {
              out.print('B');
            } else if (cnt[a[i]] == -2) {
              out.print('A');
            } else if (cnt[a[i]] % 2 == 1) {
              if (idx++ % 2 == 0) {
                out.print('A');
                cnt[a[i]] = -1;
              } else {
                out.print('B');
                cnt[a[i]] = -2;
              }
            } else {
              out.print('B');
            }
          }

        } else {
          out.println("NO");
        }

      }
    }
  }
}
