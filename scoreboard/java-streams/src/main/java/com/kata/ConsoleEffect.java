package com.kata;

public class ConsoleEffect implements Effect {

  private String line;

  public ConsoleEffect(String line) {
    this.line = line;
  }

  public void execute() {
    System.out.println(line);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ConsoleEffect that = (ConsoleEffect) o;

    return line != null ? line.equals(that.line) : that.line == null;
  }

  @Override
  public int hashCode() {
    return line != null ? line.hashCode() : 0;
  }
}
