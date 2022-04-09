package code.jam.o2022.one.a;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EqualSum {

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();

    List<Integer> list = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    int[] a = new int[n];
    for (int i = 0; i < 30; i++) {
      a[i] = 1 << i;
      list.add(a[i]);
      set.add(a[i]);
    }
    int start = 1025;
    for (int i = 30; i < n; i++) {
      a[i] = start++;
      list.add(a[i]);
    }

    out.println(a);
    out.flush();

    for (int i = 0; i < n; i++) {
      int x = in.nextInt();
      list.add(x);
    }

    list.sort((x, y) -> y - x);
    long sum = 0;
    for (Integer x : list) {
      sum += x;
    }

    long t = sum / 2;
    List<Integer> res = new ArrayList<>();
    int i = 0;
    while (t >= (1 << 30)) {
      if (!set.contains(list.get(i))) {
        t -= list.get(i);
        res.add(list.get(i));
      }
      i++;
    }
    for (int j = 0; j < 30; j++) {
      if (((t >> j) & 1) == 1) {
        res.add(1 << j);
      }
    }
    out.println(res);
    out.flush();
  }

}
