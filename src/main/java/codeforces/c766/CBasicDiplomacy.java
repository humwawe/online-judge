package codeforces.c766;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class CBasicDiplomacy {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[] cnt = new int[n + 1];
    int cur = 0;
    boolean flag = true;
    List<Integer>[] lists = new List[m];
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      lists[i] = new ArrayList<>();
      int k = in.nextInt();
      for (int j = 0; j < k; j++) {
        int a = in.nextInt();
        lists[i].add(a);
      }
      if (k == 1) {
        cnt[lists[i].get(0)]++;
        if (cnt[lists[i].get(0)] > (m + 1) / 2) {
          flag = false;
        }
      }

    }
    if (!flag) {
      out.println("NO");
      return;
    }

    out.println("YES");

    for (int i = 0; i < m; i++) {
      int p = 0;
      int min = (int) 1e9;
      for (int j = 0; j < lists[i].size(); j++) {
        int v = lists[i].get(j);
        if (cnt[v] < min) {
          min = cnt[v];
          p = v;
        }
      }
      if (lists[i].size() != 1) {
        cnt[p]++;
      }
      out.print(p + " ");
    }
    out.println();

  }
}
