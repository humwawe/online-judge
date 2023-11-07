package ccf.csp.c4;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int a = in.nextInt();
    int b = in.nextInt();
    int c = in.nextInt() % 7;
    int y1 = in.nextInt();
    int y2 = in.nextInt();

    int[] m = new int[]{0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int[] m2 = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    int[] cur = {1850, 1, 1, 2};


    List<String> list = new ArrayList<>();
    int[] cnt = new int[7];
    for (; ; ) {

      cnt[cur[3]]++;

      if (y1 <= cur[0] && cur[0] <= y2 && cur[1] == a) {
        if (cnt[c] == b && c == cur[3]) {
          String tmp = cur[0] + "/" + (cur[1] < 10 ? "0" + cur[1] : cur[1]) + "/" + (cur[2] < 10 ? "0" + cur[2] : cur[2]);
          list.add(tmp);
        }
      }

      if (cur[0] > y2) {
        break;
      }
      cur[2]++;
      cur[3]++;
      cur[3] %= 7;

      if (helper(cur[0])) {
        if (m[cur[1]] + 1 == cur[2]) {
          cur[2] = 1;
          cur[1]++;
          Arrays.fill(cnt, 0);
          if (cur[1] == 13) {
            cur[0]++;
            cur[1] = 1;
          }
        }
      } else {
        if (m2[cur[1]] + 1 == cur[2]) {
          cur[2] = 1;
          cur[1]++;
          Arrays.fill(cnt, 0);
          if (cur[1] == 13) {
            cur[0]++;
            cur[1] = 1;
          }
        }
      }
    }
    list.add("xx");
    int idx = 0;
    for (int i = y1; i <= y2; i++) {
      if (list.get(idx).startsWith("" + i)) {
        out.println(list.get(idx++));
      } else {
        out.println("none");
      }
    }

  }

  private boolean helper(int i) {
    return i % 400 == 0 || i % 4 == 0 && i % 100 != 0;
  }
}
