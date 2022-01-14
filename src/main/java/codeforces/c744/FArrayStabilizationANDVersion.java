package codeforces.c744;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class FArrayStabilizationANDVersion {

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int d = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        boolean[] vis = new boolean[n];
        List<Integer>[] lists = new List[n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i]) {
                continue;
            }
            lists[idx++] = new ArrayList<>();
            int x = i;
            lists[i].add(a[x]);
            boolean zero = a[x] == 0;
            int nx = (n - d + x + n) % n;
            while (nx != x) {
                lists[i].add(a[nx]);
                vis[nx] = true;
                zero |= a[nx] == 0;
                nx = (n - d + nx + n) % n;
            }
            if (!zero) {
                out.println(-1);
                return;
            }
        }
        int res = 0;
        for (int i = 0; i < idx; i++) {
            List<Integer> list = lists[i];
            list.addAll(list);
            int last = -1;
            int tmp = 0;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) == 0) {
                    tmp = Math.max(tmp, j - last - 1);
                    last = j;
                }
            }
            res = Math.max(res, tmp);
        }
        out.println(res);

    }
}
