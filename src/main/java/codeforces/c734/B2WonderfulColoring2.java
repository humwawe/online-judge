package codeforces.c734;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class B2WonderfulColoring2 {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        Point[] a = new Point[n];
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            a[i] = new Point(in.nextInt(), i);
            cnt.put(a[i].v, cnt.getOrDefault(a[i].v, 0) + 1);
        }
        Arrays.sort(a, (x, y) -> {
            if (cnt.get(y.v).equals(cnt.get(x.v))) {
                return y.v - x.v;
            } else {
                return cnt.get(y.v) - cnt.get(x.v);
            }
        });

        int[] res = new int[n];
        int c = 1;
        int sum = 0;
        for (int i = 0; i < n; ) {
            if (cnt.get(a[i].v) >= k) {
                int tmp = cnt.get(a[i].v);
                for (int j = 0; j < tmp; j++) {
                    if (c > k) {
                        i++;
                        continue;
                    }
                    res[a[i].idx] = c++;
                    i++;
                }
                c = 1;
            } else {
                int tmp = cnt.get(a[i].v);
                sum += tmp;
                for (int j = 0; j < tmp; j++) {
                    if (c > k) {
                        c = 1;
                    }
                    res[a[i].idx] = c++;
                    i++;
                }
            }
        }
        int t = sum % k;
        for (int i = n - 1; i >= 0 && t > 0; i--) {
            res[a[i].idx] = 0;
            t--;
        }
        out.println(res);
    }

    class Point {
        int v;
        int idx;

        public Point(int v, int idx) {
            this.v = v;
            this.idx = idx;
        }
    }
}
