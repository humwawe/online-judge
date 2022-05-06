package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DMergeSort {
  int n, k;
  int[] a;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    k = in.nextInt();
    if (k % 2 == 0) {
      out.println(-1);
      return;
    }

    a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = i + 1;
    }
    k--;
    dfs(0, n);
    if (k > 0) {
      out.println(-1);
      return;
    }
    out.println(a);
  }

  private void dfs(int l, int r) {
    if (l + 1 >= r || k == 0) {
      return;
    }
    k -= 2;
    int mid = l + r >> 1;
    int t = a[mid - 1];
    a[mid - 1] = a[mid];
    a[mid] = t;
    dfs(l, mid);
    dfs(mid, r);
  }
}
