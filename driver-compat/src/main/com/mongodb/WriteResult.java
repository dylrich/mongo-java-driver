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

public class WriteResult {

    private final org.mongodb.result.WriteResult result;
    private final com.mongodb.WriteConcern writeConcern;
    private final CommandResult getLastErrorResult;

    WriteResult(final org.mongodb.result.WriteResult result, final WriteConcern writeConcern) {
        this.result = result;
        this.writeConcern = writeConcern;
        if (result.getGetLastErrorResult() != null) {
            // TODO: need command and server address fer realz
            getLastErrorResult = DBObjects.toCommandResult(DBObjects.toDBObject(result.getGetLastErrorResult().getCommand()),
                                                           new ServerAddress(result.getGetLastErrorResult().getAddress()),
                                                           result.getGetLastErrorResult().getResponse());
        }
        else {
            getLastErrorResult = null;
        }
    }


    public com.mongodb.CommandResult getLastError() {
        return getCachedLastError();  // TODO: Support getasterror after write op is already done?  Maybe not
    }

    public WriteConcern getLastConcern() {
        return writeConcern;
    }

    public CommandResult getCachedLastError() {
         return getLastErrorResult;
    }
}
