package atcoder.abc302;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;
import java.util.Iterator;

public class CAlmostEqual {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    String[] strs = new String[n];
    for (int i = 0; i < n; i++) {
      strs[i] = in.nextString();
    }
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = i;
    }
    IterablePermutation it = new IterablePermutation(a);
    while (it.hasNext()) {
      int[] idx = it.next();
      if (check(strs, idx)) {
        out.println("Yes");
        return;
      }
    }
    out.println("No");

  }

  private boolean check(String[] strs, int[] idx) {

    for (int i = 0; i < strs.length - 1; i++) {
      String a = strs[idx[i]];
      String b = strs[idx[i + 1]];
      int cnt = 0;
      for (int j = 0; j < a.length(); j++) {
        if (a.charAt(j) != b.charAt(j)) {
          cnt++;
        }
      }
      if (cnt != 1) {
        return false;
      }
    }
    return true;
  }

  class IterablePermutation implements Iterable<int[]>, Iterator<int[]> {
    int[] a;
    boolean first = true;

    public IterablePermutation(int n) {
      assert n >= 1;
      a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = i;
      }
    }

    public IterablePermutation(int... a) {
      this.a = Arrays.copyOf(a, a.length);
    }

    @Override
    public boolean hasNext() {
      if (first) {
        return true;
      }
      int n = a.length;
      int i;
      i = n - 2;
      while (i >= 0 && a[i] >= a[i + 1]) {
        i--;
      }
      return i != -1;
    }

    @Override
    public int[] next() {
      if (first) {
        first = false;
        return a;
      }
      int n = a.length;
      int i;
      i = n - 2;
      while (i >= 0 && a[i] >= a[i + 1]) {
        i--;
      }
      assert i != -1;
      int j;
      j = i + 1;
      while (j < n && a[i] < a[j]) {
        j++;
      }
      int d = a[i];
      a[i] = a[j - 1];
      a[j - 1] = d;
      for (int p = i + 1, q = n - 1; p < q; p++, q--) {
        d = a[p];
        a[p] = a[q];
        a[q] = d;
      }
      return a;
    }

    @Override
    public Iterator<int[]> iterator() {
      return this;
    }

    public void skip(int[] a, int id) {
      Arrays.sort(a, id + 1, a.length);
      for (int i = id + 1, j = a.length - 1; i < j; i++, j--) {
        int d = a[i];
        a[i] = a[j];
        a[j] = d;
      }
    }
  }
}
