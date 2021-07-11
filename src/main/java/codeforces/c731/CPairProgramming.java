package codeforces.c731;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CPairProgramming {
    int k, n, m;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        k = in.nextInt();
        n = in.nextInt();
        m = in.nextInt();
        int i = 0, j = 0;
        int[] a = in.nextIntArray(n);
        int[] b = in.nextIntArray(m);
        int[] res = new int[n + m];
        int idx = 0;
        while (i < n && j < m) {
            if (a[i] == 0) {
                k++;
                res[idx++] = a[i];
                i++;
            } else if (b[j] == 0) {
                k++;
                res[idx++] = b[j];
                j++;
            } else if (a[i] > k && b[j] > k) {
                out.println(-1);
                return;
            } else if (a[i] <= k) {
                res[idx++] = a[i];
                i++;
            } else if (b[j] <= k) {
                res[idx++] = b[j];
                j++;
            }
        }
        while (i < n) {
            if (a[i] == 0) {
                res[idx++] = a[i];
                k++;
                i++;
            } else if (a[i] <= k) {
                res[idx++] = a[i];
                i++;

            } else if (a[i] > k) {
                out.println(-1);
                return;
            }
        }
        while (j < m) {
            if (b[j] == 0) {
                res[idx++] = b[j];
                k++;
                j++;
            } else if (b[j] <= k) {
                res[idx++] = b[j];
                j++;

            } else if (b[j] > k) {
                out.println(-1);
                return;
            }
        }
        for (int l : res) {
            out.print(l + " ");
        }
        out.println();
    }
}
