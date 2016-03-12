package InMemory_File_System;

public abstract class Entry {
  private final long createdTime;
  private Directory parent;
  private long lastUpdatedTime;
  private long lastAccessedTime;
  private String name;

  public Entry(String name, Directory parent) {
    this.name = name;
    this.parent = parent;
    this.createdTime = System.nanoTime();
    this.lastAccessedTime = System.nanoTime();
    this.lastUpdatedTime = System.nanoTime();
  }

  public abstract int size();

  public abstract boolean isDir();

  public void delete() {
    if (parent != null) {
      parent.delete(this);
    }
  }

  public String getFullPath() {
    if (parent == null) {
      return "";
    }
    return this.parent.getFullPath() + "/" + this.name;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public long getCreatedTime() {
    return this.createdTime;
  }

  public long getLastUpdatedTime() {
    return this.lastUpdatedTime;
  }

  public void setLastUpdatedTime(long time) {
    this.lastUpdatedTime = time;
  }

  public long getLastAccessedTime() {
    return this.lastAccessedTime;
  }

  public void setLastAccessedTime(long time) {
    this.lastAccessedTime = time;
  }
}
