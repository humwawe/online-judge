package codeforces.dds;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BTakeYourPlaces {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        int o = 0;
        int e = 0;
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt() % 2;
            if (a[i] % 2 == 0) {
                o++;
            } else {
                e++;
            }
        }
        if (Math.abs(o - e) > 1) {
            out.println(-1);
            return;
        }
        long res = 0;
        int j = 0;
        if (o > e) {
            for (int i = 0; i < n; i += 2) {
                while (j < n && a[j] % 2 != 0) {
                    j++;
                }
                if (j == n) {
                    break;
                }
                res += Math.abs(j - i);
                j++;
            }
            out.println(res);
        } else if (o < e) {
            for (int i = 0; i < n; i += 2) {
                while (j < n && a[j] % 2 != 1) {
                    j++;
                }
                if (j == n) {
                    break;
                }
                res += Math.abs(j - i);
                j++;
            }
            out.println(res);
        } else {
            long res1 = 0;
            for (int i = 0; i < n; i += 2) {
                while (j < n && a[j] % 2 != 0) {
                    j++;
                }
                if (j == n) {
                    break;
                }
                res1 += Math.abs(j - i);
                j++;
            }
            long res2 = 0;
            j = 0;
            for (int i = 0; i < n; i += 2) {
                while (j < n && a[j] % 2 != 1) {
                    j++;
                }
                if (j == n) {
                    break;
                }
                res2 += Math.abs(j - i);
                j++;
            }
            out.println(Math.min(res1, res2));
        }

    }
}
