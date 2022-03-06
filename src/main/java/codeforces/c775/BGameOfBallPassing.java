package codeforces.c775;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BGameOfBallPassing {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int t = in.nextInt();
      if (t != 0) {
        list.add(t);
      }
    }
    if (list.size() == 0) {
      out.println(0);
      return;
    }
    Collections.sort(list);
    long sum = 0;
    for (int i = 0; i < list.size() - 1; i++) {
      sum += list.get(i);
    }
    int max = list.get(list.size() - 1);
    out.println(Math.max(1, max - sum));
  }
}
