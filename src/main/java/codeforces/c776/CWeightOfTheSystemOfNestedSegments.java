package codeforces.c776;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CWeightOfTheSystemOfNestedSegments {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();

    int[] x = new int[m];
    int[] w = new int[m];
    Integer[] idx = new Integer[m];
    for (int i = 0; i < m; i++) {
      x[i] = in.nextInt();
      w[i] = in.nextInt();
      idx[i] = i;
    }
    Arrays.sort(idx, Comparator.comparingInt(a -> w[a]));

    List<Integer> list = new ArrayList<>();
    int sum = 0;
    for (int i = 0; i < 2 * n; i++) {
      sum += w[idx[i]];
      list.add(idx[i]);
    }
    out.println(sum);
    list.sort(Comparator.comparingInt(a -> x[a]));
    for (int i = 0; i < n; i++) {
      out.println(list.get(i) + 1, list.get(2 * n - i - 1) + 1);
    }

    out.println();
  }
}

