package codeforces.c872;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class BLuoTianyiAndTheTable {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[] a = in.nextInt(n * m);
    Arrays.sort(a);
    int max = a[n * m - 1];
    int max2 = a[n * m - 2];
    int min = a[0];
    int min2 = a[1];
    int res = (Math.max(n, m) - 1) * (max - min);
    res += (Math.min(n, m) - 1) * (max - min2);
    res += (n * m - n - m + 1) * (max - min);

    int res2 = (Math.max(n, m) - 1) * (max - min);
    res2 += (Math.min(n, m) - 1) * (max2 - min);
    res2 += (n * m - n - m + 1) * (max - min);
    out.println(Math.max(res, res2));
  }
}
