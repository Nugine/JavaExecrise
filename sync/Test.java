package sync;

import java.util.concurrent.ArrayBlockingQueue;

public class Test {
    public static void main(String[] args) {
        class Token {
        }

        ArrayBlockingQueue<Integer> q1 = new ArrayBlockingQueue<Integer>(2);
        ArrayBlockingQueue<Character> q2 = new ArrayBlockingQueue<Character>(1);
        ArrayBlockingQueue<Token> ans = new ArrayBlockingQueue<Token>(1);

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 52; ++i) {
                    try {
                        int t = q1.take();
                        System.out.print(t);
                        ans.put(new Token());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 26; ++i) {
                    try {
                        char c = q2.take();
                        System.out.print(c);
                        ans.put(new Token());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    }
                }
            }
        });

        t1.start();
        t2.start();

        try {
            for (int i = 0; i < 52 + 26; ++i) {
                if (i % 3 == 2) {
                    q2.put((char) ('A' + i / 3));
                } else {
                    q1.put((int) (i / 3 * 2 + 1 + i % 3));
                }
                ans.take();
            }
            t1.join();
            t2.join();
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return;
        }

    }
}