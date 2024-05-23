package com.emre.publicTransport.Controller;

import com.emre.publicTransport.Core.LogManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/report")
public class LogReportController
{
    @GetMapping("")
    public ArrayList<String> Get()
    {
        LogManager.getSingleton().Log("ReportRequest");
        return LogManager.getSingleton().getLogs();
    }

}
