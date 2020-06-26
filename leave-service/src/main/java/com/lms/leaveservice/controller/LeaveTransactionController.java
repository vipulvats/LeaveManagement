package com.lms.leaveservice.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lms.leaveservice.dao.LeaveTransactionDAOInterface;
import com.lms.leaveservice.model.LeaveTransaction;


@RestController
@CacheConfig(cacheNames="LeaveService")
public class LeaveTransactionController{

	@Autowired
	LeaveTransactionDAOInterface leaveTransDAO;
	
	

	private static final Logger logger = Logger.getLogger(LeaveTransactionController.class.getName());

	
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
		
		/*LeaveTransaction leaveTransDTO = new LeaveTransaction("001", LeaveTransaction.Types.SICK_LEAVE, LocalDate.now(), LocalDate.of(2020, 6, 25),  LeaveTransaction.Status.REJECTED, "PTO");
		System.out.println(">>>>>>>>>:::::::::::::::::::");
		leaveTransDAO.saveAndFlush(leaveTransDTO);
		System.out.println(">>>>>>>>>");
		logger.info("Leave applied successfully for employeeId : " + leaveTransDTO.getEmp_id());
		*/
		//return "Leave applied successfully for employeeId : " + leaveTransDTO.getEmp_id();

		/*List<LeaveTransaction> totalLeaves = (List<LeaveTransaction>) leaveTransDAO.findAll();

		logger.info("Total fetched leaves = " + totalLeaves.size());

		for(LeaveTransaction lt : totalLeaves){
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>> : " + lt);
		}*/

	}

	@GetMapping(value = "/getAllLeaves", produces = { "application/JSON" })
	@Cacheable
	public List<LeaveTransaction> getAllLeaves() {
		List<LeaveTransaction> totalLeaves = (List<LeaveTransaction>) leaveTransDAO.findAll();

		logger.info("Total fetched leaves = " + totalLeaves.size());

		return totalLeaves;
	}

	@GetMapping("/applyLeave")
	public String applyLeave(@RequestBody LeaveTransaction leaveTransDTO) {

//		LeaveTransaction leaveTransDTO = new LeaveTransaction("001", LeaveTransaction.Types.ANNUAL_LEAVE, LocalDate.now(), LocalDate.of(2020, 6, 25),  LeaveTransaction.Status.SUBMITTED, "PTO");
	//	System.out.println(">>>>>>>>>:::::::::::::::::::");
		leaveTransDAO.saveAndFlush(leaveTransDTO);
		System.out.println(">>>>>>>>>");
		logger.info("Leave applied successfully for employeeId : " + leaveTransDTO.getEmp_id());
		
		return "Leave applied successfully for employeeId : " + leaveTransDTO.getEmp_id();

	}

	@PutMapping("/updateStatus")
	public String updateLeave(@RequestBody List<LeaveTransaction> leaveTransDTOs) {

		leaveTransDTOs.stream().forEach(leaveTransDTO -> {
			leaveTransDAO.saveAndFlush(leaveTransDTO);

			logger.info("Leave updated successfully for employeeId : " + leaveTransDTO.getEmp_id());
		});

		return "Leave status updated successfully for " + leaveTransDTOs.size() + " employee";
	}

}
