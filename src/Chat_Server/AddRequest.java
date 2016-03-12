package Chat_Server;

public class AddRequest {
  private final User fromUser;
  private final User toUser;

  public AddRequest(User fromUser, User toUser) {
    this.fromUser = fromUser;
    this.toUser = toUser;
  }

  public User getFromUser() {
    return this.fromUser;
  }

  public User getToUser() {
    return this.toUser;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null) {
      return false;
    }
    if (o == this) {
      return true;
    }
    if (!(o instanceof AddRequest)) {
      return false;
    }
    AddRequest req = (AddRequest) o;
    return req.getFromUser() == this.fromUser && req.getToUser() == this.toUser;
  }

  @Override
  public int hashCode() {
    int result = 17;
    if (this.fromUser != null) result = result * 31 + fromUser.hashCode();
    if (this.toUser != null) result = result * 31 + toUser.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return this.fromUser + " sending an add request to " + this.toUser;
  }
}
