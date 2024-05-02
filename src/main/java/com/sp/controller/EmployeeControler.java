package com.sp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sp.entity.Email;
import com.sp.entity.Employee;
import com.sp.service.EmailService;
import com.sp.service.EmployeeService;

@Controller
public class EmployeeControler {
	

	private EmployeeService service;
	
	
	private EmailService emailService;
	
	

    public EmployeeControler(EmployeeService service, EmailService emailService) {
        this.service = service;
        this.emailService = emailService;
    }

	
	@GetMapping("/view")
	public ModelAndView diplayData() {
		
		
		
		ModelAndView mav=new ModelAndView();
		
		mav.addObject("emp", service.retriveData());
		
		mav.setViewName("view");
		
		return mav;
	}
	
	
	@GetMapping("/add")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();

		// sending empty obj for form binding
		mav.addObject("employee", new Employee());

		mav.setViewName("add");

		return mav;
	}
	
	 
	    @PostMapping("/emp")
	    public ModelAndView addEmployee(Employee emp) {
	        emp.setEmployeeStatus("Y");
	        ModelAndView mav = new ModelAndView();
	        Employee addEmployee = service.addEmployee(emp);
	        if (addEmployee != null) {
	            emailService.sendSimpleMessage(addEmployee.getEmployeeMailAddr(), Email.subject, Email.message);
	            mav.addObject("succMsg", "Successfully added employee");
	        } else {
	            mav.addObject("errMsg", "Failed to add employee");
	        }
	        mav.setViewName("add");
	        return mav;
	    }
	
	@GetMapping("/delete")
	public ModelAndView deleteEmployee(@RequestParam ("empId") Integer employeeId ) {
		
		ModelAndView mav=new ModelAndView();
		
		Employee emp = service.findById(employeeId);
		emp.setEmployeeStatus("N");
		service.addEmployee(emp);
		 
		 mav.addObject("emp", service.retriveData());
			
			mav.setViewName("view");
		 
		 return mav;
		
		
	}
	
	@GetMapping("/edit")
	public ModelAndView editEmployee(@RequestParam ("empId") Integer employeeId ) {
		
		ModelAndView mav=new ModelAndView();
		
		 Employee emp = service.findById(employeeId);
		 
		 mav.addObject("employee", emp);
			
			mav.setViewName("add");
		 
		 return mav;
		
		
	}


	
	

}
