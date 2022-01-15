package acwing.contest.weekly.c34;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskC {
    long[] a;
    List<Integer> path = new ArrayList<>();
    boolean[] vis;
    Map<Integer, List<Integer>> map = new HashMap<>();
    int n;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextLong();
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (a[i] * 2 == a[j]) {
                    map.get(i).add(j);
                } else if (a[i] == a[j] * 3) {
                    map.get(i).add(j);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            vis = new boolean[n];
            path = new ArrayList<>();
            if (dfs(i)) {
                for (int j = 0; j < n; j++) {
                    out.print(a[path.get(j)] + " ");
                }
                return;
            }
        }
    }

    private boolean dfs(int i) {
        vis[i] = true;
        path.add(i);
        if (path.size() == n) {
            return true;
        }
        List<Integer> list = map.get(i);
        for (Integer child : list) {
            if (vis[child]) {
                continue;
            }
            if (dfs(child)) {
                return true;
            }
        }
        path.remove(path.size() - 1);
        vis[i] = false;
        return false;
    }
}
