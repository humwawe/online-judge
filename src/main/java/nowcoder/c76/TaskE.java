package nowcoder.c76;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class TaskE {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    String s = in.nextString();
    char[] chars = s.toCharArray();
    int cnt = 0;
    List<Integer> list = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == '(') {
        cnt++;
        list.add(i);
      }
    }
    if (cnt * 2 != s.length()) {
      out.println(-1);
      return;
    }

    int idx = 0;
    cnt = 0;
    long res = 0;
    for (int i = 0; i < n; i++) {
      if (chars[i] == '(') {
        idx++;
        cnt++;
      }
      if (i % 2 == 0) {
        if (cnt < i / 2 + 1) {
          res += Math.abs(list.get(idx) - cnt * 2);
          chars[list.get(idx)] = ')';
          idx++;
          cnt++;
        }
      }
    }
    out.println(res);
  }
}
