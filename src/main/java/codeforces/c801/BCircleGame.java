package codeforces.c801;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BCircleGame {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    if (n % 2 == 1) {
      out.println("Mike");
      return;
    }
    int min1 = Integer.MAX_VALUE;
    int min2 = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      if (i % 2 == 0) {
        min1 = Math.min(min1, a[i]);
      } else {
        min2 = Math.min(min2, a[i]);
      }
    }
    int x = 0;
    for (int i = 0; i < n; i += 2) {
      if (a[i] == min1) {
        x = i;
        break;
      }
    }
    int y = 0;
    for (int i = 1; i < n; i += 2) {
      if (a[i] == min2) {
        y = i;
        break;
      }

    }
    if (min1 < min2) {
      out.println("Joe");
    } else if (min1 > min2) {
      out.println("Mike");
    } else {
      if (x < y) {
        out.println("Joe");
      } else {
        out.println("Mike");
      }
    }


  }
}
