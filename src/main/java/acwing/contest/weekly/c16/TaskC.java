package acwing.contest.weekly.c16;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskC {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        if (n < 3) {
            out.println(0);
            return;
        }
        int min = a[n - 1];
        int mI = n - 1;
        int[] minIdx = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            if (a[i] > min) {
                minIdx[i] = mI;
            } else {
                minIdx[i] = -1;
            }
            if (a[i] < min) {
                min = a[i];
                mI = i;
            }
        }
        mI = 0;
        for (int i = 1; i < n - 1; i++) {
            if (a[i] > a[mI]) {
                if (minIdx[i] != -1) {
                    out.println(3);
                    out.print(mI + 1 + " ");
                    out.print(i + 1 + " ");
                    out.println(minIdx[i] + 1);
                    return;
                }
            }
            if (a[i] < a[mI]) {
                mI = i;
            }
        }

        int max = a[n - 1];
        mI = n - 1;
        int[] maxIdx = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            if (a[i] < max) {
                maxIdx[i] = mI;
            } else {
                maxIdx[i] = -1;
            }
            if (a[i] > max) {
                max = a[i];
                mI = i;
            }
        }
        mI = 0;
        for (int i = 1; i < n - 1; i++) {
            if (a[i] < a[mI]) {
                if (maxIdx[i] != -1) {
                    out.println(3);
                    out.print(mI + 1 + " ");
                    out.print(i + 1 + " ");
                    out.println(maxIdx[i] + 1);
                    return;
                }
            }
            if (a[i] > a[mI]) {
                mI = i;
            }
        }
        out.println(0);
    }
}
