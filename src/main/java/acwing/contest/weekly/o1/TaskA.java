package acwing.contest.weekly.o1;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        while (true) {
            if (check(n)) {
                out.println(n);
                break;
            }
            n++;
        }
    }

    private boolean check(int n) {
        int tmp = 0;
        while (n > 0) {
            tmp += n % 10;
            n /= 10;
        }
        return tmp % 4 == 0;
    }
}
