package codeforces.e129;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DRequiredLength {
  String[] t = new String[]{"9", "8", "7", "6", "5", "4", "3", "2"};
  Random random = new Random();
  int res = 10000;
  int n;
  long x;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    x = in.nextLong();

    for (int i = 0; i < 5e5; i++) {
      helper2(x);
    }
    if (res == 10000) {
      out.println(-1);
      return;
    }
    out.println(res);
    //
    //    Queue<Long> queue = new ArrayDeque<>();
    //    queue.add(x);
    //    int ans = 0;
    //    while (!queue.isEmpty()) {
    //      int size = queue.size();
    //
    //      for (int i = 0; i < size; i++) {
    //        Long cur = queue.poll();
    //        if (String.valueOf(cur).length() == n) {
    //          out.println(ans);
    //          return;
    //        }
    //        List<Integer> list = helper3(cur);
    //        for (Integer l : list) {
    //          if (ans + 1 + n - String.valueOf(l * cur).length() >= res) {
    //            continue;
    //          }
    //          queue.add(l * cur);
    //        }
    //      }
    //      ans++;
    //    }
    //    out.println(res);
  }

  private List<Integer> helper3(Long x) {
    String tmp = String.valueOf(x);
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < 8; i++) {
      if (tmp.contains(t[i])) {
        list.add(9 - i);
      }
    }
    return list;
  }

  void helper2(long x) {
    int ans = 0;
    while (String.valueOf(x).length() != n) {
      int max = helper(x);
      if (max <= 1) {
        return;
      }
      x = x * max;
      ans++;
      if (ans + n - String.valueOf(x).length() >= res) {
        return;
      }
    }
    res = Math.min(res, ans);
  }


  private int helper(long x) {
    String tmp = String.valueOf(x);
    List<String> list = new ArrayList<>();
    for (String s : t) {
      if (tmp.contains(s)) {
        list.add(s);
      }
    }
    if (list.size() == 0) {
      return -1;
    }
    int idx = random.nextInt(list.size()) % 3;
    return Integer.parseInt(list.get(idx));

  }
}
