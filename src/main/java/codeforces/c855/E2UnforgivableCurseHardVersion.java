package codeforces.c855;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.DJSet;

import java.util.*;

public class E2UnforgivableCurseHardVersion {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    DJSet djSet = new DJSet(n);
    char[] s = in.nextString().toCharArray();
    char[] t = in.nextString().toCharArray();
    for (int i = 0; i < n; i++) {
      if (i + k < n) {
        djSet.unite(i, i + k);
      }
      if (i + k + 1 < n) {
        djSet.unite(i, i + k + 1);
      }
    }

    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int root = djSet.root(i);
      map.computeIfAbsent(root, e -> new ArrayList<>()).add(i);
    }

    for (List<Integer> value : map.values()) {
      char[] chars1 = new char[value.size()];
      char[] chars2 = new char[value.size()];
      for (int i = 0; i < value.size(); i++) {
        chars1[i] = s[value.get(i)];
        chars2[i] = t[value.get(i)];
      }
      Arrays.sort(chars1);
      Arrays.sort(chars2);
      if (!new String(chars1).equals(new String(chars2))) {
        out.println("NO");
        return;
      }
    }

    out.println("YES");
  }
}
