package code.jam.o2021.one.a;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class HackedExam {
    int n, q;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        q = in.nextInt();
        out.printf("Case #%d: ", testNumber);
        if (n == 1) {
            String s = in.nextString();
            int num = in.nextInt();
            if (num > q / 2) {
                out.print(s + " ");
                out.println(num + "/" + "1");
            } else {
                s = helper(s);
                out.print(s + " ");
                out.println((q - num) + "/" + "1");
            }
        } else if (n == 2) {
            String[] s = new String[4];
            int[] nums = new int[4];
            s[0] = in.nextString();
            nums[0] = in.nextInt();
            s[1] = helper(s[0]);
            nums[1] = q - nums[0];
            s[2] = in.nextString();
            nums[2] = in.nextInt();
            s[3] = helper(s[2]);
            nums[3] = q - nums[2];
            int max = 0;
            for (int i = 0; i < 4; i++) {
                max = Math.max(max, nums[i]);
            }
            for (int i = 0; i < 4; i++) {
                if (nums[i] == max) {
                    out.print(s[i] + " ");
                    out.println(nums[i] + "/" + "1");
                    break;
                }
            }
        } else {
            return;
        }
    }

    private String helper(String s) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'F') {
                res.append("T");
            } else {
                res.append("F");
            }
        }
        return res.toString();
    }
}
