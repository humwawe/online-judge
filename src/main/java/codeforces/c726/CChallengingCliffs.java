package codeforces.c726;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CChallengingCliffs {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }

    radixSort2(a);
    if (n == 2) {
      out.println(a);
      return;
    }
    int min = (int) (1e9 + 10);
    int idx = 0;
    for (int i = 1; i < n; i++) {
      if (a[i] - a[i - 1] < min) {
        min = a[i] - a[i - 1];
        idx = i;
      }
    }
    for (int i = idx; i < n; i++) {
      out.print(a[i] + " ");
    }
    for (int i = 0; i < idx; i++) {
      out.print(a[i] + " ");
    }
    out.println();
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
