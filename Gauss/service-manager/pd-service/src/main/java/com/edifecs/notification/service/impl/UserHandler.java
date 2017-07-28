package com.edifecs.notification.service.impl;

import com.edifecs.notification.service.IUserHandler;

/**
 * Created by neerbans on 7/11/2017.
 */
public class UserHandler extends NTHandler implements IUserHandler {

    @Override
    public String getUserInfo() {
        return "SM";
    }
}
