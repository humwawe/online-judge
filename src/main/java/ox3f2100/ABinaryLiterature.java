package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class ABinaryLiterature {
  StringBuilder sb = new StringBuilder();
  int n;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    String[] a = new String[3];
    for (int i = 0; i < 3; i++) {
      a[i] = in.nextString();
    }
    List<String> l0 = new ArrayList<>();
    List<String> l1 = new ArrayList<>();

    for (int i = 0; i < 3; i++) {
      int cnt = 0;
      for (char c : a[i].toCharArray()) {
        if (c == '0') {
          cnt++;
        }
      }
      if (cnt >= n) {
        l0.add(a[i]);
      } else {
        l1.add(a[i]);
      }
    }

    if (l0.size() >= 2) {
      out.println(helper(l0.get(0), l0.get(1), '0'));
    } else {
      out.println(helper(l1.get(0), l1.get(1), '1'));
    }
  }

  private String helper(String a, String b, char c) {
    StringBuilder sb = new StringBuilder();
    List<Integer> list1 = new ArrayList<>();
    list1.add(-1);
    List<Integer> list2 = new ArrayList<>();
    list2.add(-1);
    for (int i = 0; i < 2 * n; i++) {
      if (a.charAt(i) == c) {
        list1.add(i);
      }
      if (b.charAt(i) == c) {
        list2.add(i);
      }
    }
    // n 个 c
    for (int i = 0; i < n; i++) {
      for (int j = list1.get(i) + 1; j < list1.get(i + 1); j++) {
        sb.append(a.charAt(j));
      }
      for (int j = list2.get(i) + 1; j < list2.get(i + 1); j++) {
        sb.append(b.charAt(j));
      }
      sb.append(c);
    }

    for (int i = list1.get(n) + 1; i < 2 * n; i++) {
      sb.append(a.charAt(i));
    }
    for (int i = list2.get(n) + 1; i < 2 * n; i++) {
      sb.append(b.charAt(i));
    }
    return sb.toString();
  }
}
