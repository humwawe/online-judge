package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class BTokitsukazeCSLAndStoneGame {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n + 1];
    for (int i = 1; i <= n; ++i) {
      a[i] = in.nextInt();
    }
    Arrays.sort(a, 1, n + 1);
    boolean flag = false;
    for (int i = 1; i <= n - 1; ++i) {
      if (a[i] == a[i + 1] && a[i] > 0) {
        --a[i];
        flag = true;
        break;
      }
    }
    for (int i = 1; i <= n - 1; ++i) {
      if (a[i] == a[i + 1]) {
        out.println("cslnb");
        return;
      }
    }
    int num = 0;
    for (int i = 1; i <= n; ++i) {
      num += a[i] - (i - 1);
    }
    if (flag) {
      num ^= 1;
    }
    if ((num & 1) == 1) {
      out.println("sjfnb");
    } else {
      out.println("cslnb");
    }
  }
}
