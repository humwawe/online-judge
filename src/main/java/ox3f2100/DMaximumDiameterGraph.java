package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class DMaximumDiameterGraph {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    int sum = 0;
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      sum += a[i];
      if (a[i] >= 2) {
        list1.add(i);
      } else {
        list2.add(i);
      }
    }
    if (sum < 2 * n - 2) {
      out.println("NO");
      return;
    }
    out.print("YES ");
    if (list2.size() > 0) {
      out.println(list1.size() - 1 + Math.min(list2.size(), 2));
    } else {
      out.println(list1.size() - 1);
    }
    List<int[]> res = new ArrayList<>();

    for (int i = 0; i < list1.size() - 1; i++) {
      res.add(new int[]{list1.get(i), list1.get(i + 1)});
      a[list1.get(i)]--;
      a[list1.get(i + 1)]--;
    }
    if (list2.size() > 0) {
      res.add(new int[]{list1.get(list1.size() - 1), list2.get(0)});
      a[list1.get(list1.size() - 1)]--;
    }
    int i = 0;
    int j = 1;
    while (j < list2.size()) {
      for (int k = 0; j < list2.size() && k < a[list1.get(i)]; k++) {
        res.add(new int[]{list1.get(i), list2.get(j)});
        j++;
      }
      i++;
    }
    out.println(res.size());
    for (int[] r : res) {
      out.println(r[0] + 1, r[1] + 1);
    }
  }
}
