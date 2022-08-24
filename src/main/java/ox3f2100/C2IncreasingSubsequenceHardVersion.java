package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class C2IncreasingSubsequenceHardVersion {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    int l = 0;
    while (l + 1 < n && a[l + 1] > a[l]) {
      l++;
    }
    int r = n - 1;
    while (r - 1 >= 0 && a[r - 1] > a[r]) {
      r--;
    }

    int x = 0;
    int y = n - 1;
    StringBuilder sb = new StringBuilder();
    while (x <= l && y >= r) {
      if (a[x] < a[y]) {
        sb.append("L");
        x++;
      } else if (a[x] > a[y]) {
        sb.append("R");
        y--;
      } else {
        if (l - x + 1 >= y - r + 1) {
          sb.append("L".repeat(l - x + 1));
        } else {
          sb.append("R".repeat(y - r + 1));
        }
        out.println(sb.length());
        out.println(sb);
        return;
      }
    }

    if (x <= l) {
      sb.append("L".repeat(l - x + 1));
    }
    if (y >= r) {
      sb.append("R".repeat(y - r + 1));
    }

    out.println(sb.length());
    out.println(sb);

  }
}
