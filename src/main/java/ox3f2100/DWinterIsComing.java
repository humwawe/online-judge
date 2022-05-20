package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DWinterIsComing {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    int k = in.nextInt();
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      if (a[i] < 0) {
        k--;
      }
    }
    if (k < 0) {
      out.println(-1);
      return;
    }
    List<Integer> list = new ArrayList<>();
    boolean f = true;
    for (int i = 0; i < n; i++) {
      if (a[i] < 0) {
        f = false;
      }
      if (a[i] >= 0 && !f) {
        int j = i;
        while (j + 1 < n && a[j + 1] >= 0) {
          j++;
        }
        list.add(j - i + 1);
        i = j;
      }
    }
    if (list.size() == 0) {
      if (f) {
        out.println(0);
      } else {
        out.println(1);
      }
      return;
    }
    int last = 0;
    if (a[n - 1] >= 0) {
      last = list.get(list.size() - 1);
      list.remove(list.size() - 1);
    }
    Collections.sort(list);
    int idx = 0;
    while (idx < list.size() && k >= list.get(idx)) {
      k -= list.get(idx);
      idx++;
    }
    int res = (list.size() - idx) * 2 + 1;
    if (k < last) {
      res++;
    }

    out.println(res);
  }
}
