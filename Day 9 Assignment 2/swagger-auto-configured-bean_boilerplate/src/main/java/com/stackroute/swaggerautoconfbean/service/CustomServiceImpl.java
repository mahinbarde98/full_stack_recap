package com.stackroute.swaggerautoconfbean.service;

import org.springframework.stereotype.Service;

@Service
public class CustomServiceImpl implements CustomService{
    @Override
    public String customLogic() {
        // Implement your custom logic here
        return "Custom logic executed by CustomService";
    }
}
