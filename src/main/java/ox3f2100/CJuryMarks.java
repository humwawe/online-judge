package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.*;

public class CJuryMarks {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[] a = new int[n];
    TreeSet<Integer> treeSet = new TreeSet<>();
    int s = 0;
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      s += a[i];
      treeSet.add(s);
    }
    int[] b = new int[m];
    for (int i = 0; i < m; i++) {
      b[i] = in.nextInt();
    }
    Arrays.sort(b);
    List<Integer> list = new ArrayList<>(treeSet);
    int res = 0;
    f:
    for (int i = 0; i < list.size(); i++) {
      int x = b[0] - list.get(i);
      Set<Integer> set = new HashSet<>();
      for (Integer integer : list) {
        set.add(x + integer);
      }
      for (int j = 0; j < m; j++) {
        if (!set.contains(b[j])) {
          continue f;
        }
      }
      res++;
    }
    out.println(res);
  }
}
