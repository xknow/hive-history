/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.hive.ql.history;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.ql.QueryPlan;
import org.apache.hadoop.hive.ql.exec.Task;
import org.apache.hadoop.hive.ql.history.HiveHistory;
import org.apache.hadoop.hive.ql.session.SessionState;
import org.apache.hadoop.hive.ql.session.SessionState.LogHelper;
import org.apache.hadoop.mapred.Counters;
import org.apache.hadoop.mapred.Counters.Counter;
import org.apache.hadoop.mapred.Counters.Group;

/**
 * HiveHistory. Logs information such as query, query plan, runtime statistics
 * into a file.
 * Each session uses a new object, which creates a new file.
 */
public class HiveHistoryImpl implements HiveHistory {

    private static final Log LOG = LogFactory.getLog(HiveHistoryImpl.class);

    /**
     * Construct HiveHistoryImpl object and open history log file.
     *
     * @param ss
     */
    public HiveHistoryImpl(SessionState ss) {
        System.out.println("====================");
        LOG.info("=======================");
    }

    
    public String getHistFileName() {
        return "";
    }

    /**
     * Write the a history record to history file.
     *
     * @param rt
     * @param keyValMap
     */
    void log(RecordTypes rt, Map<String, String> keyValMap) {
    }

    
    public void startQuery(String cmd, String id) {
        LOG.info("=======================");
    }


    
    public void setQueryProperty(String queryId, Keys propName, String propValue) {
    }

    
    public void setTaskProperty(String queryId, String taskId, Keys propName,
                                String propValue) {
    }

    
    public void setTaskCounters(String queryId, String taskId, Counters ctrs) {
    }

    
    public void printRowCount(String queryId) {
    }

    
    public void endQuery(String queryId) {
        LOG.info("=======================");
    }

    
    public void startTask(String queryId, Task<? extends Serializable> task,
                          String taskName) {
    }

    
    public void endTask(String queryId, Task<? extends Serializable> task) {
    }

    
    public void progressTask(String queryId, Task<? extends Serializable> task) {
    }

    /**
     * write out counters.
     */
    static ThreadLocal<Map<String,String>> ctrMapFactory =
            new ThreadLocal<Map<String, String>>() {
                
                protected Map<String,String> initialValue() {
                    return new HashMap<String,String>();
                }
            };

    
    public void logPlanProgress(QueryPlan plan) throws IOException {
        Map<String,String> ctrmap = ctrMapFactory.get();
        ctrmap.put("plan", plan.toString());
        log(RecordTypes.Counters, ctrmap);
    }

    
    public void setIdToTableMap(Map<String, String> map) {
    }

    /**
     * Returns table name for the counter name.
     *
     * @param name
     * @return tableName
     */
    String getRowCountTableName(String name) {
        return null;
    }

    
    public void closeStream() {
    }

    
    public void finalize() throws Throwable {
        closeStream();
    }

}
