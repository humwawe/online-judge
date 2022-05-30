package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class AZebras {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    int p = 0;
    List<List<Integer>> lists = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '0') {
        if (p == lists.size()) {
          List<Integer> list = new ArrayList<>();
          list.add(i);
          lists.add(list);
        } else {
          lists.get(p).add(i);
        }
        p++;
      } else {
        if (p == 0) {
          out.println(-1);
          return;
        } else {
          p--;
          lists.get(p).add(i);
        }
      }
    }
    if (p != lists.size()) {
      out.println(-1);
      return;
    }
    out.println(lists.size());
    for (List<Integer> list : lists) {
      out.print(list.size());
      for (Integer integer : list) {
        out.print("", integer + 1);
      }
      out.println();
    }

  }
}
