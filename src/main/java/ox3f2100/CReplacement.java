package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CReplacement {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        String s = in.nextString();
        boolean[] p = new boolean[n + 2];
        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '.') {
                int j = i;
                while (j + 1 < n && s.charAt(j + 1) == '.') {
                    j++;
                }
                // [i,j]
                sum += j - i + 1;
                for (int k = i; k <= j; k++) {
                    p[k + 1] = true;
                }
                cnt++;
                i = j;
            }
        }

        for (int i = 0; i < m; i++) {
            int idx = in.nextInt();
            boolean f = in.nextCharacter() == '.';
            if (p[idx] != f) {
                if (f) {
                    sum++;
                } else {
                    sum--;
                }

                if (f && p[idx - 1] && p[idx + 1]) {
                    cnt--;
                }
                if (!f && p[idx - 1] && p[idx + 1]) {
                    cnt++;
                }
                if (f && !p[idx - 1] && !p[idx + 1]) {
                    cnt++;
                }
                if (!f && !p[idx - 1] && !p[idx + 1]) {
                    cnt--;
                }

            }
            p[idx] = f;
            out.println(sum - cnt);
        }

    }
}
