package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.TreeMap;

public class EMinimumArray {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    int[] b = new int[n];
    TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    for (int i = 0; i < n; i++) {
      b[i] = in.nextInt();
      treeMap.put(b[i], treeMap.getOrDefault(b[i], 0) + 1);
    }

    for (int i = 0; i < n; i++) {
      int x = n - a[i];
      Integer key = treeMap.ceilingKey(x);
      if (key == null) {
        key = treeMap.firstKey();
      }
      out.print((a[i] + key) % n, "");
      treeMap.put(key, treeMap.get(key) - 1);
      if (treeMap.get(key) == 0) {
        treeMap.remove(key);
      }
    }

  }
}
