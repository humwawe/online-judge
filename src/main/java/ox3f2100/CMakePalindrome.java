package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class CMakePalindrome {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    int[] cnt = new int[26];
    for (char c : s.toCharArray()) {
      cnt[c - 'a']++;
    }

    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < 26; i++) {
      if (cnt[i] % 2 != 0) {
        list.add(i);
      }
    }
    for (int i = 0; i < list.size() / 2; i++) {
      cnt[list.get(list.size() - i - 1)]--;
      cnt[list.get(i)]++;
    }

    StringBuilder sb1 = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();

    for (int i = 0; i < 26; i++) {
      if (cnt[i] > 0) {
        for (int j = 0; j < cnt[i] / 2; j++) {
          sb1.append((char) ('a' + i));
          sb2.append((char) ('a' + i));
        }
      }
    }

    for (int i = 0; i < 26; i++) {
      if (cnt[i] % 2 == 1) {
        sb1.append((char) ('a' + i));
      }
    }
    out.println(sb1.append(sb2.reverse()));
  }
}
