package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class CHeapOperations {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    List<String> res = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      String s = in.nextString();
      if (s.charAt(0) == 'r') {
        if (priorityQueue.isEmpty()) {
          res.add("insert 3");
        } else {
          priorityQueue.poll();
        }
        res.add("removeMin");
      } else {
        int x = in.nextInt();
        if (s.charAt(0) == 'i') {
          priorityQueue.add(x);
          res.add(s + " " + x);
        } else {
          while (!priorityQueue.isEmpty() && priorityQueue.peek() < x) {
            res.add("removeMin");
            priorityQueue.poll();
          }
          if (priorityQueue.isEmpty() || priorityQueue.peek() != x) {
            priorityQueue.add(x);
            res.add("insert " + x);
          }
          res.add("getMin " + x);
        }
      }
    }
    out.println(res.size());
    for (String s : res) {
      out.println(s);
    }
  }
}
