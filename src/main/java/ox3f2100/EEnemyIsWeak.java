package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class EEnemyIsWeak {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    a = new int[n];
    int[] b = new int[n];
    BinaryIndexedTree prev = new BinaryIndexedTree();
    BinaryIndexedTree suf = new BinaryIndexedTree();
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      b[i] = a[i];
    }
    discrete();
    for (int i = 0; i < n; i++) {
      b[i] = find(b[i]);
      suf.add(b[i], 1);
    }
    long res = 0;
    for (int i = 0; i < n; i++) {
      int x = b[i];
      int p1 = i - prev.sum(x);
      suf.add(x, -1);
      int p2 = suf.sum(x - 1);
      res += (long) p1 * p2;
      prev.add(x, 1);
    }
    out.println(res);

  }

  int N = (int) (1e6 + 5);
  int[] a;
  int len = 0;

  void discrete() {
    Arrays.sort(a);
    for (int i = 0; i < a.length; i++) {
      if (i == 0 || a[i] != a[i - 1]) {
        a[len++] = a[i];
      }
    }
  }

  public int find(int x) {
    return Arrays.binarySearch(a, 0, len, x) + 1;
  }


  class BinaryIndexedTree {

    int[] t = new int[N];

    int lowbit(int x) {
      return x & -x;
    }

    // 位置从1开始
    void add(int x, int c) {
      for (int i = x; i < N; i += lowbit(i)) {
        t[i] += c;
      }
    }

    int sum(int x) {
      int res = 0;
      for (int i = x; i > 0; i -= lowbit(i)) {
        res += t[i];
      }
      return res;
    }
  }
}
