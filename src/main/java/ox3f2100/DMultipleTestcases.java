package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DMultipleTestcases {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    int[] a = new int[n];
    int[] b = new int[k];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    ruffleSort(a);
    for (int i = 0; i < k; i++) {
      b[i] = in.nextInt();
    }


    int x = n;
    int size = 0;
    for (int i = k; i >= 1; i--) {
      int t = b[i - 1];
      while (x - 1 >= 0 && a[x - 1] >= i) {
        x--;
      }
      size = Math.max(size, (n - x + t - 1) / t);
    }

    List<List<Integer>> lists = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      lists.add(new ArrayList<>());
    }
    for (int i = 0; i < n; i++) {
      lists.get(i % size).add(a[i]);
    }
    out.println(size);
    for (int i = 0; i < size; i++) {
      List<Integer> list = lists.get(i);
      out.print(list.size(), "");
      for (Integer v : list) {
        out.print(v, "");
      }
      out.println();
    }
  }

  void ruffleSort(int[] a) {
    Random get = new Random();
    for (int i = 0; i < a.length; i++) {
      int r = get.nextInt(a.length);
      int temp = a[i];
      a[i] = a[r];
      a[r] = temp;
    }
    Arrays.sort(a);
  }
}
