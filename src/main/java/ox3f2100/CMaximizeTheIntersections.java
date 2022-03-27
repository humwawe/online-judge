package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class CMaximizeTheIntersections {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    List<int[]> list = new ArrayList<>();
    boolean[] vis = new boolean[n * 2 + 1];
    for (int i = 0; i < k; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      list.add(new int[]{Math.min(a, b), Math.max(a, b)});
      vis[a] = true;
      vis[b] = true;
    }
    List<Integer> unused = new ArrayList<>();
    for (int i = 1; i <= n * 2; i++) {
      if (!vis[i]) {
        unused.add(i);
      }
    }
    for (int i = 0; i < n - k; i++) {
      list.add(new int[]{unused.get(i), unused.get(i + n - k)});
    }
    int res = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        res += intersect(list.get(i), list.get(j));
      }
    }
    out.println(res);

  }

  private int intersect(int[] a, int[] b) {
    return (a[0] < b[0] && b[0] < a[1] && a[1] < b[1]) || (b[0] < a[0] && a[0] < b[1] && b[1] < a[1]) ? 1 : 0;
  }
}
