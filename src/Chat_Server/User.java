package Chat_Server;

import java.util.*;

public class User {
  private final int id;
  private String nickName;
  private UserStatusType status;
  private Map<Integer, PrivateChat> privateChats;
  private List<GroupChat> groupChats;
  private Queue<AddRequest> receivedAddRequests;
  private Set<AddRequest> unProcessedRequest;
  private Set<User> contacts;


  public User(int id, String nickName) {
    this.id = id;
    this.nickName = nickName;

    this.status = UserStatusType.Offline;
    this.privateChats = new HashMap<Integer, PrivateChat>();
    this.groupChats = new LinkedList<GroupChat>();
    this.receivedAddRequests = new LinkedList<>();
    this.unProcessedRequest = new HashSet<>();
    this.contacts = new HashSet<>();
  }

  /* Send a message to other user */
  public boolean sendMessageToUser(User toUser, String content) {
    if (this.status != UserStatusType.Available) {
      System.out.println("User " + this.id + " is not available.");
      return false;
    }
    if (toUser == null || content == null) {
      return false;
    }
    if (!this.contacts.contains(toUser)) {
      System.out.println(toUser + " is not in the contact");
      return false;
    }
    PrivateChat chat = this.privateChats.get(toUser.id);
    if (chat == null) {
      UserManager.getInstance().createPrivateChat(this, toUser);
      chat = privateChats.get(toUser.getId());
    }
    Message message = new Message(content);
    System.out.println(this + " sends to " + toUser + ": \n" + message);
    return chat.addMessage(message);
  }

  /* Send a message to the group */
  public boolean sendMessageToGroup(int groupId, String content) {
    if (this.status != UserStatusType.Available) {
      System.out.println("User " + this.id + " is not available.");
      return false;
    }
    if (groupId < 0 || groupId >= this.groupChats.size()) {
      System.out.println("Group " + groupId + " does not exist.");
      return false;
    }
    GroupChat chat = groupChats.get(groupId);
    Message message = new Message(content);
    System.out.println(this + " sends to group " + groupId + ": \n" + message);
    return chat.addMessage(message);
  }

  /* Add, remove, search contact */
  public boolean addToContact(User user) {
    return user != null && this.contacts.add(user);
  }

  public boolean removeFromContact(User user) {
    return user != null && this.contacts.remove(user);
  }

  public boolean searchContact(User user) {
    return this.contacts.contains(user);
  }

  /* Called from the request sender */
  public void receiveAddRequest(AddRequest addReq) {
    if (addReq != null && !unProcessedRequest.contains(addReq)) {
      this.receivedAddRequests.offer(addReq);
      this.unProcessedRequest.add(addReq);
    }
  }

  /* Create a add request and call the receiver's receiveAddRequest() method */
  public void sendAddRequest(User toUser) {
    if (toUser != null && !contacts.contains(toUser)) {
      AddRequest addReq = new AddRequest(this, toUser);
      toUser.receiveAddRequest(addReq);
    }
  }

  /* Add all senders of the add request in the request queue to the contact list */
  public void processAddRequest() {
    while (!this.receivedAddRequests.isEmpty()) {
      AddRequest req = this.receivedAddRequests.poll();
      unProcessedRequest.remove(req);
      UserManager.getInstance().approve(req);
    }
  }

  /* Create a conversation with another user */
  public void createPrivateChat(User user) {
    if (user != null) {
      UserManager.getInstance().createPrivateChat(this, user);
    }
  }

  public void addPrivateChat(PrivateChat chat) {
    if (chat != null) {
      if (chat.getUsers().get(0) == this) {
        this.privateChats.put(chat.getUsers().get(1).getId(), chat);
      }
      else {
        this.privateChats.put(chat.getUsers().get(0).getId(), chat);
      }
    }
  }

  /* Create a group conversation */
  public void createGroupChat(List<User> participants) {
    if (participants != null && !participants.isEmpty()) {
      UserManager.getInstance().createGroup(participants);
    }
  }

  public void addGroupChat(GroupChat chat) {
    if (chat != null) {
      groupChats.add(chat);
    }
  }

  public void login() {
    this.status = UserStatusType.Available;
  }

  public void logoff() {
    this.status = UserStatusType.Offline;
  }

  /* Getter and Setter */
  public int getId() {
    return this.id;
  }

  public String getName() {
    return this.nickName;
  }

  public void setName(String newName) {
    this.nickName = newName;
  }

  public UserStatusType getStatus() {
    return this.status;
  }

  public void setStatus(UserStatusType status) {
    this.status = status;
  }

  public Set<User> getContacts() {
    return this.contacts;
  }

  public Queue<AddRequest> getRequestQueue() {
    return this.receivedAddRequests;
  }

  public Set<AddRequest> getUnProcessedRequest() {
    return this.unProcessedRequest;
  }

  public List<GroupChat> getGroupChats() {
    return this.groupChats;
  }

  public Map<Integer, PrivateChat> getPrivateChat() {
    return this.privateChats;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null) {
      return false;
    }
    if (o == this) {
      return true;
    }
    if (!(o instanceof User)) {
      return false;
    }
    User user = (User) o;
    return user.getId() == this.id && user.getName().equals(this.nickName);
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + this.id;
    if (this.nickName != null) result = 31 * result + this.nickName.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return this.nickName;
  }
}
