package leetcode.c327;

/**
 * @author hum
 */
public class C3 {
  public boolean isItPossible(String word1, String word2) {
    int[] cnt1 = new int[26];
    for (char c : word1.toCharArray()) {
      cnt1[c - 'a']++;
    }
    int[] cnt2 = new int[26];
    for (char c : word2.toCharArray()) {
      cnt2[c - 'a']++;
    }

    for (int i = 0; i < 26; i++) {
      if (cnt1[i] > 0) {
        for (int j = 0; j < 26; j++) {
          if (cnt2[j] > 0) {
            if (check(cnt1, cnt2, i, j)) {
              return true;
            }
          }
        }
      }
    }
    return false;

  }

  private boolean check(int[] cnt1, int[] cnt2, int i, int j) {
    int c1 = 0;
    int c2 = 0;
    for (int k = 0; k < 26; k++) {
      int t1 = 0;
      int t2 = 0;
      if (k == i) {
        t1--;
        t2++;
      }
      if (k == j) {
        t1++;
        t2--;
      }
      if (cnt1[k] + t1 > 0) {
        c1++;
      }
      if (cnt2[k] + t2 > 0) {
        c2++;
      }
    }
    return c1 == c2;
  }
}
