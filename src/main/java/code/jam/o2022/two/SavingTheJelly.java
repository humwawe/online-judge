package code.jam.o2022.two;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class SavingTheJelly {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    out.printf("Case #%d: ", testNumber);
    int n = in.nextInt();
    long[][] a = new long[n][2];
    for (int i = 0; i < n; i++) {
      a[i][0] = in.nextInt();
      a[i][1] = in.nextInt();
    }
    long[][] b = new long[n + 1][2];
    for (int i = 0; i <= n; i++) {
      b[i][0] = in.nextInt();
      b[i][1] = in.nextInt();
    }

    long[][] d = new long[n][n + 1];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n + 1; j++) {
        d[i][j] = (a[i][0] - b[j][0]) * (a[i][0] - b[j][0]) + (a[i][1] - b[j][1]) * (a[i][1] - b[j][1]);
      }
    }
    int[] s = new int[n];
    for (int i = 0; i < n; i++) {
      s[i] = i;
    }

    do {
      int[] x = s.clone();
      boolean[] vis = new boolean[n + 1];
      int[] res = new int[n];
      boolean flag = true;
      for (int i = 0; i < n; i++) {
        int cur = x[i];
        long dist = (long) 8e18;
        int midIdx = -1;
        for (int j = 0; j < n + 1; j++) {
          if (vis[j]) {
            continue;
          }
          if (d[cur][j] <= dist) {
            dist = d[cur][j];
            midIdx = j;
          }
        }
        if (midIdx == 0) {
          flag = false;
          break;
        }
        vis[midIdx] = true;
        res[cur] = midIdx;
      }
      if (flag) {
        out.println("POSSIBLE");
        for (int i = 0; i < n; i++) {
          out.println(x[i] + 1, res[x[i]] + 1);
        }
        return;
      }

    } while (nextPermutation(s));

    out.println("IMPOSSIBLE");

  }

  public boolean nextPermutation(int[] s) {
    int n = s.length;
    for (int i = n - 2; i >= 0; i--) {
      if (s[i] < s[i + 1]) {
        reverse(s, i + 1, n - 1);
        for (int j = i + 1; ; j++) {
          if (s[j] > s[i]) {
            int tmp = s[j];
            s[j] = s[i];
            s[i] = tmp;
            return true;
          }
        }
      }
    }
    return false;
  }

  public void reverse(int[] data, int l, int r) {
    while (l < r) {
      int tmp = data[l];
      data[l] = data[r];
      data[r] = tmp;
      l++;
      r--;
    }
  }
}
