package io.xknow.hive;

import io.xknow.util.ClassTransformer;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.hive.ql.history.HiveHistoryImpl;

import java.lang.instrument.ClassDefinition;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;
import java.util.ResourceBundle;

/**
 * Created by zxy on 15-6-9.
 */
public class HiveHistoryAgent {
    public static final String HIVE_HISTORY_CLASSFILE_PATH = "hive.history.classfile.path";
    private static final String DEFAULT_HIVE_HISTORY_CLASSFILE_PATH = "/etc/hive/hive-history.properties";

    private static final Log LOG = LogFactory.getLog(HiveHistoryAgent.class);

    public static void premain(String agentArgs, Instrumentation inst) {
        LOG.info("agentArgs = " + agentArgs);
        String classFile = null;
        String configFile = agentArgs == null ? DEFAULT_HIVE_HISTORY_CLASSFILE_PATH : agentArgs;
        try {
            Configuration config = new PropertiesConfiguration(configFile);
            classFile = config.getString(HIVE_HISTORY_CLASSFILE_PATH);
            if (classFile == null) {
                throw new ConfigurationException("Could not find configuration : " + HIVE_HISTORY_CLASSFILE_PATH);
            }
        } catch (ConfigurationException e) {
            LOG.error("Could not find config file : " + configFile, e);
        }
        try {
            inst.redefineClasses(new ClassDefinition(HiveHistoryImpl.class, ClassTransformer.getBytesFromFile(classFile)));
        } catch (ClassNotFoundException e) {
            LOG.error("RedefineClass Exception", e);
        } catch (UnmodifiableClassException e) {
            LOG.error("RedefineClass Exception", e);
        }
    }
}
