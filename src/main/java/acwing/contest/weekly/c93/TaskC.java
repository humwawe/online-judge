package acwing.contest.weekly.c93;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class TaskC {
  int n;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list.add(in.nextInt());
    }

    out.println(dfs(30, list));

  }

  private int dfs(int i, List<Integer> list) {
    if (i < 0) {
      return 0;
    }
    if (list.size() == 0) {
      return 0;
    }

    List<Integer> list0 = new ArrayList<>();
    List<Integer> list1 = new ArrayList<>();

    for (Integer integer : list) {
      if ((integer >> i & 1) == 1) {
        list1.add(integer);
      } else {
        list0.add(integer);
      }
    }
    if (list0.size() == 0) {
      return dfs(i - 1, list1);
    }
    if (list1.size() == 0) {
      return dfs(i - 1, list0);
    }
    return Math.min(dfs(i - 1, list0), dfs(i - 1, list1)) + (1 << i);
  }
}
