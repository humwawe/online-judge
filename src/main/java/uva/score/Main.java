package uva.score;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author hum
 */
public class Main {
    private static final boolean DEBUG = false;
    private static Scanner sc;

    private static void init() {
        try {
            if (DEBUG) {
                sc = new Scanner(new FileInputStream("C:\\Users\\hum\\IdeaProjects\\online-judge\\src\\main\\java\\template\\in.txt"));
            } else {
                sc = new Scanner(new BufferedInputStream(System.in));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        init();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            int sum = 0;
            int count = 1;
            for (char c : s.toCharArray()) {
                if (c == 'O') {
                    sum += count;
                    count++;
                } else {
                    count = 1;
                }
            }
            System.out.println(sum);
        }
    }
}

