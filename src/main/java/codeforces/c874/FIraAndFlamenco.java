package codeforces.c874;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.CombinationMath;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FIraAndFlamenco {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    Map<Integer, Integer> map = new HashMap<>();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      map.put(a[i], map.getOrDefault(a[i], 0) + 1);
    }
    Arrays.sort(a);
    int[] b = uniq(a);
    long[] mul = new long[b.length + 1];
    mul[0] = 1L;
    int mod = (int) (1e9 + 7);
    for (int i = 0; i < b.length; i++) {
      mul[i + 1] = mul[i] * map.get(b[i]) % mod;
    }
    CombinationMath.initMod(mod);
    long res = 0;
    for (int i = 0; i < b.length; i++) {
      if (i + m - 1 < b.length && b[i + m - 1] == b[i] + m - 1) {
        res = (res + mul[i + m] * CombinationMath.inv(mul[i])) % mod;
      }
    }
    out.println(res);
  }

  int[] uniq(int[] a) {
    int p = 0;
    int[] b = new int[a.length];
    for (int i = 0; i < a.length; i++) {
      if (i == 0 || a[i] != a[i - 1]) {
        b[p++] = a[i];
      }
    }
    return Arrays.copyOf(b, p);
  }
}