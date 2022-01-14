package acwing.contest.weekly.c16;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashMap;
import java.util.Map;

public class TaskB {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        long[] sum = new long[n + 1];
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + a[i];
            if (i + 1 == n) {
                continue;
            }
            map.put(sum[i + 1], map.getOrDefault(sum[i + 1], 0) + 1);
        }
        long res = 0;
        for (int i = 1; i <= n - 2; i++) {
            long t = sum[i];
            map.put(t, map.get(t) - 1);
            if (map.get(t) == 0) {
                map.remove(t);
            }
            if (sum[n] != 3 * t) {
                continue;
            }
            long tar = 2 * t;
            res += map.getOrDefault(tar, 0);
        }

        out.println(res);

    }

}
