package best.coder.o2022.one.a;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.*;

public class Task1 {
  int[] p;
  int[] size;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[][] a = new int[n][n];
    p = new int[n];
    size = new int[n];
    for (int i = 0; i < n; i++) {
      p[i] = i;
      size[i] = 1;
    }

    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        a[i][j] = in.nextInt();
        if (i != j) {
          set.add(a[i][j]);
        }
      }
    }
    int cnt = 0;
    List<Integer> list = new ArrayList<>(set);
    Collections.sort(list);

    Set<Integer> res = new HashSet<>();
    while (size[0] != n) {
      int min = list.get(cnt);
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (a[i][j] == min) {
            if (find(i) != find(j)) {
              int x = Math.min(find(i), find(j));
              int y = Math.max(find(i), find(j));
              size[x] += size[y];
              p[y] = x;
              res.add(Math.min(i, j) * 105 + Math.max(i, j));
            }
          }
        }
      }
      cnt++;
    }

    out.println(res.size());
    List<Integer> ans = new ArrayList<>(res);
    Collections.sort(ans);
    for (Integer integer : ans) {
      out.println(integer / 105 + 1, integer % 105 + 1);
    }
  }

  int find(int x) {
    if (p[x] != x) {
      p[x] = find(p[x]);
    }
    return p[x];
  }
}
