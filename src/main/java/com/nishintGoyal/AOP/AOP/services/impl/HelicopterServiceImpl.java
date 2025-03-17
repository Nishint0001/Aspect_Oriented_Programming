package com.nishintGoyal.AOP.AOP.services.impl;
import com.nishintGoyal.AOP.AOP.aspects.MyLogging;
import com.nishintGoyal.AOP.AOP.services.HelicopterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class HelicopterServiceImpl implements HelicopterService
{
    @Override
    @MyLogging
    public String orderPackage(Long orderId)
    {
        try
        {
            log.info("Processing the order...");
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            log.error("Error occurred while processing the order");
        }
        return "Order has been processed successfully,orderId"+orderId;
    }
    @Override
    @Transactional
    public String trackPackage(Long orderId)
    {
        try
        {
            log.info("Tracking the order...");
            Thread.sleep(500);
            //throw new RuntimeException("Exception occured during trackPackage");
        }
        catch(InterruptedException e)
        {
            log.error("error occured while tracking the order");
           // throw new RuntimeException(e);
        }

        return "Order Successfully tracked";
    }
}
