package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class CEpidemicInMonstropolis {
  int[] a;
  int[] sum;
  int n;
  int k;
  int[] b;
  List<int[]> res = new ArrayList<>();

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    a = new int[n];
    sum = new int[n + 1];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      sum[i + 1] = sum[i] + a[i];
    }
    k = in.nextInt();
    b = new int[k];
    for (int i = 0; i < k; i++) {
      b[i] = in.nextInt();
    }
    int l = 0;
    int r = 1;
    for (int i = 0; i < k; i++) {
      boolean f = false;
      for (; r <= n; r++) {
        if (sum[r] - sum[l] == b[i]) {
          if (helper(l, r - 1, i)) {
            f = true;
            break;
          }
        }
      }
      if (!f) {
        out.println("NO");
        return;
      }
      l = r;
    }
    if (r != n) {
      out.println("NO");
      return;
    }
    out.println("YES");
    for (int[] re : res) {
      out.println(re[0] + 1, re[1] == 0 ? 'L' : 'R');
    }
  }

  private boolean helper(int l, int r, int cnt) {
    List<Integer> list = new ArrayList<>();
    for (int i = l; i <= r; i++) {
      list.add(a[i]);
    }
    while (list.size() > 1) {
      int max = 0;
      int idx = -1;
      for (int i = 0; i < list.size(); i++) {
        if (list.get(i) >= max) {
          max = list.get(i);
          if (i > 0 && list.get(i) > list.get(i - 1)) {
            idx = i;
          } else if (i < list.size() - 1 && list.get(i) > list.get(i + 1)) {
            idx = i;
          }
        }
      }
      if (idx == -1) {
        return false;
      }
      if (idx > 0 && list.get(idx) > list.get(idx - 1)) {
        res.add(new int[]{idx + cnt, 0});
        list.set(idx - 1, list.get(idx) + list.get(idx - 1));
        list.remove(idx);
      } else if (idx < list.size() - 1 && list.get(idx) > list.get(idx + 1)) {
        res.add(new int[]{idx + cnt, 1});
        list.set(idx + 1, list.get(idx) + list.get(idx + 1));
        list.remove(idx);
      } else {
        return false;
      }
    }
    return true;
  }

}
