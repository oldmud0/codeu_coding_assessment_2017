package com.google.codeu.codingchallenge.tests;

import java.io.IOException;

import com.google.codeu.codingchallenge.JSON;
import com.google.codeu.codingchallenge.JSONFactory;
import com.google.codeu.codingchallenge.JSONParser;
import com.google.codeu.codingchallenge.tests.Asserts.AssertException;

public class SupportedEscapeSequenceTest implements Test {

    @Override
    public String getName() {
        return "All Supported Escape Sequences";
    }

    @Override
    public void run(JSONFactory factory) throws Exception {
      final JSONParser parser = factory.parser();
      
      final JSON obj = parser.parse("{ \"foo\":\"\\\"\\t\\n\" }");
      Asserts.isEqual(obj.getString("foo"), "\"\t\n");
   }

}
