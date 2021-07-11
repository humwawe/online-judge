package codeforces.c731;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashSet;
import java.util.Set;

public class FArrayStabilizationGCDVersion {
    int n;

    //    todo
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        int[] a = new int[n + 1];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        a[n] = a[0];
        Set<Integer> set = new HashSet<>();
        int g = a[0];
        for (int i = 1; i <= n; i++) {
            g = gcd(g, a[i]);
            set.add(g);
        }
        out.println(set.size());
    }

    int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }
}
