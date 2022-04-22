package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BZgukistringZ {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String a = in.nextString();
    String b = in.nextString();
    String c = in.nextString();
    int[] cnt1 = new int[26];
    int[] cnt2 = new int[26];
    int[] cnt3 = new int[26];
    for (char c1 : a.toCharArray()) {
      cnt1[c1 - 'a']++;
    }
    for (char c1 : b.toCharArray()) {
      cnt2[c1 - 'a']++;
    }
    for (char c1 : c.toCharArray()) {
      cnt3[c1 - 'a']++;
    }
    int min1 = (int) 1e8;
    for (int i = 0; i < 26; i++) {
      if (cnt2[i] != 0) {
        min1 = Math.min(min1, cnt1[i] / cnt2[i]);
      }
    }

    int min2 = (int) 1e8;
    for (int i = 0; i < 26; i++) {
      if (cnt3[i] != 0) {
        min2 = Math.min(min2, cnt1[i] / cnt3[i]);
      }
    }
    if (min1 < 0 && min2 < 0) {
      out.println(a);
      return;
    }
    StringBuilder stringBuilder = new StringBuilder();
    if (min1 < 0) {
      stringBuilder.append(c.repeat(min2));
      for (int i = 0; i < 26; i++) {
        int last = cnt1[i] - cnt3[i] * min2;
        stringBuilder.append(("" + (char) ('a' + i)).repeat(last));
      }
      out.println(stringBuilder.toString());
      return;
    }

    if (min2 < 0) {
      stringBuilder.append(c.repeat(min1));
      for (int i = 0; i < 26; i++) {
        int last = cnt1[i] - cnt2[i] * min1;
        stringBuilder.append(("" + (char) ('a' + i)).repeat(last));
      }
      out.println(stringBuilder.toString());
      return;
    }

    int max = 0;
    int res1 = -1;
    int res2 = -1;
    for (int i = 0; i <= min1; i++) {
      int[] tmp = new int[26];
      for (int j = 0; j < 26; j++) {
        tmp[j] = cnt1[j] - cnt2[j] * i;
      }

      int min = (int) 1e8;
      for (int j = 0; j < 26; j++) {
        if (cnt3[j] != 0) {
          min = Math.min(min, tmp[j] / cnt3[j]);
        }
      }

      if (i + min >= max) {
        max = i + min;
        res1 = i;
        res2 = min;
      }
    }


    stringBuilder.append(b.repeat(res1)).append(c.repeat(res2));
    for (int i = 0; i < 26; i++) {
      int last = cnt1[i] - cnt2[i] * res1 - cnt3[i] * res2;
      stringBuilder.append(("" + (char) ('a' + i)).repeat(last));
    }
    out.println(stringBuilder.toString());
  }
}
