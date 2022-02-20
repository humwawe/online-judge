package codeforces.c725;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AStoneGame {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    int len = a.length;
    int min = 105;
    int minIndex = 0;
    int max = 0;
    int maxIndex = 0;
    for (int i = 0; i < len; i++) {
      if (a[i] < min) {
        minIndex = i;
        min = a[i];
      }
      if (a[i] > max) {
        maxIndex = i;
        max = a[i];
      }
    }
    if (minIndex > maxIndex) {
      int tmp = maxIndex;
      maxIndex = minIndex;
      minIndex = tmp;
    }
    out.println(Math.min(minIndex + 1 + len - maxIndex, Math.min(maxIndex + 1, len - minIndex)));
  }
}
