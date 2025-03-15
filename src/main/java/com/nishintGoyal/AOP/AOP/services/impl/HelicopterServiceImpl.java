package com.nishintGoyal.AOP.AOP.services.impl;
import com.nishintGoyal.AOP.AOP.services.HelicopterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HelicopterServiceImpl implements HelicopterService
{
    @Override
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
    public String trackPackage(Long orderId)
    {
        try
        {
            log.info("Tracking the order...");
            Thread.sleep(500);
            throw new RuntimeException("Exception occured during trackPackage");
        }
        catch(InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }
}
