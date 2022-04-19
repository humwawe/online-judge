package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ESquaresAndNotSquares {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      long sqrt = (long) Math.sqrt(a[i]);
      if (sqrt * sqrt == a[i]) {
        list1.add(a[i]);
      } else {
        list2.add(a[i]);
      }
    }

    if (list1.size() == list2.size()) {
      out.println(0);
    } else if (list1.size() > list2.size()) {
      list1.sort((x, y) -> y - x);
      int res = 0;
      for (int i = 0; i < (list1.size() - list2.size()) / 2; i++) {
        if (list1.get(i) == 0) {
          res += 2;
        } else {
          res += 1;
        }
      }
      out.println(res);
    } else {
      List<Long> list = new ArrayList<>();
      for (Integer l : list2) {
        long sqrt = (long) Math.sqrt(l);
        list.add(Math.min(l - (sqrt * sqrt), (sqrt + 1) * (sqrt + 1) - l));
      }
      list.sort(Comparator.comparingLong(x -> x));
      long res = 0;
      for (int i = 0; i < (list2.size() - list1.size()) / 2; i++) {
        res += list.get(i);
      }
      out.println(res);
    }
  }
}
