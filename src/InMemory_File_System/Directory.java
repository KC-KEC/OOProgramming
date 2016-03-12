package InMemory_File_System;

import Call_Center.Director;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Directory extends Entry {

  private List<Entry> fileList;

  public Directory(String name, Directory parent) {
    super(name, parent);
    this.fileList = new LinkedList<>();
  }

  public int size() {
    int result = 0;
    for (Entry entry : fileList) {
      result += entry.size();
    }
    return result;
  }

  public boolean isDir() {
    return true;
  }

  public void delete(Entry entry) {
    if (entry != null) {
      fileList.remove(entry);
      this.setLastAccessedTime(System.nanoTime());
      this.setLastUpdatedTime(System.nanoTime());
    }
  }

  public void add(Entry entry) {
    if (entry != null) {
      this.fileList.add(entry);
      this.setLastAccessedTime(System.nanoTime());
      this.setLastUpdatedTime(System.nanoTime());
    }
  }

  public List<Entry> getFileList() {
    this.setLastAccessedTime(System.nanoTime());
    return Collections.unmodifiableList(fileList);
  }

  @Override
  public boolean equals(Object o) {
    if (o == null) {
      return false;
    }
    if (o == this) {
      return true;
    }
    if (!(o instanceof Directory)) {
      return false;
    }

    Directory dir = (Directory) o;
    return dir.getFileList() == this.getFileList() && dir.getName().equals(this.getName());
  }

  @Override
  public int hashCode() {
    int result = 17;
    if (this.fileList != null) result = 31 * result + this.fileList.hashCode();
    if (this.getName() != null) result = 31 * result + this.getName().hashCode();
    return result;
  }

  @Override
  public String toString() {
    return "Dir: " + this.getName();
  }
}
