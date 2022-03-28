package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashSet;
import java.util.Set;

public class BFixATree {
  int[] p;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n + 1];
    p = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      p[i] = i;
    }
    int root = -1;
    for (int i = 1; i <= n; i++) {
      a[i] = in.nextInt();
      if (a[i] == i) {
        root = i;
      }
      union(i, a[i]);
    }
    Set<Integer> set = new HashSet<>();
    for (int i = 1; i <= n; i++) {
      set.add(find(i));
    }
    if (root == -1) {
      out.println(set.size());
    } else {
      out.println(set.size() - 1);
    }

    for (int i = 1; i <= n; i++) {
      if (p[i] == i) {
        if (root != -1) {
          a[i] = root;
        } else {
          root = i;
          a[i] = root;
        }
      }
      out.print(a[i], "");
    }
    out.println();

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
    p[find(a)] = find(b);
  }
}
