package com.frontline.step;

import org.junit.Test;
import com.frontline.manager.AppiumManager;

public class RunnerCukes
{
    @Test
    public void testCukesRunner() throws Exception
    {
        AppiumManager parallelThread = new AppiumManager();
        parallelThread.runner("");
    }
}
