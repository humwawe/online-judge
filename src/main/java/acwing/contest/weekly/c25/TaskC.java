package acwing.contest.weekly.c25;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TaskC {
    int N = (int) (2e5 + 5);
    int n, m, k;
    int[] c = new int[N];

    int[] p = new int[N];

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        m = in.nextInt();
        k = in.nextInt();
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }
        for (int i = 1; i <= n; i++) {
            c[i] = in.nextInt();
        }
        boolean[] vis = new boolean[n + 5];
        for (int i = 0; i < m; i++) {
            int l = in.nextInt();
            int r = in.nextInt();
            vis[l] = true;
            vis[r] = true;
            union(l, r);
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            if (vis[i]) {
                int fa = find(i);
                if (!map.containsKey(fa)) {
                    map.put(fa, new HashSet<>());
                }
                map.get(fa).add(i);
            }
        }
        int res = 0;
        for (Integer integer : map.keySet()) {
            Set<Integer> set = map.get(integer);
            int sum = set.size();
            int[] cnt = new int[k + 5];
            int max = 0;
            for (Integer idx : set) {
                cnt[c[idx]]++;
                max = Math.max(max, cnt[c[idx]]);
            }
            res += sum - max;
        }
        out.println(res);
    }

    void union(int a, int b) {
        if (find(a) == find(b)) {
            return;
        }
        p[find(a)] = find(b);
    }

    int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
