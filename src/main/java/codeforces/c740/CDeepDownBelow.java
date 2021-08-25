package codeforces.c740;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Comparator;
import java.util.PriorityQueue;

public class CDeepDownBelow {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {
            int k = in.nextInt();
            int dec = 0;
            int max = 0;
            for (int j = 0; j < k; j++) {
                int a = in.nextInt() - dec;
                max = Math.max(max, a);
                dec++;
            }
            size[i] = k;
            priorityQueue.add(new int[]{max, i});
        }
        int res = 0;
        int tmp = 0;
        while (!priorityQueue.isEmpty()) {
            int[] poll = priorityQueue.poll();
            int cnt = poll[0];
            int idx = poll[1];
            if (cnt >= tmp) {
                res += cnt - tmp + 1;
                tmp += cnt - tmp + 1;
            }
            tmp += size[idx];
        }
        out.println(res);
    }
}
