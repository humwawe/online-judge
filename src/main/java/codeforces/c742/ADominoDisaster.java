package codeforces.c742;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class ADominoDisaster {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            char c = in.nextCharacter();
            if (c == 'U') {
                out.print('D');
            } else if (c == 'D') {
                out.print('U');
            }else {
                out.print(c);
            }
        }
        out.println();
    }
}
