package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class E2ThreeBlocksPalindromeHardVersion {
  int N = 200;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    int[][] sum = new int[n + 1][N + 1];
    List<Integer>[] lists = new List[N + 1];
    for (int i = 1; i <= N; i++) {
      lists[i] = new ArrayList<>();
    }
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      for (int j = 0; j <= N; j++) {
        sum[i + 1][j] = sum[i][j];
      }
      sum[i + 1][a[i]]++;
      lists[a[i]].add(i);
    }
    int res = 0;


    for (int i = 1; i <= N; i++) {
      List<Integer> list = lists[i];
      res = Math.max(res, lists[i].size());
      int l = 0;
      int r = list.size() - 1;
      while (l < r) {
        int left = list.get(l);
        int right = list.get(r);
        for (int j = 1; j <= N; j++) {
          res = Math.max(res, (l + 1) * 2 + sum[right][j] - sum[left + 1][j]);
        }
        l++;
        r--;
      }
    }
    out.println(res);

  }
}
