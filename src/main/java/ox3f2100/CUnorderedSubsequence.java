package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CUnorderedSubsequence {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    if (n <= 2) {
      out.println(0);
      return;
    }

    int[] preMin = new int[n];
    int[] sufMin = new int[n];
    preMin[0] = 0;
    for (int i = 1; i < n; i++) {
      preMin[i] = preMin[i - 1];
      if (a[i] < a[preMin[i - 1]]) {
        preMin[i] = i;
      }
    }
    sufMin[n - 1] = n - 1;
    for (int i = n - 2; i >= 0; i--) {
      sufMin[i] = sufMin[i + 1];
      if (a[i] < a[sufMin[i + 1]]) {
        sufMin[i] = i;
      }
    }
    for (int i = 1; i <= n - 2; i++) {
      if (a[i] > a[preMin[i - 1]] && a[i] > a[sufMin[i + 1]]) {
        out.println(3);
        out.println(preMin[i - 1] + 1, i + 1, sufMin[i + 1] + 1);
        return;
      }
    }

    int[] preMax = new int[n];
    int[] sufMax = new int[n];
    preMax[0] = 0;
    for (int i = 1; i < n; i++) {
      preMax[i] = preMax[i - 1];
      if (a[i] > a[preMax[i - 1]]) {
        preMax[i] = i;
      }
    }
    sufMax[n - 1] = n - 1;
    for (int i = n - 2; i >= 0; i--) {
      sufMax[i] = sufMax[i + 1];
      if (a[i] > a[sufMax[i + 1]]) {
        sufMax[i] = i;
      }
    }
    for (int i = 1; i <= n - 2; i++) {
      if (a[i] < a[preMax[i - 1]] && a[i] < a[sufMax[i + 1]]) {
        out.println(3);
        out.println(preMax[i - 1] + 1, i + 1, sufMax[i + 1] + 1);
        return;
      }
    }

    out.println(0);
  }
}
