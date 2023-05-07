package leetcode.c344;

/**
 * @author hum
 */
public class C2 {
  int N = (int) (1e5 + 5);
  int[] cnt = new int[N];
  int[] fre = new int[N];

  public C2() {

  }

  public void add(int number) {
    cnt[number]++;
    fre[cnt[number] - 1]--;
    fre[cnt[number]]++;
  }

  public void deleteOne(int number) {
    if (cnt[number] > 0) {
      cnt[number]--;
      fre[cnt[number] + 1]--;
      fre[cnt[number]]++;
    }
  }

  public boolean hasFrequency(int frequency) {
    return fre[frequency] > 0;
  }
}
