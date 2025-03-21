package com.nishintGoyal.AOP.AOP.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class HelicopterServiceImplTest
{
    @Autowired
    private HelicopterServiceImpl helicopterService;

    @Test
    void orderPackage()
    {
        String str=helicopterService.orderPackage(-8L);
        log.info(str);
    }

    @Test
    void trackPackage()
    {
        String str2=helicopterService.trackPackage(100L);
        log.info(str2);
    }
}
