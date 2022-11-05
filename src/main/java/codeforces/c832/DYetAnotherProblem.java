package codeforces.c832;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DYetAnotherProblem {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int q = in.nextInt();
    int[] a = new int[n];
    int[] sum = new int[n + 1];
    int[] left = new int[n];

    Map<Integer, Integer>[] map = new Map[2];
    Arrays.setAll(map, e -> new HashMap<>());
    map[0].put(0, 0);
    map[1].put(0, -1);
    int[] all0 = new int[n + 1];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      sum[i + 1] = sum[i] ^ a[i];
      all0[i + 1] = all0[i] + (a[i] != 0 ? 1 : 0);
      left[i] = map[i % 2].getOrDefault(sum[i + 1], -1);
      map[(i + 1) % 2].put(sum[i + 1], i + 1);
    }
    for (int i = 0; i < q; i++) {
      int l = in.nextInt();
      int r = in.nextInt();
      if ((sum[r] ^ sum[l - 1]) != 0) {
        out.println(-1);
      } else {
        if (all0[r] - all0[l - 1] == 0) {
          out.println(0);
        } else {
          if ((r - l + 1) % 2 == 1 || a[l - 1] == 0 || a[r - 1] == 0) {
            out.println(1);
          } else {
            if (left[r - 1] > l - 1) {
              out.println(2);
            } else {
              out.println(-1);
            }
          }
        }

      }
    }
  }
}
