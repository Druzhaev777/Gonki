public class Main {

    public static void main(String[] args) {

        RaceThread thread1 = (new RaceThread("Кролик", 10));

        RaceThread thread2 = (new RaceThread("Пичехала", 1));

        thread1.start();

        thread2.start();
    }
}
class RaceThread extends Thread {
    int priority;
    String Name;
    final int distance = 11;

    public RaceThread(String Name, int priority) {

        this.Name = Name;

        this.priority = priority;
    }

    @Override
    public void run() {

        Thread.currentThread().setPriority(priority);

        Thread.currentThread().setName(Name);

        int timeToStep = 1000 / (Thread.currentThread().getPriority());


        for (int i = 0; i < distance; i++) {

            try {
                Thread.sleep(timeToStep);

                System.out.println(getName() + (" - ") + (i * 100) + " м ");

            } catch (InterruptedException e) {

                e.printStackTrace();
            }

            {

                if (Thread.currentThread().getPriority() == 1) {
                    Thread.currentThread().setPriority(10);
                } else {
                    Thread.currentThread().setPriority(1);
                }
                timeToStep = 1000 / (Thread.currentThread().getPriority());
            }

        }

    }
}
