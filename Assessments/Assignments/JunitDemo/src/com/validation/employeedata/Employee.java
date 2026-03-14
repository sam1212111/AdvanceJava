package com.validation.employeedata;

public class Employee {
		String name;
		double monthlySalary;
		int age;
		
	Employee(String name,double monthlySalary,int age){
		this.name= name;
		this.monthlySalary = monthlySalary;
		this.age = age;
	}
double calculateAnnualSalary() {
	double annualSal = monthlySalary*12;
	if (age>=18 && age<=50) {
		return (annualSal)+(annualSal*0.6);
	}else if(age>50 && age<=60) {
		return (annualSal)+(annualSal*0.7);
	}
	return annualSal;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public double getMonthlySalary() {
	return monthlySalary;
}

public void setMonthlySalary(double monthlySalary) {
	this.monthlySalary = monthlySalary;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}



}
