package com.google.codeu.codingchallenge.tests;

import com.google.codeu.codingchallenge.JSON;
import com.google.codeu.codingchallenge.JSONFactory;
import com.google.codeu.codingchallenge.JSONParser;

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
