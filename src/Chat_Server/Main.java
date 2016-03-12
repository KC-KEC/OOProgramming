package Chat_Server;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<User> users = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      users.add(new User(i, "user" + i));
    }
    User user0 = users.get(0);
    User user1 = users.get(1);
    user0.login();
    user1.login();
    user0.sendMessageToUser(user1, "hello!"); // user1 is not in the contact
    user0.sendAddRequest(user1);
    System.out.println(user1.getRequestQueue().size());//user1's request queue should be 1
    user1.processAddRequest();
    System.out.println(user1.getRequestQueue().size()); // now user1's request queue should be empty
    user0.sendMessageToUser(user1, "hello!");
    user1.sendMessageToUser(user0, "hi");
    user0.createGroupChat(users);
    user0.sendMessageToGroup(0, "hi everyone!");
    user1.sendMessageToGroup(0, "hi everybody!");
    System.out.println(user0.getGroupChats().get(0).getUsers());// all 10 users' names
    User user2 = users.get(2);
    user2.login();
    System.out.println(user2.getGroupChats().get(0).getHistory());// hi everyone and hi everybody

    user2.sendAddRequest(user0);
    user2.sendAddRequest(user1);
    System.out.println(user2.getContacts());// empty
    user0.processAddRequest();
    System.out.println(user2.getContacts());// user0
    System.out.println(user0.getContacts());// user1 and user2
    user1.processAddRequest();
    System.out.println(user2.getContacts());// user0 and user1
    user2.sendAddRequest(user1);
    user1.processAddRequest();
    System.out.println(user2.getContacts());// add same user to contact, nothing change

    user2.sendMessageToUser(user0, "hello there.");
    System.out.println(user0.getPrivateChat().size());// number of chat for user0, should be 2
    User user3 = users.get(3);
    user3.login();
    user3.sendAddRequest(user0);
    user0.processAddRequest();
    user3.sendMessageToUser(user0, "i'm user3");
    System.out.println(user0.getPrivateChat().size());// number of chat for user0, now is 3
    System.out.println(user3.getPrivateChat().size());// number of chat for user3, should be 1
  }
}
