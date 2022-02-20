package codeforces.c725;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CNumberOfPairs {
  int n, l, r;
  int[] a;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    l = in.nextInt();
    r = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    radixSort2(a);
    long res = helper(r) - helper(l - 1);
    out.println(res);
  }

  private long helper(int v) {
    long res = 0;
    for (int i = 1; i < n; i++) {
      int tmp = v - a[i];
      int l = 0;
      int r = i - 1;
      if (a[r] <= tmp) {
        res += r + 1;
        continue;
      }
      while (l < r) {
        int mid = l + r >> 1;
        if (a[mid] > tmp) {
          r = mid;
        } else {
          l = mid + 1;
        }
      }
      res += l;
    }
    return res;
  }

  public int[] radixSort2(int[] a) {
    int n = a.length;
    int[] c0 = new int[0x101];
    int[] c1 = new int[0x101];
    int[] c2 = new int[0x101];
    int[] c3 = new int[0x101];
    for (int v : a) {
      c0[(v & 0xff) + 1]++;
      c1[(v >>> 8 & 0xff) + 1]++;
      c2[(v >>> 16 & 0xff) + 1]++;
      c3[(v >>> 24 ^ 0x80) + 1]++;
    }
    for (int i = 0; i < 0xff; i++) {
      c0[i + 1] += c0[i];
      c1[i + 1] += c1[i];
      c2[i + 1] += c2[i];
      c3[i + 1] += c3[i];
    }
    int[] t = new int[n];
    for (int v : a) {
      t[c0[v & 0xff]++] = v;
    }
    for (int v : t) {
      a[c1[v >>> 8 & 0xff]++] = v;
    }
    for (int v : a) {
      t[c2[v >>> 16 & 0xff]++] = v;
    }
    for (int v : t) {
      a[c3[v >>> 24 ^ 0x80]++] = v;
    }
    return a;
  }
}
