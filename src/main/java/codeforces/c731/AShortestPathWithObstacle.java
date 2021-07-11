package codeforces.c731;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AShortestPathWithObstacle {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int a1 = in.nextInt();
        int a2 = in.nextInt();
        int b1 = in.nextInt();
        int b2 = in.nextInt();
        int f1 = in.nextInt();
        int f2 = in.nextInt();
        boolean f = false;
        if (a1 == b1 && b1 == f1) {
            if ((a2 > f2 && b2 < f2) || (a2 < f2 && b2 > f2)) {
                f = true;
            }
        }
        if (a2 == b2 && b2 == f2) {
            if ((a1 > f1 && b1 < f1) || (a1 < f1 && b1 > f1)) {
                f = true;
            }
        }
        if (f) {
            out.println(Math.abs(a1 - b1) + Math.abs(a2 - b2) + 2);
        } else {
            out.println(Math.abs(a1 - b1) + Math.abs(a2 - b2));
        }
    }
}
