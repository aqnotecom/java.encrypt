/**
 * @license
 * Copyright 2016 Google Inc. All rights reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.security.wycheproof.testcases;

import java.security.Provider;
import java.security.Security;
import java.util.TreeSet;
import junit.framework.TestCase;

/** Not a true test: reports information about the provider. */
public class BasicTest extends TestCase {

  /** List all algorithms known to the security manager. */
  public void testListAllAlgorithms() {
    for (Provider p : Security.getProviders()) {
      System.out.println();
      System.out.println("Provider:" + p.getName());
      // Using a TreeSet here, because the elements are sorted.
      TreeSet<String> list = new TreeSet<String>();
      for (Object key : p.keySet()) {
        list.add((String) key);
      }
      for (String algorithm : list) {
        if (algorithm.startsWith("Alg.Alias.")) {
          continue;
        }
        System.out.println(algorithm);
      }
    }
  }
}
