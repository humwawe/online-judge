package acwing.contest.weekly.c42;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int q = in.nextInt();
    String s1 = in.nextString();
    String s2 = in.nextString();
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();
    for (int i = 0; i + m <= n; i++) {
      if (s1.substring(i, i + m).equals(s2)) {
        list1.add(i);
        list2.add(i + m - 1);
      }
    }
    for (int i = 0; i < q; i++) {
      int l = in.nextInt() - 1;
      int r = in.nextInt() - 1;
      int i1 = Collections.binarySearch(list1, l);
      if (i1 < 0) {
        i1 = ~i1;
      }
      int i2 = Collections.binarySearch(list2, r + 1);
      if (i2 < 0) {
        i2 = ~i2;
      }
      out.println(Math.max(0, i2 - i1));
    }
  }
}
