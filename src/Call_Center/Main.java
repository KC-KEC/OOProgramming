package Call_Center;

import java.util.Random;

public class Main {
  public static void main(String[] args) {
    Random rand = new Random();

    CallHandler ch = CallHandler.getInstance();
    for (int i = 0; i < 10; i++) {
      Call call = new Call(i, rand.nextInt(2) + 1);
      ch.dispatchCall(call);
    }
  }
}
