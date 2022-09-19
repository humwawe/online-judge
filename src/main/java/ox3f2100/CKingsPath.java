package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class CKingsPath {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int x0 = in.nextInt();
    int y0 = in.nextInt();
    int x1 = in.nextInt();
    int y1 = in.nextInt();
    int n = in.nextInt();
    int b = (int) (1e9 + 5);
    Set<Long> set = new HashSet<>();
    for (int i = 0; i < n; i++) {
      int row = in.nextInt();
      int l = in.nextInt();
      int r = in.nextInt();
      for (int j = l; j <= r; j++) {
        set.add(((long) row * b + j));
      }
    }
    long end = (long) x1 * b + y1;
    Queue<Long> queue = new ArrayDeque<>();
    queue.add((long) x0 * b + y0);
    set.remove((long) x0 * b + y0);
    int[][] fs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int dep = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        long cur = queue.poll();
        if (cur == end) {
          out.println(dep);
          return;
        }
        long x = cur / b;
        long y = cur % b;
        for (int j = -1; j <= 1; j++) {
          for (int k = -1; k <= 1; k++) {
            long nx = x + j;
            long ny = y + k;
            long key = nx * b + ny;
            if (set.contains(key)) {
              queue.add(key);
              set.remove(key);
            }
          }
        }
      }
      dep++;
    }
    out.println(-1);
  }
}
