package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CVasyaAndArray {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();
    int[] l = new int[m];
    int[] r = new int[m];
    for (int i = 0; i < m; i++) {
      int t = in.nextInt();
      l[i] = in.nextInt() - 1;
      r[i] = in.nextInt() - 1;
      if (t == 1) {
        list1.add(i);
      } else {
        list2.add(i);
      }
    }
    int[] res = new int[n];
    int start = (int) 1e8;
    int N = 1005;
    list1.sort(Comparator.comparingInt(x -> l[x]));
    for (int i = 0; i < list1.size(); ) {
      int min = l[list1.get(i)];
      int max = r[list1.get(i)];
      int j = i;
      while (j + 1 < list1.size() && l[list1.get(j + 1)] <= max) {
        max = Math.max(max, r[list1.get(j + 1)]);
        j++;
      }
      for (int k = min; k <= max; k++) {
        res[k] = start;
      }
      i = j + 1;
      start -= N;
    }
    int last = (int) 1e9;
    for (int i = 0; i < n; i++) {
      if (res[i] == 0) {
        res[i] = --last;
      } else {
        last = res[i];
      }
    }

    f:
    for (Integer integer : list2) {
      int x = l[integer];
      int y = r[integer];
      for (int i = x; i < y; i++) {
        if (res[i] > res[i + 1]) {
          continue f;
        }
      }
      out.println("NO");
      return;
    }
    out.println("YES");
    out.println(res);
  }
}
