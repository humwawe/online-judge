package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.*;

public class C2BalancedRemovalsHarder {
  int[][] p;
  int n;
  List<int[]> res = new ArrayList<>();

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    p = new int[n][3];
    List<Integer> ids = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < 3; j++) {
        p[i][j] = in.nextInt();
      }
      ids.add(i);
    }
    dfs(ids, 0);
    for (int[] r : res) {
      out.println(r);
    }
  }

  private int dfs(List<Integer> ids, int k) {
    if (k == 3) {
      return ids.get(0);
    }
    TreeMap<Integer, List<Integer>> map = new TreeMap<>();

    for (Integer id : ids) {
      map.computeIfAbsent(p[id][k], x -> new ArrayList<>()).add(id);
    }
    List<Integer> list = new ArrayList<>();
    for (Map.Entry<Integer, List<Integer>> kv : map.entrySet()) {
      Collections.sort(kv.getValue());
      int cur = dfs(kv.getValue(), k + 1);
      if (cur != -1) {
        list.add(cur);
      }
    }
    for (int i = 0; i + 1 < list.size(); i += 2) {
      res.add(new int[]{list.get(i) + 1, list.get(i + 1) + 1});
    }
    if (list.size() % 2 == 0) {
      return -1;
    }
    return list.get(list.size() - 1);
  }
}
