package atcoder.abc298;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class CCardsQueryProblem {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int q = in.nextInt();
    TreeMap<Integer, Integer>[] treeMaps = new TreeMap[n];
    TreeMap<Integer, TreeSet<Integer>> idx = new TreeMap<>();
    Arrays.setAll(treeMaps, e -> new TreeMap<>());
    for (int c = 0; c < q; c++) {
      int t = in.nextInt();
      int i = in.nextInt() - 1;
      if (t == 1) {
        int j = in.nextInt() - 1;
        treeMaps[j].put(i, treeMaps[j].getOrDefault(i, 0) + 1);
        idx.computeIfAbsent(i, e -> new TreeSet<>()).add(j);
      } else if (t == 2) {
        for (Map.Entry<Integer, Integer> kv : treeMaps[i].entrySet()) {
          for (int j = 0; j < kv.getValue(); j++) {
            out.print(kv.getKey() + 1, "");
          }
        }
        out.println();
      } else {
        TreeSet<Integer> set = idx.get(i);
        if (set != null) {
          for (Integer integer : set) {
            out.print(integer + 1, "");
          }
        }
        out.println();
      }
    }
  }
}
