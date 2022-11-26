package acwing.contest.weekly.c79;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    char[] a = in.nextString().toCharArray();
    int[] cnt = new int[10];
    List<Integer>[] lists = new List[10];
    for (int i = 0; i < 10; i++) {
      lists[i] = new ArrayList<>();
    }
    for (int i = 0; i < n; i++) {
      lists[a[i] - '0'].add(i);
    }
    int cost = (int) 1e8;
    String res = "9".repeat(n);
    for (int i = 0; i < 10; i++) {
      int t = 0;
      char[] str = a.clone();
      int sum = lists[i].size();
      if (sum < k) {
        for (int j = 1; j <= 10; j++) {
          int x = i + j;
          if (sum < k && x < 10) {
            for (Integer idx : lists[x]) {
              str[idx] = (char) ('0' + i);
              sum++;
              t += x - i;
              if (sum == k) {
                break;
              }
            }
          }
          int y = i - j;
          if (sum < k && y >= 0) {
            for (int l = lists[y].size() - 1; l >= 0; l--) {
              str[lists[y].get(l)] = (char) ('0' + i);
              sum++;
              t += i - y;
              if (sum == k) {
                break;
              }
            }
          }
        }
      }

      if (t < cost) {
        cost = t;
        res = new String(str);
      } else if (t == cost) {
        String tmp = new String(str);
        if (res.compareTo(tmp) > 0) {
          res = tmp;
        }
      }
    }
    out.println(cost);
    out.println(res);

  }
}
