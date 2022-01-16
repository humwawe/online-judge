package codeforces.c766;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BNotSitting {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        List<Integer> list = new ArrayList<>();
        int[][] ps = new int[][]{{0, 0}, {0, m - 1}, {n - 1, 0}, {n - 1, m - 1}};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int t = 0;
                for (int[] p : ps) {
                    t = Math.max(t, Math.abs(p[0] - i) + Math.abs(p[1] - j));
                }
                list.add(t);
            }
        }
        Collections.sort(list);
        for (Integer integer : list) {
            out.print(integer, "");
        }
        out.println();
    }
}
