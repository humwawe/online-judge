package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class GPractice {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();

    Queue<int[]> queue = new ArrayDeque<>();
    queue.add(new int[]{1, n});
    List<List<Integer>> res = new ArrayList<>();
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> list = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        int[] cur = queue.poll();
        int mid = cur[0] + cur[1] >> 1;
        for (int j = cur[0]; j <= mid; j++) {
          list.add(j);
        }
        if (mid - cur[0] + 1 >= 2) {
          queue.add(new int[]{cur[0], mid});
        }
        if (cur[1] - mid >= 2) {
          queue.add(new int[]{mid + 1, cur[1]});
        }
      }
      res.add(list);
    }
    out.println(res.size());
    for (List<Integer> r : res) {
      out.print(r.size(), "");
      out.println(r);
    }
  }
}
