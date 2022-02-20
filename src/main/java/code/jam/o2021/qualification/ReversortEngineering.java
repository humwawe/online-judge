package code.jam.o2021.qualification;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class ReversortEngineering {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int c = in.nextInt();
    int min = n - 1;
    int max = (n - 1) * 2 + (n - 1) * (n - 2) / 2;
    if (c < min || c > max) {
      out.printf("Case #%d: ", testNumber);
      out.println("IMPOSSIBLE");
      return;
    }
    c++;
    List<Integer> list = new ArrayList<>();
    int start = 1;
    while (c > 0) {
      int num = Math.min(n - start + 1, c - (n - start));
      list.add(num);
      start++;
      c -= num;
    }
    while (list.size() != n) {
      list.add(1);
    }
    int[] res = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      res[i] = i;
    }
    start = n;
    for (int i = list.size() - 1; i >= 0; i--) {
      int num = list.get(i);
      int l = start;
      int r = start + num - 1;
      while (l < r) {
        int tmp = res[l];
        res[l] = res[r];
        res[r] = tmp;
        l++;
        r--;
      }
      start--;
    }
    out.printf("Case #%d: ", testNumber);
    for (int i = 1; i <= n; i++) {
      out.print(res[i] + " ");
    }
    out.println();

  }
}
