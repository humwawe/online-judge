package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class CPrimesAndMultiplication {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int x = in.nextInt();
    long n = in.nextLong();
    List<Integer> list = new ArrayList<>();
    for (int i = 2; i * i <= x; i++) {
      if (x % i == 0) {
        list.add(i);
      }
      while (x % i == 0) {
        x /= i;
      }
    }
    if (x > 1) {
      list.add(x);
    }
    int mod = (int) (1e9 + 7);
    long res = 1;
    for (Integer p : list) {
      long t = n;
      long cnt = 0;
      while (t > 0) {
        cnt += t / p;
        t /= p;
      }
      res = res * qp(p, cnt, mod) % mod;
    }
    out.println(res);
  }

  int qp(int m, long k, int p) {
    long res = 1 % p, t = m;
    while (k > 0) {
      if ((k & 1) == 1) {
        res = res * t % p;
      }
      t = t * t % p;
      k >>= 1;
    }
    return (int) res % p;
  }
}
