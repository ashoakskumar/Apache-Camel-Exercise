package com.ashok.example.route;


import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ashok.example.mpdel.Employee;

@Component
public class KafkaReceiverRoute extends RouteBuilder {
    @Autowired
    GetEmployee getEmployee;
    @Override
    public void configure() throws Exception {
        from("kafka:kafkalearning")
                .unmarshal().json(JsonLibrary.Jackson, Employee.class)
                .bean(getEmployee)
                .to("log:myloggingqueue");
    }
}
@Component
class GetEmployee{
    Logger logger= LoggerFactory.getLogger(GetEmployee.class);
    public void getData(Employee employee){
        logger.info("Emp data: "+employee.getId());
    }
}
