package com.emre.publicTransport.Core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class LogManager
{
    private ArrayList<String> lastXLogs;
    private final int x = 100;

    private final Logger logger;

    private static LogManager singleton;
    public static LogManager getSingleton()
    {
        if(singleton == null)
            singleton = new LogManager();

        return singleton;
    }
    private LogManager()
    {
        logger = LoggerFactory.getLogger(LogManager.class);

        lastXLogs = new ArrayList<>();
    }

    public void Log(String str)
    {
        logger.info(str);

        System.out.println(str);

        LogCommon(str);
    }
    public void LogError(String str)
    {
        logger.error(str);

        System.err.println(str);

        LogCommon(str);
    }
    private void LogCommon(String str)
    {
        lastXLogs.add(str);

        if(lastXLogs.size() > x)
            lastXLogs.remove(0);
    }

    public ArrayList<String> getLogs()
    {
        return lastXLogs;
    }

}
