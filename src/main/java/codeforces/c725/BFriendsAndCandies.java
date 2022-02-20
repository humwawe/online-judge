package codeforces.c725;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BFriendsAndCandies {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    int sum = 0;
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      sum += a[i];
    }
    if (sum % n != 0) {
      out.println(-1);
      return;
    }
    int tmp = sum / n;
    int k = 0;
    for (int i = 0; i < n; i++) {
      if (a[i] > tmp) {
        k++;
      }
    }
    out.println(k);
  }
}
