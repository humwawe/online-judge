package codeforces.bye2022;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.PriorityQueue;

public class AKoxiaAndWhiteboards {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[] a = in.nextInt(n);
    int[] b = in.nextInt(m);
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    for (int i : a) {
      priorityQueue.add(i);
    }

    for (int i = 0; i < m; i++) {
      priorityQueue.poll();
      priorityQueue.add(b[i]);
    }

    long sum = 0;
    while (!priorityQueue.isEmpty()) {
      sum += priorityQueue.poll();
    }
    out.println(sum);
  }
}
