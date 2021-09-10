package codeforces.e113;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.*;

public class DInconvenientPairs {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[] row = new int[n];
        boolean[] vis1 = new boolean[(int) (1e6 + 5)];
        int[] col = new int[m];
        boolean[] vis2 = new boolean[(int) (1e6 + 5)];
        for (int i = 0; i < n; i++) {
            row[i] = in.nextInt();
            vis1[row[i]] = true;
        }
        for (int i = 0; i < m; i++) {
            col[i] = in.nextInt();
            vis2[col[i]] = true;
        }

        Map<Integer, List<Integer>> map1 = new HashMap<>();
        Map<Integer, List<Integer>> map2 = new HashMap<>();
        for (int i = 0; i < k; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            if (vis1[x] && vis2[y]) {
                continue;
            }
            if (!vis1[x]) {
                int tmp = lowerBound(row, x);
                if (!map1.containsKey(tmp)) {
                    map1.put(tmp, new ArrayList<>());
                }
                map1.get(tmp).add(y);
            } else {
                int tmp = lowerBound(col, y);
                if (!map2.containsKey(tmp)) {
                    map2.put(tmp, new ArrayList<>());
                }
                map2.get(tmp).add(x);
            }

        }
        long res = 0;
        for (List<Integer> value : map1.values()) {
            Collections.sort(value);
            res += (long) value.size() * (value.size() - 1) / 2;
            long cnt = 1;
            for (int i = 1; i < value.size(); i++) {
                if (value.get(i).equals(value.get(i - 1))) {
                    cnt++;
                } else {
                    res -= cnt * (cnt - 1) / 2;
                    cnt = 1;
                }
            }
            res -= cnt * (cnt - 1) / 2;
        }

        for (List<Integer> value : map2.values()) {
            Collections.sort(value);
            res += (long) value.size() * (value.size() - 1) / 2;
            long cnt = 1;
            for (int i = 1; i < value.size(); i++) {
                if (value.get(i).equals(value.get(i - 1))) {
                    cnt++;
                } else {
                    res -= cnt * (cnt - 1) / 2;
                    cnt = 1;
                }
            }
            res -= cnt * (cnt - 1) / 2;
        }

        out.println(res);
    }

    int lowerBound(int[] a, int t) {
        int l = 0;
        int r = a.length;
        while (l < r) {
            int mid = l + r >> 1;
            if (a[mid] >= t) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
