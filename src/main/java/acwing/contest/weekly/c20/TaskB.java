package acwing.contest.weekly.c20;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.PriorityQueue;

public class TaskB {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        k += in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x, y) -> y - x);
        for (int i = 0; i < n; i++) {
            a[i] -= in.nextInt();
            a[i] = Math.abs(a[i]);
            priorityQueue.add(a[i]);
        }
        for (int i = 0; i < k; i++) {
            Integer cur = priorityQueue.poll();
            if (cur > 0) {
                priorityQueue.add(cur - 1);
            } else {
                priorityQueue.add(1);
            }
        }

        long res = 0;
        while (!priorityQueue.isEmpty()) {
            Integer u = priorityQueue.poll();
            res += (long) u * u;
        }
        out.println(res);
    }
}
