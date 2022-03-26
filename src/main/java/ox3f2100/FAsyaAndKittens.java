package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class FAsyaAndKittens {
  int n;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    List<Integer>[] lists = new List[n];
    for (int i = 0; i < n; i++) {
      lists[i] = new ArrayList<>();
      lists[i].add(i);
      p[i] = i;
    }
    for (int i = 0; i < n - 1; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      int p1 = find(a - 1);
      int p2 = find(b - 1);
      if (lists[p1].size() >= lists[p2].size()) {
        p[p2] = p1;
        lists[p1].addAll(lists[p2]);
      } else {
        p[p1] = p2;
        lists[p2].addAll(lists[p1]);
      }
    }
    int root = find(0);
    for (Integer i : lists[root]) {
      out.print(i + 1, "");
    }
    out.println();

  }


  int N = 150010;
  int[] p = new int[N + 1];

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
