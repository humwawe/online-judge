package leetcode.c325;

/**
 * @author hum
 */
public class C1 {

  public int closetTarget(String[] words, String target, int startIndex) {
    boolean f = true;
    for (String word : words) {
      if (word.equals(target)) {
        f = false;
        break;
      }
    }
    if (f) {
      return -1;
    }
    if (words[startIndex].equals(target)) {
      return 0;
    }
    int n = words.length;
    int cnt = 0;
    for (int i = startIndex + 1; i != startIndex; i = (i + 1) % n) {
      cnt++;
      if (words[i].equals(target)) {
        break;
      }
    }
    int cnt2 = 0;
    for (int i = (startIndex - 1 + n) % n; i != startIndex; i = (i - 1 + n) % n) {
      cnt2++;
      if (words[i].equals(target)) {
        break;
      }
    }
    return Math.min(cnt, cnt2);
  }
}
