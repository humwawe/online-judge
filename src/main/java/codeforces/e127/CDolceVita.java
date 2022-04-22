package codeforces.e127;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;
import java.util.Random;

public class CDolceVita {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    long x = in.nextLong();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    ruffleSort(a);
    long[] sum = new long[n + 1];
    for (int i = 0; i < n; i++) {
      sum[i + 1] = sum[i] + a[i];
    }
    int j = n;
    long res = 0;
    for (long i = 0; ; i++) {
      while (j >= 0 && sum[j] + i * j > x) {
        j--;
      }
      if (j == 0) {
        break;
      }
      long ni = (x - sum[j]) / j;
      res += j * (ni - i + 1);
      i = ni;
    }
    out.println(res);


  }

  void ruffleSort(int[] a) {
    Random get = new Random();
    for (int i = 0; i < a.length; i++) {
      int r = get.nextInt(a.length);
      int temp = a[i];
      a[i] = a[r];
      a[r] = temp;
    }
    Arrays.sort(a);
  }
}
