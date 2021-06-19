package acwing.contest.weekly.c4;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.*;

public class TaskC {
    int[] h;
    int[] e;
    int[] ne;
    int[] w;
    int idx;
    int[] pos;

    // 考虑拓扑排序后的次序，对所有的不确定边按照由前指向后即可
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        h = new int[n + 5];
        pos = new int[n + 5];
        int[] inDeg = new int[n + 5];
        e = new int[m * 2 + 5];
        ne = new int[m * 2 + 5];
        w = new int[m * 2 + 5];
        idx = 0;
        Arrays.fill(h, -1);
        List<int[]> res = new ArrayList<>();
        List<int[]> tmp = new ArrayList<>();
        boolean[] vis = new boolean[n + 5];
        for (int i = 0; i < m; i++) {
            int t = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            if (t == 1) {
                add(x, y);
                inDeg[y]++;
                tmp.add(new int[]{x, y});
            } else {
                res.add(new int[]{x, y});
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int j = 1; j <= n; j++) {
            if (inDeg[j] == 0) {
                queue.add(j);
            }
        }
        int cnt = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            pos[u] = cnt++;
            for (int k = h[u]; k != -1; k = ne[k]) {
                int j = e[k];
                inDeg[j]--;
                if (inDeg[j] == 0) {
                    queue.add(j);
                }
            }
        }

        if (cnt == n) {
            out.println("YES");
            for (int[] re : tmp) {
                out.println(re[0] + " " + re[1]);
            }
            for (int[] re : res) {
                if (pos[re[0]] > pos[re[1]]) {
                    out.println(re[1] + " " + re[0]);
                } else {
                    out.println(re[0] + " " + re[1]);
                }
            }
        } else {
            out.println("NO");
        }
    }

    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
