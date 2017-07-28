package com.edifecs.notification.service;

import com.edifecs.notification.service.constants.ServiceHandlerConstants;
import com.edifecs.servicemanager.annotations.Handler;
import com.edifecs.servicemanager.annotations.Property;
import com.edifecs.servicemanager.annotations.Service;

/**
 * Created by neerbans on 7/10/2017.
 */

@Service(name = ServiceHandlerConstants.NT_SERVICE, version = "1.0", description = ServiceHandlerConstants.NT_DESCRIPTION,
properties = { @Property(name = "name", propertyType = Property.PropertyType.STRING, description = "Notification Name",
defaultValue = "Technology Trends")})
public interface INTService {

    @Handler
    IUserHandler getUserHandler();
}
