package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.List;
import java.util.TreeSet;

public class DMahmoudAndEhabAndAnotherArrayConstructionTask {
  int N = 1500000;
  boolean[] vis = new boolean[N];
  List<Integer>[] lists = new List[N];
  boolean[] primes = new boolean[N];

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    int[] b = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    TreeSet<Integer> treeSet = new TreeSet<>();
    for (int i = 2; i < N; i++) {
      treeSet.add(i);
    }
    boolean f = false;
    for (int i = 0; i < n; i++) {
      if (f) {
        b[i] = treeSet.pollFirst();
      } else {
        Integer ceiling = treeSet.ceiling(a[i]);
        b[i] = ceiling;
        if (b[i] > a[i]) {
          f = true;
        }
      }
      del(b[i], treeSet);
    }
    out.println(b);
  }

  private void del(int x, TreeSet<Integer> treeSet) {
    for (int i = 2; i * i <= x; i++) {
      if (x % i == 0) {
        for (int j = i; j < N; j += i) {
          treeSet.remove(j);
        }
        while (x % i == 0) {
          x /= i;
        }
      }
    }
    if (x > 1) {
      for (int j = x; j < N; j += x) {
        treeSet.remove(j);
      }
    }
  }

}
