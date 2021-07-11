package codeforces.c731;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.*;

public class GHowManyPaths {
    int N = 105;
    int M = 205;
    int[] dfn = new int[N];
    int[] low = new int[N];

    int timestamp;
    Stack<Integer> stack;
    boolean[] inStack;
    int[] h;
    int[] e;
    int[] ne;
    int idx;
    int sccCnt = 0;
    int[] id = new int[N];
    int n, m;
    Map<Integer, List<Integer>> map;
    boolean[] vis;

    //    todo
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        m = in.nextInt();
        h = new int[n + 5];
        e = new int[m + 5];
        ne = new int[m + 5];
        stack = new Stack<>();
        inStack = new boolean[n + 5];
        vis = new boolean[n + 5];
        Arrays.fill(h, -1);
        map = new HashMap<>();
        idx = 0;
        timestamp = 0;
        boolean[] self = new boolean[n + 5];

        int[] deg = new int[n + 5];

        int[][] ed = new int[m][2];
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            if (a == b) {
                self[a] = true;
            } else {
                add(a, b);
                deg[b]++;
                ed[cnt][0] = a;
                ed[cnt++][1] = b;
            }
        }
        for (int i = 0; i < cnt; i++) {
            int a = ed[i][0];
            int b = ed[i][1];
            if (id[a] == id[b]) {
                deg[b]--;
            }
        }
//        dfs(1);
        tarjan(1);
        out.println(id);
        int[] res = new int[n + 1];
        boolean f1 = false;
        for (int i = sccCnt; i >= 1; i--) {
            List<Integer> list = map.get(id[i]);
            if (list.size() > 1) {
                f1 = true;
            }
            if (f1) {
                for (Integer integer : list) {
                    res[integer] = -1;
                }
            }
        }
        out.println(res);
    }

    void dfs(int u) {
        vis[u] = true;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (!vis[j]) {
                dfs(j);
            }
        }
    }

    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    void tarjan(int u) {
        dfn[u] = low[u] = ++timestamp;
        stack.push(u);
        inStack[u] = true;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (dfn[j] == 0) {
                tarjan(j);
                low[u] = Math.min(low[u], low[j]);
            } else if (inStack[j]) {
                low[u] = Math.min(low[u], dfn[j]);
            }
        }
        if (dfn[u] == low[u]) {
            int y;
            ++sccCnt;
            do {
                y = stack.pop();
                inStack[y] = false;
                id[y] = sccCnt;
                if (!map.containsKey(sccCnt)) {
                    map.put(sccCnt, new ArrayList<>());
                }
                map.get(sccCnt).add(y);
            } while (y != u);
        }
    }
}
