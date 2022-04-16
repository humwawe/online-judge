package acwing.contest.weekly.c47;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      a[i] = in.nextInt();
    }
    int[] b = new int[n];
    for (int i = 1; i <= n; i++) {
      b[i - 1] = a[i] - a[i - 1];
    }

    List<Integer> list = new ArrayList<>();
    for (int x = 1; x <= n; x++) {
      boolean f = true;
      int i = 0;
      int j = x;
      while (j < n) {
        if (b[i] != b[j]) {
          f = false;
          break;
        }
        i++;
        j++;
      }
      if (f) {
        list.add(x);
      }
    }
    out.println(list.size());
    out.println(list);
  }
}
