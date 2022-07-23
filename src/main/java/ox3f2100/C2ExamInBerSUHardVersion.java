package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class C2ExamInBerSUHardVersion {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
    long sum = 0;
    for (int i = 0; i < n; i++) {
      int x = in.nextInt();
      while (sum > m) {
        sum -= pq.poll();
      }
      int cur = m - x;
      long t = sum;
      List<Integer> list = new ArrayList<>();
      while (t > cur) {
        Integer poll = pq.poll();
        list.add(poll);
        t -= poll;
      }
      out.print(i - pq.size(), "");
      pq.addAll(list);
      sum += x;
      pq.add(x);
    }
  }
}
