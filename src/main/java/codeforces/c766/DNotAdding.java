package codeforces.c766;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DNotAdding {
  int N = (int) 1e6 + 5;
  int[] map = new int[N];

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();

    int[] a = new int[n];

    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      map[a[i]] = 1;
    }

    int cnt = 0;
    for (int i = 1; i < N; ++i) {
      if (check(i)) {
        ++cnt;
      }
    }
    out.println(cnt - n);
  }

  private boolean check(int i) {
    int t = 0;
    for (int j = i; j < N; j += i) {
      if (map[j] > 0) {
        t = gcd(t, j);
      }
    }
    return t == i;
  }

  int gcd(int a, int b) {
    return b != 0 ? gcd(b, a % b) : a;
  }
}
