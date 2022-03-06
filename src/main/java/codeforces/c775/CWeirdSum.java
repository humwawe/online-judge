package codeforces.c775;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.*;

public class CWeirdSum {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[][] a = new int[n][m];
    Map<Integer, List<Integer>> m1 = new HashMap<>();
    Map<Integer, List<Integer>> m2 = new HashMap<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        int c = in.nextInt();
        m1.computeIfAbsent(c, x -> new ArrayList<>()).add(i);
        m2.computeIfAbsent(c, x -> new ArrayList<>()).add(j);
      }
    }

    long res = 0;
    for (List<Integer> list : m1.values()) {
      Collections.sort(list);
      long sum = list.get(0);
      for (int i = 1; i < list.size(); i++) {
        res += (long) i * list.get(i) - sum;
        sum += list.get(i);
      }
    }
    for (List<Integer> list : m2.values()) {
      Collections.sort(list);
      long sum = list.get(0);
      for (int i = 1; i < list.size(); i++) {
        res += (long) i * list.get(i) - sum;
        sum += list.get(i);
      }
    }
    out.println(res);
  }

}
