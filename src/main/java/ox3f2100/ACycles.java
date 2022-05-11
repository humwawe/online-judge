package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class ACycles {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int k = in.nextInt();

    List<Long> list = new ArrayList<>();
    long sum = 0;
    long cnt = 2;
    while ((cnt + 1) * cnt * (cnt - 1) / 6 <= k) {
      cnt++;
    }
    k -= cnt * (cnt - 1) * (cnt - 2) / 6;
    list.add(cnt);
    sum += cnt;

    while (k > 0) {
      cnt = 1;
      while ((cnt + 1) * cnt / 2 <= k) {
        cnt++;
      }
      k -= cnt * (cnt - 1) / 2;
      list.add(cnt);
      sum++;
    }

    int[][] res = new int[(int) (sum + 5)][(int) (sum + 5)];

    int l = 1;
    int r = (int) (list.get(0) + l);
    for (int j = l; j < r; j++) {
      for (int m = l; m < r; m++) {
        if (j == m) {
          continue;
        }
        res[j][m] = 1;
      }
    }

    for (int i = 1; i < list.size(); i++) {
      cnt = list.get(i);
      int p = r;
      for (int j = 1; j <= cnt; j++) {
        res[p][j] = 1;
        res[j][p] = 1;
      }
      r++;
    }

    out.println(sum);
    for (int i = 1; i <= sum; i++) {
      for (int j = 1; j <= sum; j++) {
        out.print(res[i][j]);
      }
      out.println();
    }

  }
}
