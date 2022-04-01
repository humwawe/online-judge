package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class CCrazyDiamond {
  int[] a;
  int[] b;
  int n;
  List<int[]> res = new ArrayList<>();

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    a = new int[n + 1];
    b = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      a[i] = in.nextInt();
      b[a[i]] = i;
    }

    for (int i = 1; i <= n; i++) {
      if (a[i] != i) {
        helper(i, b[i]);
      }
    }
    out.println(res.size());
    for (int[] e : res) {
      out.println(e[0], e[1]);
    }
  }

  private void helper(int i, int j) {
    if (Math.abs(i - j) * 2 >= n) {
      res.add(new int[]{i, j});
    } else if (i - 1 >= n / 2) {
      res.add(new int[]{i, 1});
      res.add(new int[]{1, j});
      res.add(new int[]{i, 1});
    } else if (n - j >= n / 2) {
      res.add(new int[]{i, n});
      res.add(new int[]{j, n});
      res.add(new int[]{i, n});
    } else {
      res.add(new int[]{i, n});
      res.add(new int[]{n, 1});
      res.add(new int[]{1, j});
      res.add(new int[]{1, n});
      res.add(new int[]{i, n});
    }
    swap(i, j);
  }

  private void swap(int i, int j) {
    int t = a[i];
    a[i] = a[j];
    b[a[i]] = i;
    a[j] = t;
    b[a[j]] = j;
  }
}
