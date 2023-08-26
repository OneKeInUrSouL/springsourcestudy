package com.example.springsourcestudy.容器和上下文.工厂;

import org.junit.jupiter.api.Test;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;
import org.springframework.core.metrics.StartupStep;

public class ApplicationContentTest {
    /**
     * 记录应用程序启动的步骤
     */
    @Test
    public void testApplicationStartUp(){
        BufferingApplicationStartup bufferingApplicationStartup = new BufferingApplicationStartup(64);
        StartupStep startupStep = bufferingApplicationStartup.start("第一件事情");
        startupStep.tag("tag1","xxx1");
        startupStep.end();
        StartupStep startupStep2 = bufferingApplicationStartup.start("第二件事情");
        startupStep2.tag("tag2","xxx2");
        startupStep2.end();
    }
}
