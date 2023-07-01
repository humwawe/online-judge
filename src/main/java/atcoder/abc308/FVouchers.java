package atcoder.abc308;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FVouchers {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[] p = in.nextInt(n);

    int[] l = in.nextInt(m);
    int[] d = in.nextInt(m);
    Arrays.sort(p);
    Integer[] idx = new Integer[m];
    for (int i = 0; i < m; i++) {
      idx[i] = i;
    }
    Arrays.sort(idx, Comparator.comparingInt(x -> l[x]));

    int j = 0;
    long res = 0;
    long sum = 0;
    PriorityQueue<Integer> pr = new PriorityQueue<>((x, y) -> d[y] - d[x]);
    for (int i = 0; i < n; i++) {
      int cur = p[i];
      sum += cur;
      while (j < m && l[idx[j]] <= cur) {
        pr.add(idx[j]);
        j++;
      }
      if (!pr.isEmpty()) {
        res += d[pr.poll()];
      }
    }
    out.println(sum - res);

  }
}
