package acwing.contest.weekly.c11;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class TaskC {
    int n, m, k;
    int N = (int) (2e5 + 5);
    int M = N * 2;
    int[] h = new int[N];
    int[] e = new int[M];
    int[] ne = new int[M];
    int[] dist1 = new int[N];
    int[] dist2 = new int[N];
    int idx;
    int inf = (int) 1e8;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        m = in.nextInt();
        k = in.nextInt();
        Arrays.fill(h, -1);
        idx = 0;
        Integer[] sp = new Integer[k];
        for (int i = 0; i < k; i++) {
            sp[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            add(a, b);
            add(b, a);
        }
        bfs(1, dist1);
        bfs(n, dist2);
        Arrays.sort(sp, (x, y) -> dist1[x] - dist2[x] - (dist1[y] - dist2[y]));
        int max = dist1[sp[0]];
        int res = 0;
        for (int i = 1; i < k; i++) {
            res = Math.max(res, max + dist2[sp[i]] + 1);
            max = Math.max(max, dist1[sp[i]]);
        }
        out.println(Math.min(dist1[n], res));

    }

    private void bfs(int start, int[] dist) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        Arrays.fill(dist, inf);
        dist[start] = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int i = h[u]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dist[j] == inf) {
                    dist[j] = dist[u] + 1;
                    queue.add(j);
                }
            }
        }
    }

    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
