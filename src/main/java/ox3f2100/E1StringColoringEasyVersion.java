package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class E1StringColoringEasyVersion {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    String s = in.nextString();
    char[] chars = s.toCharArray();
    int[] a = new int[n];
    char last1 = 'a' - 1;
    char last2 = 'a' - 1;
    for (int i = 0; i < n; i++) {
      if (chars[i] >= last1) {
        last1 = chars[i];
      } else {
        if (chars[i] >= last2) {
          last2 = chars[i];
          a[i] = 1;
        } else {
          out.println("NO");
          return;
        }
      }
    }
    out.println("YES");
    for (int i = 0; i < n; i++) {
      out.print(a[i]);
    }
    out.println();


  }

  private boolean check(String s, int[] a, int i) {
    List<Character> list = new ArrayList<>();
    for (int j = 0; j < s.length(); j++) {
      if (a[j] == i) {
        list.add(s.charAt(j));
      }
    }
    for (int j = 1; j < list.size(); j++) {
      if (list.get(j) < list.get(j - 1)) {
        return false;
      }
    }
    return true;
  }
}
