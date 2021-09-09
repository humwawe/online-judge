package codeforces.e113;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class CJuryMeeting {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        Arrays.sort(a);
        int mod = 998244353;
        int max = a[n - 1];
        int lmax = a[n - 2];
        if (max >= lmax + 2) {
            out.println(0);
            return;
        }
        if (max == lmax) {
            long res = 1;
            for (int i = 1; i <= n; i++) {
                res = res * i % mod;
            }
            out.println(res);
            return;
        }
        int t = n - 2;
        int cnt = 0;
        while (t >= 0 && a[t] == lmax) {
            cnt++;
            t--;
        }

        long all = 1;
        for (int i = 1; i <= n; i++) {
            all = all * i % mod;
        }
        long t1 = 1;
        for (int i = 1; i <= cnt; i++) {
            t1 = t1 * i % mod;
        }
        int last = cnt + 1;
        long t2 = 1;
        for (int i = last + 1; i <= n; i++) {
            t2 = t2 * i % mod;
        }
        out.println((all - t2 * t1 % mod + mod) % mod);
    }
}
