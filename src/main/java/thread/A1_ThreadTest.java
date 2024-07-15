package thread;

public class A1_ThreadTest {
    EggVoice eggVoice;

    public static void main(String[] args) throws InterruptedException {
        new A1_ThreadTest().go();
    }

    private void go() {
        eggVoice = new EggVoice();
        ChickenVoice chickenVoice = new ChickenVoice();
        System.out.println("Спор начат...");
        eggVoice.start();
        chickenVoice.start();
        try {
            eggVoice.join(1000);
            chickenVoice.join();
            System.out.println("Спор закончен!");
        } catch (InterruptedException ex) {}
    }

    class EggVoice extends Thread
    {
        @Override
        public void run()
        {
            for(int i = 0; i < 5; i++)
            {
                try{
                    sleep(1000);		//Приостанавливает поток на 1 секунду
                }catch(InterruptedException e){}

                System.out.println("яйцо!");
            }
            //Слово «яйцо» сказано 5 раз
        }
    }

    class ChickenVoice extends Thread
    {
        @Override
        public void run()
        {
            for(int i = 0; i < 5; i++)
            {
                try{
                    sleep(1000);		//Приостанавливает поток на 1 секунду
                }catch(InterruptedException e){}

                System.out.println("курица!");
            }
            //Слово «курица» сказано 5 раз

            if (eggVoice.isAlive()) {
                try {
                    eggVoice.join(); // Подождать пока оппонент закончит высказываться
                } catch (InterruptedException e) {}
                System.out.println("Первым появилось яйцо!");
            } else {
                System.out.println("Первым появилась курица!");
            }
        }
    }
}
