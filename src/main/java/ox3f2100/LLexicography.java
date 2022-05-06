package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LLexicography {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int l = in.nextInt();
    int k = in.nextInt();
    String s = in.nextString();
    char[] chars = s.toCharArray();
    Arrays.sort(chars);
    int i = 0;
    int j = s.length() - 1;
    List<StringBuilder> res = new ArrayList<>();
    for (int m = 0; m < n; m++) {
      res.add(new StringBuilder());
    }
    int x = k - 1;
    int start = 0;
    boolean[] vis = new boolean[n * l];
    int b = 0;
    int e = k - 2;
    for (int m = 0; m < l; m++) {
      char c = chars[x];
      vis[x] = true;
      res.get(k - 1).append(c);
      int cnt = 0;
      for (int o = start; o < x; o++) {
        if (chars[o] == c) {
          cnt++;
          res.get(e--).append(chars[o]);
        } else {
          res.get(b++).append(chars[o]);
        }
        vis[o] = true;
      }
      start = x + 1;
      x += cnt + 1;
      e = k - 2;
    }
    int idx = 0;
    for (int m = 0; m < n * l; m++) {
      if (vis[m]) {
        continue;
      }
      while (res.get(idx).length() >= l) {
        idx++;
      }
      res.get(idx).append(chars[m]);
    }

    for (StringBuilder sb : res) {
      out.println(sb.toString());
    }
  }
}
