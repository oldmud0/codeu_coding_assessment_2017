package com.google.codeu.codingchallenge.tests;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.codeu.codingchallenge.JSON;
import com.google.codeu.codingchallenge.JSONFactory;
import com.google.codeu.codingchallenge.JSONParser;
import com.google.codeu.codingchallenge.tests.Asserts.AssertException;

public class TrailingCommaTest implements Test {

  @Override
  public String getName() {
    return "Syntax Error - Trailing Comma";
  }

  @Override
  public void run(JSONFactory factory) throws Exception {
    final JSONParser parser = factory.parser();
    final String filename = "tests/TrailingCommaTest.txt";
    final String contents = new String(Files.readAllBytes(Paths.get(filename)));

    try {
      final JSON obj = parser.parse(contents);
      throw new AssertException("Expected IOException to be thrown, but nothing was thrown");
    } catch (IOException e) {
      // Success!
    }
  }

}
