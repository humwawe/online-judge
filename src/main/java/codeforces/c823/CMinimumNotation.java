package codeforces.c823;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CMinimumNotation {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    int n = s.length();
    int[] r = new int[10];
    Arrays.fill(r, -1);
    for (int i = 0; i < n; i++) {
      r[s.charAt(i) - '0'] = i;
    }

    int j = 0;
    List<Integer> list = new ArrayList<>();
    StringBuilder res = new StringBuilder();
    for (int i = 0; i < 10; i++) {
      int x = r[i];
      if (x == -1) {
        continue;
      }
      while (j <= r[i]) {
        int t = s.charAt(j) - '0';
        if (t != i) {
          list.add(Math.min(t + 1, 9));
        } else {
          list.add(i);
        }
        j++;
      }
    }
    list.sort(Comparator.comparingInt(x -> x));
    for (Integer integer : list) {
      res.append(integer);
    }
    out.println(res);

  }
}
