package com.chs.coreJava.clone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CloneExample {

	public static void main(String[] args) throws CloneNotSupportedException {
		Employee employee = new Employee("James", 32);
		Employee copiedEmp = (Employee)employee.clone();
		
		System.out.println("employee == copy: " + (employee == copiedEmp));
		System.out.println("employee equals to copy: " + (employee.equals(copiedEmp)));
		System.out.println("employee.name == copy.name: " + (employee.getName() == copiedEmp.getName()));
		
		employee.setAge(33);
		employee.setName("Thomas");
		System.out.println(employee);
		System.out.println(copiedEmp);//primitive type and string copied
		
		Company company = new Company("SIP park SuZhou", employee);
//		Company copiedCmp = (Company)company.clone();
		Company copiedCmp = copy(company);//copy by serialization
		
		System.out.println();
		System.out.println("Company == copy: " + (company == copiedCmp));
		System.out.println("Company equals to copy: " + (company.equals(copiedCmp)));
		System.out.println("Company.employee == copy.employee: " + (company.getEmployee() == copiedCmp.getEmployee()));
		
		company.getEmployee().setAge(66);
		System.out.println("Original " + company.getEmployee());
		System.out.println("Copied " + copiedCmp.getEmployee());
	}

	/** serialize Object **/
	public static <T>T copy(T src) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		T copied = null;
		
		try {
			oos = new ObjectOutputStream(bos);
			oos.writeObject(src);
			oos.flush();
			ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
			copied = (T)ois.readObject();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return copied;
	}
}
