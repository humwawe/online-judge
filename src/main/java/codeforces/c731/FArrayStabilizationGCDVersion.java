package codeforces.c731;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FArrayStabilizationGCDVersion {
    int n;
    List<Integer> prime = new ArrayList<>();
    int N = (int) (1e6 + 5);
    int[] sieve = new int[N + 1];

    // sieve存每个数的最小质因子
    {
        sieve[1] = 1;
        for (int i = 2; i <= N; i++) {
            if (sieve[i] == 0) {
                sieve[i] = i;
                prime.add(i);
            }
            for (int j = 0; j < prime.size() && prime.get(j) <= sieve[i] && i * prime.get(j) <= N; j++) {
                sieve[i * prime.get(j)] = prime.get(j);
            }
        }
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        int[] a = in.nextIntArray(n);
        int common = a[0];
        for (int i = 1; i < n; i++) {
            common = gcd(common, a[i]);
        }
        Set<Integer>[] fact = new Set[n];
        for (int i = 0; i < n; i++) {
            fact[i] = new HashSet<>();
            int t = a[i] / common;
            while (t != 1) {
                fact[i].add(sieve[t]);
                t /= sieve[t];
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> set = fact[i];
            for (Integer p : set) {
                int l = (i + n - 1) % n;
                int r = i;
                int cnt = 0;
                while (fact[l].contains(p)) {
                    fact[l].remove(p);
                    l--;
                    cnt++;
                    if (l < 0) {
                        l = n - 1;
                    }
                }
                while (fact[r].contains(p)) {
                    if (r != i) {
                        fact[r].remove(p);
                    }
                    ++r;
                    r %= n;
                    cnt++;
                }
                res = Math.max(res, cnt);
            }
        }
        out.println(res);

    }

    int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }
}
