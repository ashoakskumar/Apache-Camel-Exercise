package com.ashok.example.router;

import javax.xml.bind.JAXBContext;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.model.DataFormatDefinition;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.spi.DataFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ashok.example.model.Employee;
import com.ashok.example.model.EmployeeJson;
import com.ashok.example.processor.EmployeeJsonProcessor;

public class EmployeeJsonToXmlRouter extends RouteBuilder{

	  @Autowired
	    GetEmployee getEmployee;
	@Override
	public void configure() throws Exception {
		JacksonDataFormat jsonDataFormat = new JacksonDataFormat(EmployeeJson.class);
		JAXBContext context = JAXBContext.newInstance(EmployeeJson.class);
		 DataFormat jaxb = new org.apache.camel.converter.jaxb.JaxbDataFormat(context);
		    DataFormatDefinition defination = new DataFormatDefinition();
		    defination.setDataFormat(jaxb);
		from("file:JsonFolder").unmarshal(jsonDataFormat).process(new EmployeeJsonProcessor())
       .marshal(defination).to("file:XmlFolder?fileName=output.xml");
	}
	
}
@Component
class GetEmployee{
    Logger logger= LoggerFactory.getLogger(GetEmployee.class);
    public void getData(EmployeeJson employee){
        logger.info("Emp data: "+employee.getEmpId());
    }
}