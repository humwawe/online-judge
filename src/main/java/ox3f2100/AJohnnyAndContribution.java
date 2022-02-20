package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AJohnnyAndContribution {
  int N = (int) 5e5 + 5;
  int M = 2 * N;
  int[] h = new int[N];
  int[] e = new int[M];
  int[] ne = new int[M];
  int idx;
  int n, m;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    Arrays.fill(h, -1);
    idx = 0;
    n = in.nextInt();
    m = in.nextInt();
    for (int i = 0; i < m; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      add(a, b);
      add(b, a);
    }
    int[] p = new int[n];
    Integer[] idx = new Integer[n];
    for (int i = 0; i < n; i++) {
      p[i] = in.nextInt();
      idx[i] = i;
    }
    int[] num = new int[n + 1];
    Arrays.fill(num, 1);
    Arrays.sort(idx, Comparator.comparingInt(x -> p[x]));
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int u = idx[i] + 1;
      if (num[u] != p[idx[i]]) {
        out.println(-1);
        return;
      }
      for (int v = h[u]; v != -1; v = ne[v]) {
        int j = e[v];
        if (num[j] == p[idx[i]]) {
          num[j]++;
        }
      }
      res.add(u);
    }
    for (Integer i : res) {
      out.print(i + " ");
    }
    out.println();


  }

  void add(int a, int b) {
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
  }
}
