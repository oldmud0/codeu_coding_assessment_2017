package com.google.codeu.codingchallenge.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import com.google.codeu.codingchallenge.Debug;
import com.google.codeu.codingchallenge.JSON;
import com.google.codeu.codingchallenge.JSONFactory;
import com.google.codeu.codingchallenge.JSONParser;
import com.google.codeu.codingchallenge.MyJSON;
import com.google.codeu.codingchallenge.MyJSONParser;

public class TestFactory {
  
  /**
   * Retrieve and add all tests from the test battery file.
   * @param tester The tester which tests will be added to
   */
  public void generateTests(Tester tester) {
    Scanner scanner;
    int testNo = 1, line = 1;
    try {
      scanner = new Scanner(new File("tests/TestBattery.txt"));
      while(scanner.hasNextLine()) {
        String testData = scanner.nextLine();
        int expectedKeys = Integer.parseInt(scanner.nextLine());

        tester.add(new GeneratedTest(String.format("Battery (#%02d, line %d)", testNo, line), testData, expectedKeys));

        line += 2;
        testNo++;
      }
      scanner.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
  
  final class GeneratedTest implements Test {
    
    private String name;
    private String testData;
    private int expectedKeys;
    
    public GeneratedTest(String name, String testData, int expectedKeys) {
      this.name = name;
      this.testData = testData;
      this.expectedKeys = expectedKeys;
    }

    @Override
    public String getName() {
      return name;
    }

    @Override
    public void run(JSONFactory factory) throws Exception {
      final JSONParser parser = factory.parser();
      
      try {
        final JSON obj = parser.parse(testData);
        int keys = MyJSON.count(obj);
        Asserts.isEqual(keys, expectedKeys);
      } catch (IOException e) {
        if(expectedKeys != -1)
          throw e;
      }
    }
  }

}
