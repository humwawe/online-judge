package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CTokitsukazeAndTwoColorfulTapes {
  int n;
  int[] p;
  int[] size;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    p = new int[n + 1];
    size = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      p[i] = i;
      size[i] = 1;
    }
    int[] a = new int[n];
    int[] b = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    for (int i = 0; i < n; i++) {
      b[i] = in.nextInt();
    }

    for (int i = 0; i < n; i++) {
      union(a[i], b[i]);
    }

    int cnt1 = 0;
    int cnt2 = 0;
    for (int i = 1; i <= n; i++) {
      if (find(i) == i) {
        cnt1 += size[find(i)] / 2;
        cnt2 += size[find(i)] / 2;
      }
    }
    long res = 0;
    for (int i = 0; i < cnt1; i++) {
      res += 2L * (n - i);
    }
    for (int i = 0; i < cnt2; i++) {
      res += -2L * (i + 1);
    }
    out.println(res);
  }

  int find(int x) {
    if (p[x] != x) {
      p[x] = find(p[x]);
    }
    return p[x];
  }

  void union(int a, int b) {
    if (find(a) == find(b)) {
      return;
    }
    size[find(b)] += size[find(a)];
    p[find(a)] = find(b);
  }
}
