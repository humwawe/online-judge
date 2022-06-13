package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AGoingHome {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    int N = (int) (5e6 + 5);
    int[] x = new int[N];
    int[] y = new int[N];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int sum = a[i] + a[j];
        if (x[sum] == 0 && y[sum] == 0) {
          x[sum] = i + 1;
          y[sum] = j + 1;
        } else if (x[sum] != i + 1 && x[sum] != j + 1 && y[sum] != i + 1 && y[sum] != j + 1) {
          out.println("YES");
          out.println(x[sum], y[sum], i + 1, j + 1);
          return;
        }
      }
    }
    out.println("NO");
  }
}
