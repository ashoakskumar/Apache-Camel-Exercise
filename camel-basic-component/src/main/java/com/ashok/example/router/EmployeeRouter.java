package com.ashok.example.router;


import javax.xml.bind.JAXBContext;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.DataFormatDefinition;
import org.apache.camel.model.dataformat.JaxbDataFormat;
import org.apache.camel.spi.DataFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.camel.component.jackson.JacksonDataFormat;
import com.ashok.example.model.Employee;
import com.ashok.example.processor.EmployeeProcessor;

public class EmployeeRouter extends RouteBuilder{

	// XML Data Format
	@Autowired
    GetEmployee getEmployee;	

			// JSON Data Format
			//JacksonDataFormat jsonDataFormat = new JacksonDataFormat(Employee.class);
	@Override
	public void configure() throws Exception {
		/*
		 * JaxbDataFormat jaxbDataFormat = new JaxbDataFormat();
		 * jaxbDataFormat.setContextPath(Employee.class.getPackage().getName());
		 * JaxbDataFormat xmlDataFormat = new JaxbDataFormat(); JAXBContext con =
		 * JAXBContext.newInstance(Employee.class);
		 * xmlDataFormat.setContextPath("com.ashok.example.model.Employee");
		 */
		JacksonDataFormat jsonDataFormat = new JacksonDataFormat(Employee.class);
		jsonDataFormat.setPrettyPrint(true);
		JAXBContext context = JAXBContext.newInstance(Employee.class);
	    JaxbDataFormat xmlDataFormat = new JaxbDataFormat();
	    xmlDataFormat.setContextPath("context");
	    DataFormat jaxb = new org.apache.camel.converter.jaxb.JaxbDataFormat(context);
	    DataFormatDefinition defination = new DataFormatDefinition();
	    defination.setDataFormat(jaxb);
		//setContext(con);
		//from("file:/XmlFolder").doTry().unmarshal(jaxbDataFormat).bean(getEmployee).to("log:myloggingqueue");
		 from("file:XmlFolder").unmarshal(defination).process(new EmployeeProcessor()).marshal(jsonDataFormat)
		 .to("log:{body}").to("file:JsonFolder?fileName=emp.json");
         
		/*
		 * json(JsonLibrary.Jackson, Employee.class) .bean(getEmployee)
		 * .to("log:myloggingqueue");
		 */
	}
	@Component
	class GetEmployee{
	    Logger logger= LoggerFactory.getLogger(GetEmployee.class);
	    public void getData(Employee employee){
	        logger.info("Emp data: "+employee.getEmpName());
	    }
	}
}
