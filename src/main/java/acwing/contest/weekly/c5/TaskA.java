package acwing.contest.weekly.c5;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] % 2 == 0) {
                cnt |= 1 << 1;
            } else {
                cnt |= 1;
            }
        }
        if (cnt == 3) {
            out.println("NO");
        } else {
            out.println("YES");
        }
    }
}
