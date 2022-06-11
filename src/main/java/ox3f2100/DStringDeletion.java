package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class DStringDeletion {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    String s = in.nextString();
    List<Integer> list = new ArrayList<>();
    TreeSet<Integer> set = new TreeSet<>();
    for (int i = 0; i < n; i++) {
      int j = i;
      while (j + 1 < n && s.charAt(j + 1) == s.charAt(i)) {
        j++;
      }
      if (j - i + 1 > 1) {
        set.add(list.size());
      }
      list.add(j - i + 1);
      i = j;
    }
    int res = 0;
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i) > 1) {
        res++;
      } else {
        Integer higher = set.higher(i);
        if (higher != null) {
          int cur = list.get(higher) - 1;
          list.set(higher, cur);
          if (cur == 1) {
            set.remove(higher);
          }
          res++;
        } else {
          i++;
          res++;
        }
      }
    }
    out.println(res);
  }
}
