package best.coder.o2022.one.a;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.PriorityQueue;

public class Task2 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    long[][] c = new long[n][2];
    for (int i = 0; i < n; i++) {
      c[i][0] = i + 1;
      c[i][1] = in.nextInt();
    }


    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x, y) -> Long.compare(c[y][1], c[x][1]));
    long res = 0;
    int j = 0;
    for (int i = k + 1; i <= k + n; i++) {
      while (j < n && j < i) {
        priorityQueue.add(j);
        j++;
      }
      Integer poll = priorityQueue.poll();
      res += ((long) i * i - c[poll][0] * c[poll][0]) * c[poll][1];

    }
    out.println(res);

  }
}
