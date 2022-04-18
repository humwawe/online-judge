package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class CArrayProduct {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    int cnt = 0;
    int minIdx = -1;
    List<Integer> list0 = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      if (a[i] < 0) {
        if (minIdx == -1 || a[i] > a[minIdx]) {
          minIdx = i;
        }
        cnt++;
      }
      if (a[i] == 0) {
        list0.add(i);
      }
    }

    boolean[] vis = new boolean[n];
    for (int i = 0; i < list0.size() - 1; i++) {
      out.println(1, list0.get(i) + 1, list0.get(i + 1) + 1);
      vis[list0.get(i)] = true;
    }

    if (cnt % 2 == 0) {
      if (list0.size() >= 1 && list0.size() != n) {
        out.println(2, list0.get(list0.size() - 1) + 1);
        vis[list0.get(list0.size() - 1)] = true;
      }
    } else {
      if (list0.size() > 0 && list0.size() != n - 1) {
        out.println(1, minIdx + 1, list0.get(list0.size() - 1) + 1);
        out.println(2, list0.get(list0.size() - 1) + 1);
        vis[minIdx] = true;
        vis[list0.get(list0.size() - 1)] = true;
      } else {
        out.println(2, minIdx + 1);
        vis[minIdx] = true;
      }
    }
    for (int i = 0; i < n; ) {
      if (vis[i]) {
        i++;
        continue;
      }
      int j = i + 1;
      while (j < n && vis[j]) {
        j++;
      }

      if (j < n) {
        out.println(1, i + 1, j + 1);
      }
      i = j;
    }

  }
}
