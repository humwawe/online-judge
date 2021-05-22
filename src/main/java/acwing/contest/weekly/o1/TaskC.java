package acwing.contest.weekly.o1;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskC {
    int n;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        // s1表示形如111的最大长度
        // s2表示形如111222的最大长度
        // s3表示形如111222111的最大长度
        // s4表示形如11122111222的最大长度
        int s1 = 0, s2 = 0, s3 = 0, s4 = 0;
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            if (x == 1) {
                s1 = s1 + 1;
                s3 = Math.max(s2 + 1, s3 + 1);
            } else {
                s2 = Math.max(s1 + 1, s2 + 1);
                s4 = Math.max(s3 + 1, s4 + 1);
            }
        }
        out.println(Math.max(s3, s4));
    }
}
