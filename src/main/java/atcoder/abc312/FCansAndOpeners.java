package atcoder.abc312;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FCansAndOpeners {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    List<Integer>[] lists = new List[3];
    Arrays.setAll(lists, e -> new ArrayList<>());
    for (int i = 0; i < n; i++) {
      int t = in.nextInt();
      int x = in.nextInt();
      lists[t].add(x);
    }
    for (int i = 0; i < 3; i++) {
      lists[i].sort((x, y) -> y - x);
    }

    long[][] sum = new long[3][];
    for (int i = 0; i < 3; i++) {
      sum[i] = new long[lists[i].size() + 1];
    }

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < lists[i].size(); j++) {
        sum[i][j + 1] = sum[i][j] + lists[i].get(j);
      }
    }

    long res = sum[0][Math.min(m, sum[0].length - 1)];

    for (int i = 1; i < Math.min(m, sum[1].length); i++) {
      int l = 0;
      int r = sum[2].length;
      while (l < r) {
        int mid = l + r >> 1;
        if (sum[2][mid] >= i) {
          r = mid;
        } else {
          l = mid + 1;
        }
      }
      int last = m - i - l;
      if (last < 0 || l == 0 || l == sum[2].length) {
        continue;
      }
      res = Math.max(res, sum[1][i] + sum[0][Math.min(last, sum[0].length - 1)]);
    }

    out.println(res);

  }
}
