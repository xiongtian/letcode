package m12;

/**
 * @Author xiongtian
 * @Date 2020/12/23 9:31
 * @Version 1.0
 *
 * 生产者消费者
 */

public class ConsumerAndProducer {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Consumer consumer = new Consumer(clerk);
        Producer producer = new Producer(clerk);
        Thread thread1 = new Thread(consumer);
        Thread thread2 = new Thread(producer);
        thread1.start();
        thread2.start();
    }
}

class Clerk {

    private int product = 0;

    /**
     * 生产商品
     */
    public synchronized void get() {
        while (product >= 2) {
            System.out.println("商品已满！");
            try { this.wait(); } catch (InterruptedException e) { e.printStackTrace(); }
        }
        System.out.println("商品的数量："+ ++product);
        this.notifyAll();
    }
    /**
     * 消费商品
     */
    public synchronized  void sale(){
        while (product <= 0) {
            System.out.println("商品已售光！");
            try { this.wait(); } catch (InterruptedException e) { e.printStackTrace(); }
        }
        System.out.println("商品的数量："+ --product);
        this.notifyAll();
    }
}

class Consumer implements Runnable {

    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i <20; i++) {
            clerk.sale();
        }
    }
}
class Producer implements Runnable {

    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i <20; i++) {
            clerk.get();
        }
    }
}