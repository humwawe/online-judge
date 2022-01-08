package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BModerateModularMode {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int x = in.nextInt();
        int y = in.nextInt();
        if (x <= y) {
            out.println(y - y % x / 2);
        } else {
            out.println(x + y);
        }
    }
}
