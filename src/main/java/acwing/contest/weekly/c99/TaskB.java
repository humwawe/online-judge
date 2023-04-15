package acwing.contest.weekly.c99;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.*;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int s = in.nextInt();
    TreeMap<Integer, Long> treeMap1 = new TreeMap<>();
    TreeMap<Integer, Long> treeMap2 = new TreeMap<>((x, y) -> y - x);
    for (int i = 0; i < n; i++) {
      char t = in.nextCharacter();
      int p = in.nextInt();
      long q = in.nextInt();
      if (t == 'S') {
        treeMap1.put(p, treeMap1.getOrDefault(p, 0L) + q);
      } else {
        treeMap2.put(p, treeMap2.getOrDefault(p, 0L) + q);
      }
    }
    int cnt = 0;
    List<String> res = new ArrayList<>();
    for (Map.Entry<Integer, Long> integerLongEntry : treeMap1.entrySet()) {
      res.add("S " + integerLongEntry.getKey() + " " + integerLongEntry.getValue());
      cnt++;
      if (cnt >= s) {
        break;
      }
    }
    Collections.reverse(res);
    for (String re : res) {
      out.println(re);
    }
    cnt = 0;
    for (Map.Entry<Integer, Long> integerLongEntry : treeMap2.entrySet()) {
      out.println("B", integerLongEntry.getKey(), integerLongEntry.getValue());
      cnt++;
      if (cnt >= s) {
        break;
      }
    }
  }
}
