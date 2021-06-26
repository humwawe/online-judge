package codeforces.c728;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CGreatGraphs {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        long[] a = in.nextLongArray(n);
        longRadixSort(a);
        long sum = 0;
        long res = 0;
        for (int i = 1; i < n; i++) {
            res -= i * a[i] - sum;
            res += (a[i] - a[i - 1]);
            sum += a[i];
        }
        out.println(res);

    }

    public void longRadixSort(long[] a) {
        int fr = 0;
        int to = a.length;
        int[] c0 = new int[0x101];
        int[] c1 = new int[0x101];
        int[] c2 = new int[0x101];
        int[] c3 = new int[0x101];
        int[] c4 = new int[0x101];
        int[] c5 = new int[0x101];
        int[] c6 = new int[0x101];
        int[] c7 = new int[0x101];
        c0[0] = c1[0] = c2[0] = c3[0] = c4[0] = c5[0] = c6[0] = c7[0] = fr;
        for (int i = fr; i < to; i++) {
            long v = a[i];
            c0[(int) (v & 0xff) + 1]++;
            c1[(int) (v >>> 8 & 0xff) + 1]++;
            c2[(int) (v >>> 16 & 0xff) + 1]++;
            c3[(int) (v >>> 24 & 0xff) + 1]++;
            c4[(int) (v >>> 32 & 0xff) + 1]++;
            c5[(int) (v >>> 40 & 0xff) + 1]++;
            c6[(int) (v >>> 48 & 0xff) + 1]++;
            c7[(int) (v >>> 56 ^ 0x80) + 1]++;
        }
        for (int i = 0; i < 0x100; i++) {
            c0[i + 1] += c0[i];
            c1[i + 1] += c1[i];
            c2[i + 1] += c2[i];
            c3[i + 1] += c3[i];
            c4[i + 1] += c4[i];
            c5[i + 1] += c5[i];
            c6[i + 1] += c6[i];
            c7[i + 1] += c7[i];
        }
        long[] b = new long[a.length];
        for (int i = fr; i < to; i++) {
            long v = a[i];
            b[c0[(int) (v & 0xff)]++] = v;
        }
        for (int i = fr; i < to; i++) {
            long v = b[i];
            a[c1[(int) (v >>> 8 & 0xff)]++] = v;
        }
        for (int i = fr; i < to; i++) {
            long v = a[i];
            b[c2[(int) (v >>> 16 & 0xff)]++] = v;
        }
        for (int i = fr; i < to; i++) {
            long v = b[i];
            a[c3[(int) (v >>> 24 & 0xff)]++] = v;
        }
        for (int i = fr; i < to; i++) {
            long v = a[i];
            b[c4[(int) (v >>> 32 & 0xff)]++] = v;
        }
        for (int i = fr; i < to; i++) {
            long v = b[i];
            a[c5[(int) (v >>> 40 & 0xff)]++] = v;
        }
        for (int i = fr; i < to; i++) {
            long v = a[i];
            b[c6[(int) (v >>> 48 & 0xff)]++] = v;
        }
        for (int i = fr; i < to; i++) {
            long v = b[i];
            a[c7[(int) (v >>> 56 ^ 0x80)]++] = v;
        }
    }
}
