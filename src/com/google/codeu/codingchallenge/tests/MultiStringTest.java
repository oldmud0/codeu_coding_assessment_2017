package com.google.codeu.codingchallenge.tests;

import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.codeu.codingchallenge.JSON;
import com.google.codeu.codingchallenge.JSONFactory;
import com.google.codeu.codingchallenge.JSONParser;

public class MultiStringTest implements Test {

    @Override
    public String getName() {
        return "Multiple Strings";
    }

    @Override
    public void run(JSONFactory factory) throws Exception {
      final JSONParser parser = factory.parser();
      final String filename = "MultiStringTest.txt";
      final String contents = new String(Files.readAllBytes(Paths.get(filename)));
      
      final JSON obj = parser.parse(contents);
      
      Asserts.isNotNull(obj);
      Asserts.isEqual(obj.getString("foo"), "bar");
      Asserts.isEqual(obj.getString("bar"), "baz");
      Asserts.isEqual(obj.getString("yerp"), "keke");
   }

}
