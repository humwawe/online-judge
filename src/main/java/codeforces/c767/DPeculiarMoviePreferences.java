package codeforces.c767;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashSet;
import java.util.Set;

public class DPeculiarMoviePreferences {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    String[] a = new String[n];
    Set<String> set2 = new HashSet<>();
    Set<String> set3 = new HashSet<>();
    Set<String> set32 = new HashSet<>();
    boolean res = false;
    for (int i = 0; i < n; i++) {
      a[i] = in.nextString();
      if (a[i].length() == 1) {
        res = true;
      } else if (a[i].length() == 2) {
        set2.add(a[i]);
        if (a[i].charAt(0) == a[i].charAt(1)) {
          res = true;
        }
        String reverse = String.valueOf(a[i].charAt(1)) + a[i].charAt(0);
        if (set2.contains(reverse) || set32.contains(reverse)) {
          res = true;
        }
      } else {
        set3.add(a[i]);
        if (a[i].charAt(0) == a[i].charAt(2)) {
          res = true;
        }
        String reverse = String.valueOf(a[i].charAt(2)) + a[i].charAt(1) + a[i].charAt(0);
        if (set3.contains(reverse)) {
          res = true;
        }
        reverse = String.valueOf(a[i].charAt(2)) + a[i].charAt(1);
        if (set2.contains(reverse)) {
          res = true;
        }
        set32.add(a[i].substring(0, 2));
      }
    }

    if (res) {
      out.println("YES");
    } else {
      out.println("NO");
    }
  }
}

