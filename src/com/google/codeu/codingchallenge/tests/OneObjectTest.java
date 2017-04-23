package com.google.codeu.codingchallenge.tests;

import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.codeu.codingchallenge.JSON;
import com.google.codeu.codingchallenge.JSONFactory;
import com.google.codeu.codingchallenge.JSONParser;
import com.google.codeu.codingchallenge.MyJSON;

public class OneObjectTest implements Test {

    @Override
    public String getName() {
        return "One Object";
    }

    @Override
    public void run(JSONFactory factory) throws Exception {
      final JSONParser parser = factory.parser();
      final String filename = "OneObjectTest.txt";
      final String contents = new String(Files.readAllBytes(Paths.get(filename)));
      
      final JSON obj = parser.parse(contents);
      
      Asserts.isNotNull(obj);
      Asserts.isNotNull(obj.getObject("foo"));
      Asserts.isEqual(obj.getObject("foo").getString("bar"), "baz");
      Asserts.isEqual(obj.getObject("foo").getString("bing"), "bop");
   }

}
