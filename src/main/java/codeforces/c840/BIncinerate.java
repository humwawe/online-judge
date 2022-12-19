package codeforces.c840;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Comparator;
import java.util.PriorityQueue;

public class BIncinerate {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    boolean[] vis = new boolean[n];
    PriorityQueue<int[]> h = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
    PriorityQueue<int[]> p = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
    for (int i = 0; i < n; i++) {
      int x = in.nextInt();
      h.add(new int[]{x, i});
    }
    for (int i = 0; i < n; i++) {
      int x = in.nextInt();
      p.add(new int[]{x, i});
    }


    long sum = k;
    while (!h.isEmpty()) {
      int[] peek = h.peek();
      if (peek[0] <= sum) {
        vis[peek[1]] = true;
        h.poll();
        continue;
      }
      int cur = 0;
      while (!p.isEmpty()) {
        int[] u = p.peek();
        if (vis[u[1]]) {
          p.poll();
          continue;
        }
        cur = u[0];
        break;
      }
      k -= cur;
      sum += k;
      if (k < 0) {
        out.println("NO");
        return;
      }
    }
    out.println("YES");
  }
}
