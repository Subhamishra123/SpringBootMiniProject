package com.nt;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.VO.EmployeeVO;
import com.nt.controller.MainController;

@SpringBootApplication
public class IocBootProj4Application {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter no of Desgs");
		int count=scanner.nextInt();
		if(count<1) {
			System.out.println("Invalid Desgs");
			scanner.close();
			return;
		}
		String[] desgs=new String[count];
		for(int i=0;i<count;i++)
		{
			System.out.println("Enter Desg "+(i+1));
			String desg=scanner.next();
			desgs[i]=desg.toUpperCase();
		}
		ConfigurableApplicationContext context = SpringApplication.run(IocBootProj4Application.class, args);
		MainController controller = context.getBean("employeeController", MainController.class);
		System.out.println("Employees with Desgs "+Arrays.toString(desgs));
		try {
			List<EmployeeVO> employeeVOs = controller.showEmployeeByDesgs(desgs);
			employeeVOs.forEach(vo->{
				System.out.println(vo);
			});
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some Error Happened "+e.getMessage());
		}
		context.close();
		scanner.close();
	}

}
