package thread;

import java.util.concurrent.atomic.AtomicInteger;

public class A2_Incremenator {
    private final AtomicInteger value = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        new A2_Incremenator().go();
    }

    private void go() throws InterruptedException {
        Incremenator incremenator = new Incremenator();
        System.out.println("Значение = ");
        incremenator.start();

        for (int i = 1; i <= 3; i++) {
            Thread.sleep(i * 2 * 1000);
            incremenator.changeAction();
        }
        incremenator.interrupt();
    }

    class Incremenator extends Thread {
        private volatile boolean isIncrement = true;

        public void changeAction() {
            isIncrement = !isIncrement; // not atomic operation!!! Use AtomicBoolean
        }

        @Override
        public void run() {
            while (true) {
                if (Thread.interrupted()) {
                    return;
                }
                if (isIncrement) {
                    value.incrementAndGet();
                } else {
                    value.decrementAndGet();
                }
                System.out.print(value.get() + " ");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }
}
