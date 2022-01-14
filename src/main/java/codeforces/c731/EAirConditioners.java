package codeforces.c731;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Comparator;
import java.util.PriorityQueue;

public class EAirConditioners {
    int n, k;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        k = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < k; i++) {
            a[i] = in.nextInt();
        }
        int[] t = new int[n];
        for (int i = 0; i < k; i++) {
            t[i] = in.nextInt();
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
        for (int i = 0; i < k; i++) {
            priorityQueue.add(new int[]{t[i], a[i] - 1});
        }
        int[] res = new int[n];
        boolean[] vis = new boolean[n];
        while (!priorityQueue.isEmpty()) {
            int[] poll = priorityQueue.poll();
            int d = poll[0];
            int v = poll[1];
            if (vis[v]) {
                continue;
            }
            res[v] = d;
            vis[v] = true;
            int j = v + 1;
            if (j < n) {
                int tmp = d + 1;
                priorityQueue.add(new int[]{tmp, j});
            }
            j = v - 1;
            if (j >= 0) {
                int tmp = d + 1;
                priorityQueue.add(new int[]{tmp, j});
            }
        }
        out.println(res);
    }
}
