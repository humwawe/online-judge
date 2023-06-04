package codeforces.c876;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class CInsertZeroAndInvertPrefix {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = in.nextInt(n);
    if (a[n - 1] != 0) {
      out.println("NO");
      return;
    }
    int cnt = 0;
    List<Integer> list = new ArrayList<>();
    for (int i = n - 1; i >= 0; i--) {
      if (a[i] == 0) {
        if (cnt != 0) {
          list.remove(list.size() - 1);
          list.add(cnt);
        }
        list.add(0);
        cnt = 0;
      } else {
        cnt++;
        list.add(0);
      }
    }
    if (cnt != 0) {
      list.remove(list.size() - 1);
      list.add(cnt);
    }
    out.println("YES");
    out.println(list);
  }
}
