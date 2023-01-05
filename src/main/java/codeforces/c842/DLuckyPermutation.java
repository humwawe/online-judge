package codeforces.c842;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DLuckyPermutation {
  int n;
  int[] a;
  int[] idx;
  boolean[] vis;
  boolean f;
  List<Integer> list;


  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();

    a = new int[n];
    idx = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt() - 1;
      idx[a[i]] = i;
    }

    vis = new boolean[n];
    int res = n;
    f = false;

    for (int i = 0; i < n; i++) {
      list = new ArrayList<>();
      if (!vis[a[i]]) {
        res--;
        dfs(a[i], i);
      }
      Collections.sort(list);
      for (int j = 1; j < list.size(); j++) {
        if (list.get(j) - list.get(j - 1) == 1) {
          f = true;
          break;
        }
      }
    }
    if (f) {
      out.println(res - 1);
    } else {
      out.println(res + 1);
    }


  }

  private void dfs(int cur, int i) {
    if (vis[cur]) {
      return;
    }
    vis[cur] = true;
    list.add(cur);

    dfs(a[idx[i]], idx[a[idx[i]]]);
  }
}
