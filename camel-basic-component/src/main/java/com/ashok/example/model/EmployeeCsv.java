package com.ashok.example.model;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@CsvRecord(separator = "," , skipFirstLine = true)
public class EmployeeCsv {

	@DataField(pos = 2)
	private String empName;
	@DataField(pos = 1)
	private int empId;
}
