package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class BInteractiveBullsAndCowsEasy {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int[] tmp = new int[4];
    int idx = 0;
    for (int i = 0; i <= 9; i++) {
      out.println(("" + i).repeat(4));
      out.flush();
      int a = in.nextInt();
      int b = in.nextInt();
      for (int j = 0; j < a; j++) {
        tmp[idx++] = i;
      }
    }
    Arrays.sort(tmp);
    do {
      for (int i = 0; i < 4; i++) {
        out.print(tmp[i]);
      }
      out.println();
      out.flush();
      int a = in.nextInt();
      int b = in.nextInt();
      if (a == 4 && b == 0) {
        return;
      }
    } while (nextPermutation(tmp));
  }

  public boolean nextPermutation(int[] s) {
    int n = s.length;
    for (int i = n - 2; i >= 0; i--) {
      if (s[i] < s[i + 1]) {
        reverse(s, i + 1, n - 1);
        // 一直到最大的一个序列
        for (int j = i + 1; ; j++) {
          if (s[j] > s[i]) {
            int tmp = s[j];
            s[j] = s[i];
            s[i] = tmp;
            return true;
          }
        }
      }
    }
    return false;
  }

  public void reverse(int[] data, int l, int r) {
    while (l < r) {
      int tmp = data[l];
      data[l] = data[r];
      data[r] = tmp;
      l++;
      r--;
    }
  }
}
