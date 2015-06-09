package io.xknow.hive.history.impl.log;

import org.apache.hadoop.hive.ql.history.HiveHistoryImpl;
import org.apache.hadoop.hive.ql.session.SessionState;

/**
 * Created by zxy on 15-6-9.
 */
public class LogHiveHistoryImpl extends HiveHistoryImpl{
    public LogHiveHistoryImpl(SessionState ss) {
        super(ss);
    }
}
