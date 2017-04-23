// Copyright 2017 Google Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.codeu.codingchallenge.tests;

import com.google.codeu.codingchallenge.Debug;
import com.google.codeu.codingchallenge.JSON;
import com.google.codeu.codingchallenge.JSONFactory;
import com.google.codeu.codingchallenge.JSONParser;
import com.google.codeu.codingchallenge.MyJSON;
import com.google.codeu.codingchallenge.MyJSONParser;

final class TestMain {

  public static void main(String[] args) {

    Debug.setEnabled(false);

    final Tester tests = new Tester();

    tests.add(new EmptyObjectTest());
    tests.add(new StringValueTest());
    tests.add(new ObjectValueTest());
    tests.add(new TripleQuoteTest());
    tests.add(new UnsupportedEscapeSequenceTest());
    tests.add(new SupportedEscapeSequenceTest());
    tests.add(new OneStringTest());
    tests.add(new MultiStringTest());
    tests.add(new OneObjectTest());
    tests.add(new MultiObjectTest());
    tests.add(new NestedObjectTest());
    tests.add(new BracesInStringsTest());
    tests.add(new NoWhitespaceTest());
    tests.add(new TrailingCommaTest());
    tests.add(new DuplicateKeysTest());
    
    TestFactory factory = new TestFactory();
    factory.generateTests(tests);

    tests.run(new TestJSONFactory());

    System.out.println();
    System.out.println(tests.getSummary());
    System.exit(tests.getTestsFailed());
  }

  private static final class TestJSONFactory implements JSONFactory {
    @Override
    public JSONParser parser() {
      return new MyJSONParser();
    }

    @Override
    public JSON object() {
      return new MyJSON();
    }
  }
}
