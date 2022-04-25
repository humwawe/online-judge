package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class DSeaBattle {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int a = in.nextInt();
    int b = in.nextInt();
    int k = in.nextInt();
    String s = in.nextString();
    int cnt = 0;
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == '1') {
        cnt = 0;
      } else {
        cnt++;
        if (cnt == b) {
          cnt = 0;
          list.add(i + 1);
        }
      }
    }
    int res = list.size() - (a - 1);
    out.println(res);
    for (int i = 0; i < res; i++) {
      out.print(list.get(i), "");
    }
  }
}
