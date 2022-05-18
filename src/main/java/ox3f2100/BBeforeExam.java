package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BBeforeExam {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    int m = n / k;
    int[] a = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      a[i] = in.nextInt();
    }

    boolean[] vis = new boolean[n + 1];
    double min = 1e8;
    double max = 0;
    int q = in.nextInt();
    for (int i = 0; i < q; i++) {
      int sum = 0;
      for (int j = 0; j < m; j++) {
        int x = in.nextInt();
        vis[x] = true;
        sum += a[x];
      }
      min = Math.min(min, (double) sum / m);
      max = Math.max(max, (double) sum / m);
    }
    List<Integer> list = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      if (!vis[i]) {
        list.add(a[i]);
      }
    }
    Collections.sort(list);
    if (list.size() > n - k * m) {
      int sum = 0;
      for (int i = 0; i < m; i++) {
        sum += list.get(i);
      }
      min = Math.min(min, (double) sum / m);

      sum = 0;
      for (int i = list.size() - 1; i >= list.size() - m; i--) {
        sum += list.get(i);
      }
      max = Math.max(max, (double) sum / m);
      out.println(min, max);
    } else {
      out.println(min, max);
    }

  }
}
