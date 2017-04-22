package com.google.codeu.codingchallenge.tests;

import java.util.Collection;
import java.util.HashSet;

import com.google.codeu.codingchallenge.JSON;
import com.google.codeu.codingchallenge.JSONFactory;
import com.google.codeu.codingchallenge.JSONParser;

public class EmptyObjectTest implements Test {
    
    public String getName() {
        return "Empty Object";
    }
    
    @Override
    public void run(JSONFactory factory) throws Exception {
      final JSONParser parser = factory.parser();
      final JSON obj = parser.parse("{ }");

      final Collection<String> strings = new HashSet<>();
      obj.getStrings(strings);

      Asserts.isEqual(strings.size(), 0);

      final Collection<String> objects = new HashSet<>();
      obj.getObjects(objects);

      Asserts.isEqual(objects.size(), 0);
    }
}
