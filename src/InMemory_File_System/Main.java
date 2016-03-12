package InMemory_File_System;

public class Main {
  public static void main(String[] args) {
    FileSystem fs = FileSystem.getInstance();
    fs.pwd();
    fs.mkdir("test");
    fs.cd("test");
    fs.mkdir("test_sub");
    fs.cd("test_sub");
    fs.cd("nonexist");
    fs.pwd();
    fs.touch("file1");
    fs.ls();
    fs.vi("file1", "this is a test");
    fs.cat("file1");
    fs.vi("file1", " this is a append.");
    fs.cat("file1");
    fs.rm("file1");
    fs.ls();
  }
}
