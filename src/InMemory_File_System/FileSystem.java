package InMemory_File_System;

import Call_Center.Director;

public class FileSystem {
  public static FileSystem instance;
  private Directory workspace;

  private FileSystem() {
    Directory root = new Directory("/", null);
    this.workspace = root;
  }

  public static FileSystem getInstance() {
    if (instance == null) {
      instance = new FileSystem();
    }
    return instance;
  }

  public void cd(String name) {
    if (name != null) {
      for (Entry entry : workspace.getFileList()) {
        if (entry.getName().equals(name) && entry.isDir()) {
          workspace = (Directory) entry;
          return;
        }
      }
      System.out.println(name + " does not exist.");
    }
  }

  public void pwd() {
    System.out.println(workspace.getFullPath());
  }

  public void ls() {
    for (Entry entry : workspace.getFileList()) {
      System.out.println(entry);
    }
  }

  public void touch(String name) {
    if (name != null) {
      File f = null;
      for (Entry entry : workspace.getFileList()) {
        if (!entry.isDir() && entry.getName().equals(name)) {
          f = (File) entry;
          break;
        }
      }
      if (f != null) {
        f.setLastAccessedTime(System.nanoTime());
      }
      else {
        workspace.add(new File(name, workspace));
      }
    }
  }

  public void mkdir(String name) {
    if (name != null) {
      workspace.add(new Directory(name, workspace));
    }
  }

  public void rm(String name) {
    if (name != null) {
      for (Entry entry : workspace.getFileList()) {
        if (entry.getName().equals(name)) {
          workspace.delete(entry);
          return;
        }
      }
      System.out.println(name + " does not exist.");
    }
  }

  public void vi(String name, String content) {
    if (name != null) {
      File f = null;
      for (Entry entry : workspace.getFileList()) {
        if (!entry.isDir() && entry.getName().equals(name)) {
          f = (File) entry;
          break;
        }
      }
      if (f == null) {
        System.out.println(name + " does not exist.");
      }
      else {
        f.addContent(content);
      }
    }
  }

  public void cat(String name) {
    if (name != null) {
      File f = null;
      for (Entry entry : workspace.getFileList()) {
        if (!entry.isDir() && entry.getName().equals(name)) {
          f = (File) entry;
          break;
        }
      }
      if (f == null) {
        System.out.println(name + " does not exist.");
      }
      else {
        System.out.println(f.getContent());
      }
    }
  }
}
