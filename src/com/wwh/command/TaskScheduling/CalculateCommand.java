package com.wwh.command.TaskScheduling;

import java.math.BigDecimal;

public class CalculateCommand implements Command{

	BigDecimal num;
	
	public CalculateCommand(BigDecimal num) {
		super();
		this.num = num;
	}

	@Override
	public void execute() {
		System.out.println(num.multiply(num).multiply(num).multiply(num).multiply(num).multiply(num));
	}

}
