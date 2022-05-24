package codeforces.e129;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class AGameWithCards {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    int m = in.nextInt();
    int[] b = new int[m];
    for (int i = 0; i < m; i++) {
      b[i] = in.nextInt();
    }
    Arrays.sort(a);
    Arrays.sort(b);
    if (a[n - 1] >= b[m - 1]) {
      out.println("Alice");
    } else {
      out.println("Bob");
    }

    if (a[n - 1] <= b[m - 1]) {
      out.println("Bob");
    } else {
      out.println("Alice");
    }
  }
}
