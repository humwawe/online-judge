package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CManhattanSubarrays {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    int sum = 2 * n - 1;
    for (int i = 0; i + 2 < n; i++) {
      if (check(a[i], a[i + 1], a[i + 2])) {
        sum++;
      }
    }

    for (int i = 0; i + 3 < n; i++) {
      if (check(a[i], a[i + 1], a[i + 2]) && check(a[i], a[i + 1], a[i + 3]) && check(a[i], a[i + 2], a[i + 3]) && check(a[i + 1], a[i + 2], a[i + 3])) {
        sum++;
      }
    }
    out.println(sum);
  }

  private boolean check(int a, int b, int c) {
    return (a > b || b > c) && (a < b || b < c);
  }
}
