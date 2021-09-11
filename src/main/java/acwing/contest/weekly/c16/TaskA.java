package acwing.contest.weekly.c16;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        String s = in.nextString();
        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                cnt1++;
            } else {
                cnt2++;
            }
        }
        if (cnt2 >= cnt1) {
            out.println(s.toLowerCase());
        } else {
            out.println(s.toUpperCase());
        }
    }
}
