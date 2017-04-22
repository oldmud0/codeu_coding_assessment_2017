package com.google.codeu.codingchallenge.tests;

import java.io.IOException;

import com.google.codeu.codingchallenge.JSON;
import com.google.codeu.codingchallenge.JSONFactory;
import com.google.codeu.codingchallenge.JSONParser;
import com.google.codeu.codingchallenge.tests.Asserts.AssertException;

public class TripleQuoteTest implements Test {

    @Override
    public String getName() {
        return "Syntax Error - Triple Quotes";
    }

    @Override
    public void run(JSONFactory factory) throws Exception {
      final JSONParser parser = factory.parser();
      
      try {
          final JSON obj = parser.parse("{ \"name\":\"\"\" }");
          throw new AssertException("Expected IOException to be thrown, but nothing was thrown");
      } catch (IOException e) {
          //Success!
      }
   }

}
