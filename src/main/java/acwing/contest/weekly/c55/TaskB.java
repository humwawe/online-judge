package acwing.contest.weekly.c55;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[] a = new int[n + m];
    for (int i = 0; i < n + m; i++) {
      a[i] = in.nextInt();
    }
    int[] b = new int[n + m];
    TreeSet<Integer> set = new TreeSet<>();
    for (int i = 0; i < n + m; i++) {
      b[i] = in.nextInt();
      if (b[i] == 1) {
        set.add(i);
      }
    }
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n + m; i++) {
      if (b[i] == 0) {
        Integer low = set.lower(i);
        Integer higher = set.higher(i);
        if (low != null && higher != null) {
          if (a[i] - a[low] <= a[higher] - a[i]) {
            map.put(low, map.getOrDefault(low, 0) + 1);
          } else {
            map.put(higher, map.getOrDefault(higher, 0) + 1);
          }
        } else if (low != null) {
          map.put(low, map.getOrDefault(low, 0) + 1);
        } else {
          map.put(higher, map.getOrDefault(higher, 0) + 1);
        }
      }
    }
    for (int i = 0; i < n + m; i++) {
      if (b[i] == 1) {
        out.print(map.getOrDefault(i, 0), "");
      }
    }
  }
}
