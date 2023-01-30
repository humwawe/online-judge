package leetcode.c329;

/**
 * @author hum
 */
public class C3 {
  public boolean makeStringsEqual(String s, String target) {
    int cs0 = 0;
    int cs1 = 0;
    for (char c : s.toCharArray()) {
      if (c == '0') {
        cs0++;
      } else {
        cs1++;
      }
    }
    int ct0 = 0;
    int ct1 = 0;
    for (char c : target.toCharArray()) {
      if (c == '0') {
        ct0++;
      } else {
        ct1++;
      }
    }
    if (cs1 > 0 && ct1 == 0) {
      return false;
    }
    if (cs1 == 0 && ct1 > 0) {
      return false;
    }

    return true;
  }
}
