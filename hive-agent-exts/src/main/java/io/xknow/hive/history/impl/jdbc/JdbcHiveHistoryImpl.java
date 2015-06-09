package io.xknow.hive.history.impl.jdbc;

import org.apache.hadoop.mapred.Counters;
import org.apache.hadoop.hive.ql.QueryPlan;
import org.apache.hadoop.hive.ql.exec.Task;
import org.apache.hadoop.hive.ql.history.HiveHistory;
import org.apache.hadoop.hive.ql.history.HiveHistoryImpl;
import org.apache.hadoop.hive.ql.session.SessionState;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

/**
 * Created by zxy on 15-6-9.
 */
public class JdbcHiveHistoryImpl extends HiveHistoryImpl {

    public JdbcHiveHistoryImpl(SessionState ss) {
        super(ss);
    }//    private HiveHistoryImpl hhi = null;


    public String getHistFileName() {
        return null;
    }

    public void startQuery(String s, String s1) {

    }

    public void setQueryProperty(String s, Keys keys, String s1) {

    }

    public void setTaskProperty(String s, String s1, Keys keys, String s2) {

    }

    public void setTaskCounters(String s, String s1, org.apache.hadoop.mapred.Counters counters) {

    }

    public void printRowCount(String s) {

    }

    public void endQuery(String s) {

    }

    public void startTask(String s, Task<? extends Serializable> task, String s1) {

    }

    public void endTask(String s, Task<? extends Serializable> task) {

    }

    public void progressTask(String s, Task<? extends Serializable> task) {

    }

    public void logPlanProgress(QueryPlan queryPlan) throws IOException {

    }

    public void setIdToTableMap(Map<String, String> map) {

    }

    public void closeStream() {

    }
}
