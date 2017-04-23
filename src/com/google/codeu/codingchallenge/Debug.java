package com.google.codeu.codingchallenge;

public class Debug {
  
  private static boolean enabled = false;

  public static void println(String msg) {
    if (isEnabled())
      System.out.format("[debug] %s%n", msg);
  }
  
  public static void setEnabled(boolean enabled) {
    Debug.enabled = enabled;
  }

  public static boolean isEnabled() {
    return enabled;
  }

}