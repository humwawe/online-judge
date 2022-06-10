package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DCleaningThePhone {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[] a = new int[n];
    long sum = 0;
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      sum += a[i];
    }
    int[] b = new int[n];
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      b[i] = in.nextInt();
      if (b[i] == 1) {
        list1.add(a[i]);
      } else {
        list2.add(a[i]);
      }
    }
    if (sum < m) {
      out.println(-1);
      return;
    }
    list1.sort((x, y) -> y - x);
    list2.sort((x, y) -> y - x);
    long[] sum1 = new long[list1.size() + 1];
    for (int i = 0; i < list1.size(); i++) {
      sum1[i + 1] = sum1[i] + list1.get(i);
    }
    long[] sum2 = new long[list2.size() + 1];
    for (int i = 0; i < list2.size(); i++) {
      sum2[i + 1] = sum2[i] + list2.get(i);
    }
    int min = (int) 1e9;
    for (int i = 0; i <= list1.size(); i++) {
      long need = m - sum1[i];
      if (need > sum2[list2.size()]) {
        continue;
      }
      int j = Arrays.binarySearch(sum2, need);
      if (j < 0) {
        j = ~j;
      }
      min = Math.min(min, i + 2 * j);
    }
    out.println(min);
  }
}
