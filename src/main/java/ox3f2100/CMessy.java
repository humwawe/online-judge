package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class CMessy {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    StringBuilder s = new StringBuilder(in.nextString());
    int cnt = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        cnt++;
      }
    }
    StringBuilder t = new StringBuilder();
    t.append("()".repeat(k - 1));
    t.append("(".repeat(cnt - (k - 1)));
    t.append(")".repeat(cnt - (k - 1)));

    List<int[]> list = new ArrayList<>();
    for (int i = 0; i < t.length(); i++) {
      int j = i;
      while (j < s.length() && t.charAt(i) != s.charAt(j)) {
        j++;
      }
      if (i != j) {
        list.add(new int[]{i, j});
        s.setCharAt(j, s.charAt(i));
      }
    }
    out.println(list.size());
    for (int[] l : list) {
      out.println(l[0] + 1, l[1] + 1);
    }
  }
}
