package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ETreeReconstruction {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    int[] cnt = new int[n + 1];
    boolean f = true;
    for (int i = 0; i < n - 1; i++) {
      a[i] = in.nextInt();
      cnt[a[i]]++;
      int x = in.nextInt();
      if (x != n) {
        f = false;
      }
    }
    if (!f) {
      out.println("NO");
      return;
    }
    LinkedList<Integer> list = new LinkedList<>();
    for (int i = 1; i < n; i++) {
      if (cnt[i] == 0) {
        list.add(i);
      }
    }

    List<int[]> res = new ArrayList<>();
    for (int i = n - 1; i >= 1; i--) {
      if (cnt[i] > 0) {
        if (list.size() < cnt[i] - 1) {
          out.println("NO");
          return;
        }
        if (cnt[i] > 1 && list.get(list.size() - 1) > i) {
          out.println("NO");
          return;
        }
        int last = n;
        for (int j = 0; j < cnt[i] - 1; j++) {
          res.add(new int[]{last, list.peekLast()});
          last = list.pollLast();
        }
        res.add(new int[]{last, i});
        cnt[i] = 0;
      }
    }
    out.println("YES");
    for (int[] re : res) {
      out.println(re[0], re[1]);
    }
  }
}
