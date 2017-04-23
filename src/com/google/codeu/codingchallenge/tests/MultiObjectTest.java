package com.google.codeu.codingchallenge.tests;

import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.codeu.codingchallenge.JSON;
import com.google.codeu.codingchallenge.JSONFactory;
import com.google.codeu.codingchallenge.JSONParser;
import com.google.codeu.codingchallenge.MyJSON;

public class MultiObjectTest implements Test {

    @Override
    public String getName() {
        return "Multiple Objects";
    }

    @Override
    public void run(JSONFactory factory) throws Exception {
      final JSONParser parser = factory.parser();
      final String filename = "MultiObjectTest.txt";
      final String contents = new String(Files.readAllBytes(Paths.get(filename)));
      
      final JSON obj = parser.parse(contents);
      
      Asserts.isNotNull(obj);
      Asserts.isNotNull(obj.getObject("foo"));
      Asserts.isNotNull(obj.getObject("yerp"));
      Asserts.isEqual(obj.getObject("foo").getString("bar"), "baz");
      Asserts.isEqual(obj.getObject("yerp").getString("keke"), "coolio");
   }

}
