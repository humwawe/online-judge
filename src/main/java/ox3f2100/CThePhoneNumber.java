package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class CThePhoneNumber {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int q = (int) Math.sqrt(n);
    int[] res = new int[n];
    int idx = n - 1;
    List<Integer> list = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      if (i % q == 0) {
        list.add(i);
        for (int j = list.size() - 1; j >= 0; j--) {
          res[idx--] = list.get(j);
        }
        list.clear();
      } else {
        list.add(i);
      }
    }
    if (list.size() > 0) {
      for (int j = list.size() - 1; j >= 0; j--) {
        res[idx--] = list.get(j);
      }
    }
    out.println(res);
  }
}
