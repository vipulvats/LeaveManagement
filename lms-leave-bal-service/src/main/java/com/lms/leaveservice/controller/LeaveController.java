package com.lms.leaveservice.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.lms.leaveservice.LeaveBalance;
import com.lms.leaveservice.repo.LeaveRepository;

@RestController
public class LeaveController {


	@Autowired
	LeaveRepository leaveRepository;
	@PostConstruct
	void init()
	{
		/*
		 * for(int i=1;i<11;i++) { LeaveBalance leaveBalance = new LeaveBalance();
		 * leaveBalance.setEmpId(i); leaveBalance.setAnnualLeave(20);
		 * leaveBalance.setMaternityLeave(10); leaveBalance.setSickLeave(15);
		 * leaveBalance.setPaternityLeave(10);
		 * leaveRepository.saveAndFlush(leaveBalance); }
		 */


	}



	@GetMapping("/leaveBalance")
	public List<LeaveBalance> getAllPromotions() {
		return leaveRepository.findAll();
	}
}
