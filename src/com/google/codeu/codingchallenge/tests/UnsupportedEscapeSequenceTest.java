package com.google.codeu.codingchallenge.tests;

import java.io.IOException;

import com.google.codeu.codingchallenge.JSON;
import com.google.codeu.codingchallenge.JSONFactory;
import com.google.codeu.codingchallenge.JSONParser;
import com.google.codeu.codingchallenge.tests.Asserts.AssertException;

public class UnsupportedEscapeSequenceTest implements Test {

    @Override
    public String getName() {
        return "Syntax Error - Unsupported Escape Sequences";
    }

    @Override
    public void run(JSONFactory factory) throws Exception {
      final JSONParser parser = factory.parser();
      
      try {
          final JSON obj = parser.parse("{ \"foo\":\"\\g\\a\" }");
          throw new AssertException("Expected IOException to be thrown, but nothing was thrown");
      } catch (IOException e) {
          //Success!
      }
   }

}
