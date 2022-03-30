package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.PriorityQueue;

public class CPalindromicMatrix {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int[] cnt = new int[1005];
    int n = in.nextInt();
    for (int i = 0; i < n * n; i++) {
      cnt[in.nextInt()]++;
    }

    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((x, y) -> y[1] - x[1]);

    for (int i = 0; i < 1005; i++) {
      if (cnt[i] > 0) {
        priorityQueue.add(new int[]{i, cnt[i]});
      }
    }
    int[][] res = new int[n][n];
    for (int i = 0; i < n / 2; i++) {
      for (int j = 0; j < n / 2; j++) {
        int[] cur = priorityQueue.poll();
        if (cur[1] < 4) {
          out.println("NO");
          return;
        }
        res[i][j] = res[n - 1 - i][j] = res[n - 1 - i][n - 1 - j] = res[i][n - 1 - j] = cur[0];
        if (cur[1] > 4) {
          priorityQueue.add(new int[]{cur[0], cur[1] - 4});
        }
      }
    }
    if (n % 2 == 1) {
      for (int i = 0; i < n / 2; i++) {
        int[] cur = priorityQueue.poll();
        if (cur[1] < 2) {
          out.println("NO");
          return;
        }
        res[i][n / 2] = res[n - 1 - i][n / 2] = cur[0];
        if (cur[1] > 2) {
          priorityQueue.add(new int[]{cur[0], cur[1] - 2});
        }
      }
      for (int i = 0; i < n / 2; i++) {
        int[] cur = priorityQueue.poll();
        if (cur[1] < 2) {
          out.println("NO");
          return;
        }
        res[n / 2][i] = res[n / 2][n - 1 - i] = cur[0];
        if (cur[1] > 2) {
          priorityQueue.add(new int[]{cur[0], cur[1] - 2});
        }
      }
      res[n / 2][n / 2] = priorityQueue.poll()[0];
    }
    out.println("YES");
    for (int i = 0; i < n; i++) {
      out.println(res[i]);
    }
  }

}
