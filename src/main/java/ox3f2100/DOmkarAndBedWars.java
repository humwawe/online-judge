package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class DOmkarAndBedWars {
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
    if (list.size() == 1) {
      out.println((list.get(0) + 2) / 3);
      return;
    }
    if (s.charAt(0) == s.charAt(n - 1)) {
      list.set(0, list.get(0) + list.get(list.size() - 1));
      list.remove(list.size() - 1);
    }

    int res = 0;
    for (Integer v : list) {
      res += v / 3;
    }
    out.println(res);
  }

}
