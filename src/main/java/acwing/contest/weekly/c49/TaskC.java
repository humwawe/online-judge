package acwing.contest.weekly.c49;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskC {

  int mod = 998244353;
  int[] h;
  int[] e;
  int[] ne;
  int idx;
  int[] color;
  int even;
  int sum;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    h = new int[n + 1];
    color = new int[n + 1];
    e = new int[m * 2 + 5];
    ne = new int[m * 2 + 5];
    Arrays.fill(h, -1);
    Arrays.fill(color, -1);
    idx = 0;


    for (int i = 0; i < m; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      add(a, b);
      add(b, a);
    }

    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      if (color[i] == -1) {
        even = 0;
        sum = 0;
        if (!dfs(i, 1)) {
          out.println(0);
          return;
        } else {
          list1.add(even);
          list2.add(sum - even);
        }
      }
    }
    long res = 1;
    for (int i = 0; i < list1.size(); i++) {
      int e = list1.get(i);
      int o = list2.get(i);
      res = res * (helper(o) + helper(e) % mod) % mod;
    }
    out.println(res);

  }

  private long helper(int odd) {
    long res = 1;
    for (int i = 0; i < odd; i++) {
      res = (res * 2) % mod;
    }
    return res;
  }

  boolean dfs(int u, int c) {
    color[u] = c;
    sum++;
    if (color[u] % 2 == 0) {
      even++;
    }
    for (int i = h[u]; i != -1; i = ne[i]) {
      int j = e[i];
      if (color[j] == -1) {
        if (!dfs(j, 1 - c)) {
          return false;
        }
      } else if (color[j] == c) {
        return false;
      }
    }
    return true;
  }

  void add(int a, int b) {
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
  }
}
