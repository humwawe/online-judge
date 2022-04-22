package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CDevuAndPartitioningOfTheArray {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    int p = in.nextInt();
    int q = k - p;
    int[] ee = new int[n];
    int[] oo = new int[n];
    int ne = 0, no = 0;
    for (int i = 0; i < n; i++) {
      int a = in.nextInt();
      if (a % 2 == 0) {
        ee[ne++] = a;
      } else {
        oo[no++] = a;
      }
    }
    if (no % 2 != q % 2 || no < q || ne + (no - q) / 2 < p) {
      out.println("NO");
      return;
    }
    out.println("YES");
    if (ne < p) {
      for (int i = 0; i < ne; i++) {
        out.println("1 " + ee[i]);
      }
      for (int i = 0; i < p - 1 - ne; i++) {
        out.println("2 " + oo[q + i * 2] + " " + oo[q + i * 2 + 1]);
      }
      out.print(no - q - (p - 1 - ne) * 2);
      for (int i = q + (p - 1 - ne) * 2; i < no; i++) {
        out.print(" " + oo[i]);
      }
      out.println();
      for (int i = 0; i < q; i++) {
        out.println("1 " + oo[i]);
      }
    } else if (p > 0) {
      for (int i = 0; i < p - 1; i++) {
        out.println("1 " + ee[i]);
      }
      for (int i = 0; i < q; i++) {
        out.println("1 " + oo[i]);
      }
      out.print(ne - p + 1 + no - q);
      for (int i = p - 1; i < ne; i++) {
        out.print(" " + ee[i]);
      }
      for (int i = q; i < no; i++) {
        out.print(" " + oo[i]);
      }
      out.println();
    } else {
      for (int i = 0; i < q - 1; i++) {
        out.println("1 " + oo[i]);
      }
      out.print(no - q + 1 + ne);
      for (int i = q - 1; i < no; i++) {
        out.print(" " + oo[i]);
      }
      for (int i = 0; i < ne; i++) {
        out.print(" " + ee[i]);
      }
      out.println();
    }
  }

}
