package nowcoder.courses.graph.c0;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Task1013 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    int N = (int) (2e5 + 5);
    int[] dist = new int[N];
    Arrays.fill(dist, -1);
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(n);
    dist[n] = 0;
    while (!queue.isEmpty()) {
      Integer cur = queue.poll();
      if (cur - 1 >= 0 && dist[cur - 1] == -1) {
        dist[cur - 1] = dist[cur] + 1;
        queue.add(cur - 1);
      }
      if (cur + 1 < N && dist[cur + 1] == -1) {
        dist[cur + 1] = dist[cur] + 1;
        queue.add(cur + 1);
      }
      if (cur * 2 < N && dist[cur * 2] == -1) {
        dist[cur * 2] = dist[cur] + 1;
        queue.add(cur * 2);
      }
    }
    out.println(dist[k]);
  }
}
