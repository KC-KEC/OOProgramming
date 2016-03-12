package InMemory_File_System;

public class File extends Entry {

  private String content;

  public File(String name, Directory parent) {
    super(name, parent);
  }

  public int size() {
    return this.content.length();
  }

  public boolean isDir() {
    return false;
  }

  public String getContent() {
    this.setLastAccessedTime(System.nanoTime());
    return this.content;
  }

  public void addContent(String newContent) {
    if (this.content == null) {
      this.content = newContent;
    }
    else {
      this.content += newContent;
    }
    this.setLastAccessedTime(System.nanoTime());
    this.setLastUpdatedTime(System.nanoTime());
  }

  public void deleteContent() {
    this.content = "";
    this.setLastAccessedTime(System.nanoTime());
    this.setLastUpdatedTime(System.nanoTime());
  }

  public boolean find(String key) {
    return this.content.contains(key);
  }

  public void replace(String oldStr, String newStr) {
    this.content.replace(oldStr, newStr);
  }

  @Override
  public boolean equals(Object o) {
    if (o == null) {
      return false;
    }
    if (o == this) {
      return true;
    }
    if (!(o instanceof File)) {
      return false;
    }

    File f = (File) o;
    return f.getName().equals(this.getName()) && f.getContent().equals(this.content);
  }

  @Override
  public int hashCode() {
    int result = 17;
    if (this.getName() != null) result = 31 * result + this.getName().hashCode();
    if (this.getContent() != null) result = 31 * result + this.getContent().hashCode();
    return result;
  }

  @Override
  public String toString() {
    return "File: " + this.getName();
  }
}
