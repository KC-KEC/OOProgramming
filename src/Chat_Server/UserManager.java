package Chat_Server;

import java.util.List;

/**
 * Singleton Class
 * <p>
 * Created by Kyle on 1/15/16.
 */
public class UserManager {
  private static UserManager instance;

  private UserManager() {
  }

  public static UserManager getInstance() {
    if (instance == null) {
      instance = new UserManager();
    }
    return instance;
  }

  public void approve(AddRequest req) {
    if (req != null) {
      User user1 = req.getFromUser();
      User user2 = req.getToUser();
      user1.addToContact(user2);
      user2.addToContact(user1);
    }
  }

  public void createGroup(List<User> participants) {
    GroupChat chat = new GroupChat(String.valueOf(participants.size()), participants);
    for (User user : participants) {
      user.addGroupChat(chat);
    }
  }

  public void createPrivateChat(User user1, User user2) {
    if (user1 != null && user2 != null) {
      PrivateChat chat = new PrivateChat(user1 + " + " + user2, user1, user2);
      user1.addPrivateChat(chat);
      user2.addPrivateChat(chat);
    }
  }
}
