package acwing.contest.weekly.c121;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[][] a = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        a[i][j] = in.nextInt();
      }
    }

    List<Integer> list = new ArrayList<>();
    f:
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (a[i][j] == 1 || a[i][j] == 3) {
          continue f;
        }
      }
      list.add(i);
    }
    out.println(list.size());
    for (int i = 0; i < list.size(); i++) {
      out.print(list.get(i) + 1, "");
    }
  }
}
