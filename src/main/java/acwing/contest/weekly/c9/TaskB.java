package acwing.contest.weekly.c9;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashMap;
import java.util.Map;

public class TaskB {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int k = in.nextInt();
        Map<Integer, Point> map = new HashMap<>();
        boolean ok = false;
        for (int i = 1; i <= k; i++) {
            int l = in.nextInt();
            int[] a = new int[l + 1];
            int sum = 0;
            for (int j = 1; j <= l; j++) {
                a[j] = in.nextInt();
                sum += a[j];
            }
            Map<Integer, Point> tmp = new HashMap<>();
            for (int j = 1; j <= l; j++) {
                int key = sum - a[j];
                if (!ok && map.containsKey(key)) {
                    Point point = map.get(key);
                    out.println("YES");
                    out.println(point.line + " " + point.idx);
                    out.println(i + " " + j);
                    ok = true;
                }
                tmp.put(sum - a[j], new Point(i, j));
            }
            map.putAll(tmp);
        }
        if (!ok) {
            out.println("NO");
        }
    }

    class Point {
        int line;
        int idx;

        public Point(int line, int idx) {
            this.line = line;
            this.idx = idx;
        }
    }
}
