package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class DKuroniAndTheCelebration {
  int N = 1010;
  int M = N * 2;
  int[] h = new int[N];
  int[] e = new int[M];
  int[] ne = new int[M];
  int idx;
  int n;
  int[] deg = new int[N];

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    Arrays.fill(h, -1);
    idx = 0;
    n = in.nextInt();
    for (int i = 0; i < n - 1; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      add(a, b);
      add(b, a);
      deg[a]++;
      deg[b]++;
    }

    Queue<Integer> queue = new ArrayDeque<>();
    for (int i = 1; i <= n; i++) {
      if (deg[i] == 1) {
        queue.add(i);
      }
    }

    while (queue.size() >= 2) {
      int a = queue.poll();
      int b = queue.poll();
      out.println("?", a, b);
      out.flush();
      int x = in.nextInt();
      if (x == a || x == b) {
        out.println("!", x);
        out.flush();
        return;
      }
      for (int i = h[a]; i != -1; i = ne[i]) {
        int j = e[i];
        if (deg[j] > 1) {
          deg[j]--;
          if (deg[j] == 1) {
            queue.add(j);
          }
        }
      }
      for (int i = h[b]; i != -1; i = ne[i]) {
        int j = e[i];
        if (deg[j] > 1) {
          deg[j]--;
          if (deg[j] == 1) {
            queue.add(j);
          }
        }
      }
    }
    out.println("!", queue.poll());
    out.flush();

  }

  void add(int a, int b) {
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
  }
}
