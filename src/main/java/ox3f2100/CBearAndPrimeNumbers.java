package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CBearAndPrimeNumbers {
  int N = (int) 1e7 + 5;
  int[] map = new int[N];
  long[] sum = new long[N];

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();

    for (int i = 0; i < n; i++) {
      int x = in.nextInt();
      map[x]++;
    }

    getPrimesQuick(N);


    int m = in.nextInt();
    for (int i = 0; i < m; i++) {
      int l = in.nextInt();
      int r = in.nextInt();
      l = Math.min(l, N - 2);
      r = Math.min(r, N - 2);
      out.println(sum[r] - sum[l - 1]);
    }
  }


  void getPrimesQuick(int n) {
    boolean[] vis = new boolean[n + 1];
    for (int i = 2; i < n; i++) {
      if (vis[i]) {
        sum[i] = sum[i - 1];
        continue;
      }
      int t = 0;
      for (int j = i; j < n; j += i) {
        vis[j] = true;
        t += map[j];
      }
      sum[i] = sum[i - 1] + t;
    }
  }
}
