package Call_Center;

import java.util.Random;

public abstract class Employee {
  private final int id;
  protected int level;
  private Call currCall;

  public Employee(int id) {
    this.id = id;
  }

  public void receiveCall(Call call) {
    this.currCall = call;
    handleCall();
  }

  public void completeCall() {
    if (currCall == null) {
      return;
    }
    currCall.disconnect();
    currCall = null;

    assignNewCall();
  }

  public void escalateCall() {
    if (currCall != null) {
      System.out.println(this + " is escalating call");
      currCall.incrementLevel();
      CallHandler.getInstance().dispatchCall(currCall);
      currCall = null;
    }
    assignNewCall();
  }

  public void handleCall() {
    System.out.println(this + " is handling " + this.currCall);
    if (canHandle()) {
      Thread t = new Thread(new Runnable() {
        public void run() {
          try {
            Thread.sleep(5000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          } finally {
            completeCall();
          }
        }
      });
      t.start();
    }
    else {
      escalateCall();
    }
  }

  public boolean isFree() {
    return this.currCall == null;
  }

  public int getLevel() {
    return this.level;
  }

  public int getId() {
    return this.id;
  }

  public void assignNewCall() {
    CallHandler.getInstance().assignCall(this);
  }

  public boolean canHandle() {
    if (this.level == 3) {
      return true;
    }
    Random rand = new Random();
    return rand.nextBoolean();
  }
}
