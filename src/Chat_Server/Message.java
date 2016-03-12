package Chat_Server;

import java.util.Date;

public class Message {
  private final String content;
  private final Date date;

  public Message(String content) {
    this.content = content;
    this.date = new Date();
  }

  public String getContent() {
    return this.content;
  }

  public Date getDate() {
    return this.date;
  }

  @Override
  public String toString() {
    return this.content + " : " + this.date;
  }
}
