package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class BCandyBoxes {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    Arrays.sort(a);

    if (n == 0) {
      out.println("YES");
      out.println(1);
      out.println(1);
      out.println(3);
      out.println(3);
      return;
    }
    if (n == 1) {
      out.println("YES");
      out.println(a[0]);
      out.println(3 * a[0]);
      out.println(3 * a[0]);
      return;
    }
    if (n == 2) {
      if (3 * a[0] < a[1]) {
        out.println("NO");
        return;
      }
      out.println("YES");
      out.println(4 * a[0] - a[1]);
      out.println(3 * a[0]);
      return;
    }
    if (n == 3) {
      if (a[1] + a[2] == 4 * a[0]) {
        out.println("YES");
        out.println(a[0] * 3);
      } else if (a[2] == 3 * a[0]) {
        out.println("YES");
        out.println(a[0] + a[2] - a[1]);
      } else if (a[2] == (a[0] + a[1] - a[2]) * 3) {
        out.println("YES");
        out.println(a[0] + a[1] - a[2]);
      } else {
        out.println("NO");
      }
      return;
    }
    if (a[0] + a[3] == a[1] + a[2] && a[3] == a[0] * 3) {
      out.println("YES");
    } else {
      out.println("NO");
    }

  }
}
