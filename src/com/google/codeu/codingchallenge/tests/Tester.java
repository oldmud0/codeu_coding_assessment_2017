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

import java.util.Map;
import java.util.TreeMap;

import com.google.codeu.codingchallenge.JSONFactory;

import java.util.HashMap;

final class Tester {

  private final Map<String, Test> tests = new TreeMap<>();

  private int testsFailed = 0;

  public void add(Test test) {
    tests.put(test.getName(), test);
  }

  public void run(JSONFactory factory) {
    testsFailed = 0;
    for (final Map.Entry<String, Test> test : tests.entrySet()) {
      try {
        long startTime = System.nanoTime();
        test.getValue().run(factory);
        long endTime = System.nanoTime();
        System.out.format("[PASS] Test %s (%.04f s)\n", test.getKey(), (endTime - startTime) * Math.pow(10, -9));
      } catch (Exception ex) {
        ex.printStackTrace();
        System.out.format("[FAIL] Test %s (%s)\n", test.getKey(), ex.toString());
        testsFailed++;
      }
    }
  }

  public int getTotalTests() {
    return tests.size();
  }

  public int getTestsPassed() {
    return getTotalTests() - testsFailed;
  }

  public int getTestsFailed() {
    return testsFailed;
  }

  public String getSummary() {
    return String.format("%d out of %d tests passed (%.02f%%).", getTestsPassed(), getTotalTests(),
        (double) getTestsPassed() / getTotalTests() * 100.);
  }
}
