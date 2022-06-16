package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class EPackmen {
  List<Integer> list1 = new ArrayList<>();
  List<Integer> list2 = new ArrayList<>();

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    String s = in.nextString();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '*') {
        list1.add(i);
      } else if (s.charAt(i) == 'P') {
        list2.add(i);
      }
    }
    int l = 1;
    int r = 2 * n;
    while (l < r) {
      int mid = l + r >> 1;
      if (check(mid)) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }

    out.println(l);

  }

  private boolean check(int mid) {

    int i = 0;
    for (Integer p2 : list2) {
      int p1 = list1.get(i);
      if (p2 - p1 > mid) {
        return false;
      }

      if (p1 - p2 > mid) {
        continue;
      }

      int r = p2 + mid;

      if (p2 > p1) {
        r = Math.max(mid + 2 * p1 - p2, (mid + p1 + p2) / 2);
      }

      while (i < list1.size() && list1.get(i) <= r) {
        i++;
      }
      if (i == list1.size()) {
        return true;
      }

    }
    return false;
  }
}
