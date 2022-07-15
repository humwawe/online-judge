package codeforces.c807;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class CMarkAndHisUnfinishedEssay {
  int n, c, q;
  String s;
  long[][] range;
  List<Long> list;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    c = in.nextInt();
    q = in.nextInt();
    s = in.nextString();

    range = new long[c][2];
    for (int i = 0; i < c; i++) {
      range[i][0] = in.nextLong();
      range[i][1] = in.nextLong();
    }
    list = new ArrayList<>();

    long sum = n;
    list.add(sum);
    for (int i = 0; i < c; i++) {
      long x = range[i][1] - range[i][0];
      sum += x + 1;
      list.add(sum);
      if (sum > 1e18) {
        break;
      }
    }

    int k = list.size();
    for (int i = 0; i < q; i++) {
      long x = in.nextLong();
      out.println(dfs(x, k - 2));
    }
  }

  private char dfs(long x, int pre) {
    if (pre == -1) {
      return s.charAt((int) (x - 1));
    }

    if (x > list.get(pre)) {
      return dfs(x - list.get(pre) + range[pre][0] - 1, pre - 1);
    } else {
      return dfs(x, pre - 1);
    }
  }


}
