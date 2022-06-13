package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class BVovaAndTrophies {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    String s = in.nextString();
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int j = i;
      while (j + 1 < n && s.charAt(j + 1) == s.charAt(i)) {
        j++;
      }
      list.add(j - i + 1);
      i = j;
    }
    if (list.size() > 0 && s.charAt(n - 1) == 'S') {
      list.remove(list.size() - 1);
    }
    if (list.size() > 0 && s.charAt(0) == 'S') {
      list.remove(0);
    }
    int gSize = (list.size() + 1) / 2;
    if (gSize == 1) {
      out.println(list.get(0));
      return;
    }
    int max = 0;
    for (int i = 1; i < list.size(); i += 2) {
      if (list.get(i) == 1) {
        if (gSize > 2) {
          max = Math.max(max, list.get(i - 1) + list.get(i + 1) + 1);
        } else {
          max = Math.max(max, list.get(i - 1) + list.get(i + 1));
        }
      } else {
        max = Math.max(max, list.get(i - 1) + 1);
        max = Math.max(max, list.get(i + 1) + 1);
      }
    }
    out.println(max);
  }
}
