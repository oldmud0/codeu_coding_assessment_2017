package com.google.codeu.codingchallenge.tests;

import com.google.codeu.codingchallenge.JSON;
import com.google.codeu.codingchallenge.JSONFactory;
import com.google.codeu.codingchallenge.JSONParser;

public class ObjectValueTest implements Test {

  @Override
  public String getName() {
    return "Object Value";
  }

  @Override
  public void run(JSONFactory factory) throws Exception {

    final JSONParser parser = factory.parser();
    final JSON obj = parser.parse("{ \"name\":{\"first\":\"sam\", \"last\":\"doe\" } }");

    final JSON nameObj = obj.getObject("name");

    Asserts.isNotNull(nameObj);
    Asserts.isEqual("sam", nameObj.getString("first"));
    Asserts.isEqual("doe", nameObj.getString("last"));
  }
}
