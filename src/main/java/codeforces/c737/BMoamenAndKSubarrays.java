package codeforces.c737;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.TreeSet;

public class BMoamenAndKSubarrays {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    TreeSet<Integer> set = new TreeSet<>();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      set.add(a[i]);
    }
    int cnt = 0;
    for (int i = 0; i < n - 1; i++) {
      Integer ceiling = set.ceiling(a[i] + 1);
      if (ceiling != null && ceiling == a[i + 1]) {
        continue;
      } else {
        cnt++;
      }
    }
    if (cnt < k) {
      out.println("Yes");
    } else {
      out.println("No");
    }
  }
}
