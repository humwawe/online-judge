package codeforces.e115;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashMap;
import java.util.Map;

public class CDeleteTwoElements {
    int n;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        long sum = 0;
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            sum += a[i];
        }
        sum *= 2;
        Map<Long, Integer> map = new HashMap<>();
        long res = 0;
        for (int i = 0; i < n; i++) {
            long t = sum - n * a[i];
            res += map.getOrDefault(t, 0);
            map.put(n * a[i], map.getOrDefault(n * a[i], 0) + 1);
        }
        out.println(res);
    }
}
