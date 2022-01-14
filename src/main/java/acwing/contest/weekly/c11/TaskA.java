package acwing.contest.weekly.c11;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = 4;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        Arrays.sort(a);
        out.print(a[3] - a[2] + " ");
        out.print(a[3] - a[1] + " ");
        out.print(a[3] - a[0]);
    }
}
