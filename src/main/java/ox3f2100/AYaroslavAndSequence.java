package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AYaroslavAndSequence {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[2 * n - 1];
    int sum = 0;
    int cnt = 0;
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < a.length; i++) {
      a[i] = in.nextInt();
      if (a[i] < 0) {
        cnt++;
      }
      list.add(Math.abs(a[i]));
    }
    int x = (int) 1e8;
    for (int i = 0; i < n; i++) {
      int tmp = cnt - i + n - i;
      x = Math.min(x, (tmp + n) % n);
    }
    Collections.sort(list);

    for (int i = 0; i < 2 * n - 1; i++) {
      if (i < x) {
        sum -= list.get(i);
      } else {
        sum += list.get(i);
      }
    }
    out.println(sum);
  }
}
