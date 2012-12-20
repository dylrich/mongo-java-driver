/*
 * Copyright (c) 2008 - 2012 10gen, Inc. <http://10gen.com>
 *
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
 *
 */

package com.mongodb;

import java.net.UnknownHostException;

// TO DO: fill out
public class ServerAddress {
    public ServerAddress(final org.mongodb.ServerAddress address) {

    }

    public ServerAddress() {

    }

    org.mongodb.ServerAddress toNew() {
        try {
            return new org.mongodb.ServerAddress();
        } catch (UnknownHostException e) {
            // ignore
            // TODO: figure out what to throw here
            throw new RuntimeException("this can't happen");
        }
    }
}
