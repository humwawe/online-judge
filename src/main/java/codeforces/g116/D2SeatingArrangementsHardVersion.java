package codeforces.g116;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class D2SeatingArrangementsHardVersion {
  int N = (int) (1e5 + 5);
  int n, m;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    m = in.nextInt();
    Integer[] nums = new Integer[n * m];
    for (int i = 0; i < n * m; i++) {
      nums[i] = in.nextInt();
    }
    int[] o = new int[n * m];
    for (int i = 0; i < n * m; i++) {
      o[i] = nums[i];
    }
    Arrays.sort(nums);
    Map<Integer, PriorityQueue<P>> map = new HashMap<>();
    int idx = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (!map.containsKey(nums[idx])) {
          map.put(nums[idx], new PriorityQueue<>());
        }
        map.get(nums[idx]).add(new P(i, j));
        idx++;
      }
    }
    boolean[][] vis = new boolean[n][m];
    int res = 0;
    for (int i = 0; i < n * m; i++) {
      int num = o[i];
      P cur = map.get(num).poll();
      for (int j = 0; j < cur.y; j++) {
        if (vis[cur.x][j]) {
          res++;
        }
      }
      vis[cur.x][cur.y] = true;
    }
    out.println(res);

  }

  class P implements Comparable<P> {
    int x, y;

    public P(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public int compareTo(P o) {
      if (x == o.x) {
        return o.y - y;
      }
      return x - o.x;
    }
  }


}
