package nowcoder.r1;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    char[] a = in.nextString().toCharArray();
    int n = a.length;
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (a[i] == '1') {
        list.add(i);
      }
    }
    long res = (long) 1e15;
    if (n % 2 == 0) {
      res = Math.min(helper(list, 0), res);
      res = Math.min(helper(list, 1), res);
    } else {
      if (list.size() == n / 2) {
        res = Math.min(helper(list, 0), res);
      } else {
        res = Math.min(helper(list, 1), res);
      }
    }
    out.println(res);

  }

  private long helper(List<Integer> list, int i) {
    long res = 0;
    int idx = 0;
    if (i == 0) {
      idx = 1;
    }
    for (int j = 0; j < list.size(); j++) {
      res += Math.abs(list.get(j) - idx);
      idx += 2;
    }
    return res;
  }
}
