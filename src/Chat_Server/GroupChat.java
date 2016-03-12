package Chat_Server;

import java.util.List;

public class GroupChat extends Conversation {

  public GroupChat(String id, List<User> participants) {
    super(id);
    this.users.addAll(participants);
  }

  public void addParticipant(User user) {
    if (user != null) {
      this.users.add(user);
    }
  }

  public void removeParticipant(User user) {
    if (user != null) {
      this.users.remove(user);
    }
  }
}
