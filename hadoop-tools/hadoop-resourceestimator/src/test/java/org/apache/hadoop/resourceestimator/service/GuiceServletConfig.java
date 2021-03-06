/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.resourceestimator.service;

import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

/**
 * GuiceServletConfig is a wrapper class to have a static Injector instance
 * instead of having the instance inside test classes. This allow us to use
 * Jersey test framework after 1.13.
 * Please check test cases to know how to use this class:
 * e.g. TestRMWithCSRFFilter.java
 */
public class GuiceServletConfig extends GuiceServletContextListener {

  private static Injector internalInjector = null;

  @Override protected Injector getInjector() {
    return internalInjector;
  }

  public static Injector setInjector(Injector in) {
    internalInjector = in;
    return internalInjector;
  }
}