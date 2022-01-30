package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class DReplaceByMEX {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        boolean[] mark = new boolean[n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] != i) {
                mark[i] = true;
                cnt++;
            }
        }
        List<Integer> res = new ArrayList<>();
        while (cnt > 0) {
            boolean[] vis = new boolean[n + 1];
            for (int i = 0; i < n; i++) {
                vis[a[i]] = true;
            }
            int mex = 0;
            while (vis[mex]) {
                mex++;
            }
            if (mex == n) {
                for (int i = 0; i < n; i++) {
                    if (mark[i]) {
                        res.add(i + 1);
                        a[i] = mex;
                        break;
                    }
                }
            } else {
                res.add(mex + 1);
                a[mex] = mex;
                mark[mex] = false;
                cnt--;
            }
        }
        out.println(res.size());
        for (Integer i : res) {
            out.print(i + " ");
        }
        out.println();
    }
}
