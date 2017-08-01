package com.abhi.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Money {
	
	private BigDecimal value;

	public Money(BigDecimal value) {
		this.value = value;
	}

	public Money() {	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}
	public void setValue(String value) {
		this.value = new BigDecimal(value);
	}
	
	
	public BigDecimal getDolloars(){
		return value.setScale(0, RoundingMode.FLOOR);
	}
	
	public BigDecimal getCentC(){
		return value.subtract(getDolloars());
	}
	
	public Money multiplyBy(BigDecimal value){
		return new Money(value.multiply(value).setScale(2, RoundingMode.HALF_UP));
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return value.toString();
	}
	
	
	

}
