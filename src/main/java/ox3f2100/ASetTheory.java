package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashSet;
import java.util.Set;

public class ASetTheory {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    int[] b = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    boolean[] vis = new boolean[(int) (2e6 + 5)];
    Set<Integer> set = new HashSet<>();
    int cnt = 0;
    f:
    for (int i = 1; i <= 1e6; i++) {
      for (int j = 0; j < n; j++) {
        if (vis[a[j] + i]) {
          continue f;
        }
      }
      b[cnt++] = i;
      for (int j = 0; j < n; j++) {
        vis[a[j] + i] = true;
      }
      if (cnt == n) {
        break;
      }
    }
    out.println("YES");
    out.println(b);
  }
}
