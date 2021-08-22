package best.coder.o2021.two;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class Task1001 {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        if (n == 1) {
            out.println("No!");
            return;
        }
        if (n == 2) {
            if (k == 1) {
                out.println("Yes!");
            } else {
                out.println("No!");
            }
            return;
        }
        if (n == k) {
            out.println("Yes!");
            return;
        }
        if (k % 2 == 1) {
            out.println("Yes!");
        } else {
            out.println("No!");
        }

    }
}
