package com.google.codeu.codingchallenge.tests;

import com.google.codeu.codingchallenge.JSON;
import com.google.codeu.codingchallenge.JSONFactory;
import com.google.codeu.codingchallenge.JSONParser;

public class StringValueTest implements Test {

  @Override
  public String getName() {
    return "String Value";
  }

  @Override
  public void run(JSONFactory factory) throws Exception {
    final JSONParser parser = factory.parser();
    final JSON obj = parser.parse("{ \"name\":\"sam doe\" }");

    Asserts.isEqual("sam doe", obj.getString("name"));
  }

}
