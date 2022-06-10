package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.*;

public class ECoverIt {

  int[] h;
  int[] e;
  int[] ne;
  int idx;
  int n, m;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    m = in.nextInt();
    h = new int[n + 5];
    e = new int[m * 2 + 5];
    ne = new int[m * 2 + 5];
    Arrays.fill(h, -1);
    idx = 0;
    for (int i = 0; i < m; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      add(a, b);
      add(b, a);
    }
    int[] color = new int[n + 1];
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(1);
    color[1] = 1;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int cur = 0; cur < size; cur++) {
        int u = queue.poll();
        for (int i = h[u]; i != -1; i = ne[i]) {
          int j = e[i];
          if (color[j] == 0) {
            color[j] = 3 - color[u];
            queue.add(j);
          }
        }
      }
    }
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      if (color[i] == 1) {
        list1.add(i);
      } else {
        list2.add(i);
      }
    }
    if (list1.size() <= n / 2) {
      out.println(list1.size());
      out.println(list1);
    } else {
      out.println(list2.size());
      out.println(list2);
    }
  }

  void add(int a, int b) {
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
  }

}
