package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayDeque;
import java.util.Queue;

public class CChocolateBunny {
  int n;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    int[] a = new int[n + 1];
    Queue<Integer> queue = new ArrayDeque<>();
    for (int i = 1; i <= n; i++) {
      queue.add(i);
    }
    while (queue.size() >= 2) {
      int size = queue.size();
      for (int i = 0; i < size / 2; i++) {
        int p1 = queue.poll();
        int p2 = queue.poll();
        int k1 = ask(in, out, p1, p2);
        int k2 = ask(in, out, p2, p1);
        if (k1 > k2) {
          queue.add(p2);
          a[p1] = k1;
        } else {
          queue.add(p1);
          a[p2] = k2;
        }
      }
    }
    int max = queue.poll();
    a[max] = n;

    out.print("!");
    for (int i = 1; i <= n; i++) {
      out.print(" " + a[i]);
    }
    out.println();
  }

  private int ask(InputReader in, OutputWriter out, int max, int i) {
    out.print("?");
    out.println(" " + max + " " + i);
    out.flush();
    return in.nextInt();
  }
}
