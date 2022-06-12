package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DMaximumDistributedTree {
  int[] h, e, ne, size;
  int idx;
  int n;
  List<Long> list;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    int N = n + 5;
    int M = N * 2;
    h = new int[N];
    size = new int[N];
    e = new int[M];
    ne = new int[M];
    Arrays.fill(h, -1);
    idx = 0;

    for (int i = 0; i < n - 1; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      add(a, b);
      add(b, a);
    }

    list = new ArrayList<>();
    dfs(1, 1);
    int m = in.nextInt();
    int[] a = new int[m];
    for (int i = 0; i < m; i++) {
      a[i] = in.nextInt();
    }
    Arrays.sort(a);
    rev(a);

    list.sort((x, y) -> Long.compare(y, x));
    int mod = (int) (1e9 + 7);

    long res = 0;
    if (list.size() > m) {
      for (int i = 0; i < list.size(); i++) {
        long t = 1;
        if (i < m) {
          t = a[i];
        }
        res += t * list.get(i);
        res %= mod;
      }
      out.println(res);
    } else {
      int j = 0;
      long t = 1;
      while (m - j > list.size()) {
        t *= a[j];
        t %= mod;
        j++;
      }
      res = t * a[j] % mod * list.get(0) % mod;
      j++;
      for (int i = 1; i < list.size(); i++) {
        res += list.get(i) * a[j];
        j++;
        res %= mod;
      }
      out.println(res);
    }


  }

  private void rev(int[] a) {
    int i = 0;
    int j = a.length - 1;
    while (i < j) {
      int t = a[i];
      a[i] = a[j];
      a[j] = t;
      i++;
      j--;
    }
  }


  private void dfs(int u, int p) {
    size[u] = 1;
    for (int i = h[u]; i != -1; i = ne[i]) {
      int j = e[i];
      if (j == p) {
        continue;
      }
      dfs(j, u);
      size[u] += size[j];

      list.add((long) size[j] * (n - size[j]));
    }
  }

  void add(int a, int b) {
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
  }
}
