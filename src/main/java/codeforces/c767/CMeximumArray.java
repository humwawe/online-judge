package codeforces.c767;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CMeximumArray {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
        boolean[] vis = new boolean[n + 1];
        List<Integer> res = new ArrayList<>();
        int idx = 0;
        for (int i = 0; i < n; i++) {
            map.put(a[i], map.get(a[i]) - 1);
            if (map.get(a[i]) == 0) {
                map.remove(a[i]);
            }
            vis[a[i]] = true;
            while (vis[idx]) {
                idx++;
            }
            if (!map.containsKey(idx)) {
                res.add(idx);
                for (int j = 0; j < idx; j++) {
                    vis[j] = false;
                }
                idx = 0;
            }
        }
        out.println(res.size());
        for (Integer integer : res) {
            out.print(integer + " ");
        }
        out.println();
    }
}
