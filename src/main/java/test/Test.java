package test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author hum
 */
public class Test {
  public static void main(String[] args) {
    for (int testCase = 0; testCase < 100000; testCase++) {
      Test test = new Test();
      int n = 10;
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = new Random().nextInt(4);
      }
      int xxx = test.xxx(a, n);
      int yyy = test.yyy(a, n);
      if (xxx != yyy) {
        System.out.println(Arrays.toString(a));
        System.out.println(xxx);
        System.out.println(yyy);
        return;
      }
    }
  }

  public int xxx(int[] a, int n) {
    return 0;
  }


  public int yyy(int[] a, int n) {
    return 0;
  }


}
