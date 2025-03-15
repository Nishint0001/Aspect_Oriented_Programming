package com.nishintGoyal.AOP.AOP.services;

import lombok.extern.slf4j.Slf4j;

public interface HelicopterService
{
    public String orderPackage(Long orderId);

    public String trackPackage(Long orderId);

}
