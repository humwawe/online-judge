package codeforces.c754;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BReverseSort {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    String s = in.nextString();
    int i = 0;
    int j = n - 1;
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();
    while (i <= j) {
      while (i <= j && s.charAt(i) == '0') {
        i++;
      }
      if (i <= j && s.charAt(i) == '1') {
        list1.add(i + 1);
        i++;
      }
      while (j >= i && s.charAt(j) == '1') {
        j--;
      }
      if (j >= i && s.charAt(j) == '0') {
        list2.add(j + 1);
        j--;
      }
    }

    if (list1.size() > 0 && list2.size() > 0) {
      out.println(1);
      out.print(list1.size() + list2.size());
      out.print(" ");
      for (Integer integer : list1) {
        out.print(integer + " ");
      }
      Collections.reverse(list2);
      for (Integer integer : list2) {
        out.print(integer + " ");
      }
      out.println();

    } else {
      out.println(0);
    }
  }

}
