package com.google.codeu.codingchallenge.tests;

import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.codeu.codingchallenge.JSON;
import com.google.codeu.codingchallenge.JSONFactory;
import com.google.codeu.codingchallenge.JSONParser;
import com.google.codeu.codingchallenge.MyJSON;

public class BracesInStringsTest implements Test {

    @Override
    public String getName() {
        return "Braces In Strings";
    }

    @Override
    public void run(JSONFactory factory) throws Exception {
      final JSONParser parser = factory.parser();
      final String filename = "tests/BracesInStringsTest.txt";
      final String contents = new String(Files.readAllBytes(Paths.get(filename)));
      
      final JSON obj = parser.parse(contents);
      
      Asserts.isNotNull(obj);
      
      JSON foo = obj.getObject("foo}");
      Asserts.isNotNull(foo);
      
      JSON fooBar = foo.getObject("bar}");
      Asserts.isNotNull(fooBar);
      
      Asserts.isEqual(fooBar.getString("b{az"), "{yerp");
      Asserts.isEqual(fooBar.getString("keke"), "coolio");
      
      Asserts.isEqual(foo.getString("as{df"), "g}hjkl");
      
      Asserts.isEqual(obj.getString("lastKey"), "lastValue");
   }

}
