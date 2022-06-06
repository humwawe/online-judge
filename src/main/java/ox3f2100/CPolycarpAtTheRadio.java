package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class CPolycarpAtTheRadio {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[] a = new int[n];
    List<Integer>[] lists = new List[m + 1];
    for (int i = 0; i <= m; i++) {
      lists[i] = new ArrayList<>();
    }
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      if (a[i] <= m) {
        lists[a[i]].add(i);
      } else {
        lists[0].add(i);
      }
    }

    int c = n / m;

    for (int i = 1; i <= m; i++) {
      if (lists[i].size() > c) {
        for (int k = c; k < lists[i].size(); k++) {
          lists[0].add(lists[i].get(k));
        }
      }
    }
    int j = 0;
    int cnt = 0;
    for (int i = 1; i <= m; i++) {
      while (lists[i].size() < c) {
        lists[i].add(lists[0].get(j));
        a[lists[0].get(j++)] = i;
        cnt++;
      }
    }
    out.println(c, cnt);
    out.println(a);
  }
}
