package acwing.contest.weekly.c6;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if ((sum - a[i]) % 2 == 0) {
                res++;
            }
        }
        out.println(res);
    }
}
