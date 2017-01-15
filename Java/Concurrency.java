// Started with Threads and then used Runnables.
// Comments are lines removed in the switchover.

class Concurrency {
  
  public static void main(String[] args) {
    TestThread one = new TestThread(1);
    TestThread two = new TestThread(2);
    //one.start();
    //two.start();
    
    System.out.println("Threads created. Main ending now...");
  }
}
  
class TestThread /*extends Thread*/ implements Runnable {
  final int number;
  
  TestThread(int number) {
    this.number = number;
    // these lines were added for Runnable
    Thread newThread = new Thread(this);
    newThread.start();
  }
  
  public void run() {
    for (int i = 1; i <= 20; i++) {
      System.out.println("Thread " + number + " counting..." + i);
      try {
        Thread.currentThread().sleep(500 * number);
      }
      catch (InterruptedException ie) {
        // Not likely to occur - JIC
        System.out.println("Error: " + ie);
      }
    }
    System.out.println("Thread " + number + " is finished counting.");
  }
  
}
