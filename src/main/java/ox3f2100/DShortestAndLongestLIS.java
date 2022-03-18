package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DShortestAndLongestLIS {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    String s = in.nextString();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = n - i;
    }

    for (int i = 0; i < n - 1; i++) {
      if (s.charAt(i) == '<') {
        int j = i;
        while (j + 1 < n - 1 && s.charAt(j + 1) == '<') {
          j++;
        }
        reverse(a, i, j);
        i = j;
      }
    }
    out.println(a);

    for (int i = 0; i < n; i++) {
      a[i] = i + 1;
    }

    for (int i = 0; i < n - 1; i++) {
      if (s.charAt(i) == '>') {
        int j = i;
        while (j + 1 < n - 1 && s.charAt(j + 1) == '>') {
          j++;
        }
        reverse(a, i, j);
        i = j;
      }
    }
    out.println(a);
  }

  private void reverse(int[] a, int i, int j) {
    int x = i;
    int y = j + 1;
    while (x < y) {
      int t = a[x];
      a[x] = a[y];
      a[y] = t;
      x++;
      y--;
    }

  }
}
