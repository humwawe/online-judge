package codeforces.c855;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.PriorityQueue;

public class C2PoweringTheHeroHardVersion {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    PriorityQueue<Integer> pr = new PriorityQueue<>((x, y) -> y - x);
    long res = 0;
    for (int i = 0; i < n; i++) {
      int x = in.nextInt();
      if (x == 0) {
        if (!pr.isEmpty()) {
          res += pr.poll();
        }
      } else {
        pr.add(x);
      }
    }
    out.println(res);
  }
}
