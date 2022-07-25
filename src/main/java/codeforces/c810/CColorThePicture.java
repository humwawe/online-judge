package codeforces.c810;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class CColorThePicture {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int k = in.nextInt();
    int[] a = new int[k];
    for (int i = 0; i < k; i++) {
      a[i] = in.nextInt();
    }
    Arrays.sort(a);
    rev(a);
    if (helper(n, m, a) || helper(m, n, a)) {
      out.println("Yes");
    } else {
      out.println("No");
    }

  }

  private boolean helper(int n, int m, int[] a) {
    long t = 0;
    boolean f = true;
    for (int i = 0; i < a.length; i++) {
      int y = a[i] / n;
      if (y >= 2) {
        t += y;
        if (y != 2) {
          f = false;
        }
      }
    }
    if (f) {
      if (m % 2 == 1) {
        return false;
      }
    }

    return t >= m;
  }

  private void rev(int[] a) {
    int i = 0;
    int j = a.length - 1;
    while (i < j) {
      int t = a[i];
      a[i] = a[j];
      a[j] = t;
      i++;
      j--;
    }
  }
}
