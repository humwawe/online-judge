package codeforces.c772;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class ACowsAndSequence {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    List<Double> list = new ArrayList<>();
    int n = in.nextInt();
    int N = (int) (2e5 + 5);
    int[] op = new int[N];
    int[] v = new int[N];
    long sum = 0;
    int cnt = 1;
    for (int i = 0; i < n; i++) {
      int t = in.nextInt();
      if (t == 1) {
        int a = in.nextInt();
        int x = in.nextInt();
        op[a] += x;
        sum += a * x;
      } else if (t == 2) {
        int k = in.nextInt();
        sum += k;
        v[cnt++] = k;
      } else {
        sum -= v[cnt - 1] + op[cnt];
        op[cnt - 1] += op[cnt];
        op[cnt] = 0;
        cnt--;
      }
      out.println((double) sum / cnt);
    }
  }
}
