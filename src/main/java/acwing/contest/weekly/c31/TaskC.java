package acwing.contest.weekly.c31;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskC {
    int n, m;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        m = in.nextInt();
        int k = in.nextInt();
        int[][] points = new int[n][2];
        int[][] circles = new int[m][3];
        for (int i = 0; i < n; i++) {
            points[i][0] = in.nextInt();
            points[i][1] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            circles[i][2] = in.nextInt();
            circles[i][0] = in.nextInt();
            circles[i][1] = in.nextInt();
        }
        BitSet[] deg = new BitSet[n];
        for (int i = 0; i < n; i++) {
            deg[i] = new BitSet(m);
            for (int j = 0; j < m; j++) {
                if (helper(circles[j][0], circles[j][1], points[i][0], points[i][1], circles[j][2])) {
                    deg[i].set(j);
                }
            }
        }

        while (k-- > 0) {
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            BitSet tmp = deg[a].clone();
            tmp.xor(deg[b]);
            out.println(tmp.size());
        }
    }

    private boolean helper(long c1, long c2, long x, long y, long r) {
        return (c1 - x) * (c1 - x) + (c2 - y) * (c2 - y) < r * r;
    }


}
