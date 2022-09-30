package codeforces.g21;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class CFishingprincePlaysWithArray {

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    int k = in.nextInt();
    int[] b = new int[k];
    for (int i = 0; i < k; i++) {
      b[i] = in.nextInt();
    }

    List<long[]> list1 = helper(a, m);
    List<long[]> list2 = helper(b, m);

    if (list1.size() != list2.size()) {
      out.println("No");
      return;
    }

    for (int i = 0; i < list1.size(); i++) {
      long[] l1 = list1.get(i);
      long[] l2 = list2.get(i);

      if (l1[0] != l2[0] || l1[1] != l2[1]) {
        out.println("No");
        return;
      }
    }
    out.println("Yes");
  }

  private List<long[]> helper(int[] a, int m) {
    List<long[]> list = new ArrayList<>();
    for (int i = 0; i < a.length; i++) {
      long x = a[i];
      long y = 1;
      while (x % m == 0) {
        x /= m;
        y *= m;
      }
      if (!list.isEmpty() && list.get(list.size() - 1)[0] == x) {
        list.get(list.size() - 1)[1] += y;
      } else {
        list.add(new long[]{x, y});
      }

    }
    return list;

  }
}
