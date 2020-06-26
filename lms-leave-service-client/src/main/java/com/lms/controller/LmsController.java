package com.lms.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.DTO.LeaveApplyDTO;
import com.lms.DTO.LeaveApplyDTO.Status;
import com.lms.DTO.LeaveApplyDTO.Types;
import com.lms.DTO.LeaveBalanceDTO;
import com.lms.client.LeaveBlanceServiceClient;
import com.lms.models.Product;

@RestController
public class LmsController {

    @Autowired
    LeaveBlanceServiceClient leaveServiceClient;

    @GetMapping("/leaveBal")
    public List<Product> products() {
    	List<Product> plist= new ArrayList<Product>();
    	LeaveBalanceDTO[] leaveBalanceDTO = leaveServiceClient.getLeaveBalnce();
    	for(LeaveBalanceDTO ld:leaveBalanceDTO) {
    		Product p = new Product(ld.getId(), ld.getEmpId(), ld.getSickLeave());
            plist.add(p);
    	}
        
        return plist;
    }
    
    @GetMapping("/applyLeave")
	public String applyLeave() {
		// List<Product> plist= new ArrayList<Product>();
		LeaveApplyDTO leaveApplyDTO = new LeaveApplyDTO("100", Types.ANNUAL_LEAVE, LocalDate.now(),
				LocalDate.of(2020, 07, 12), Status.SUBMITTED, "Vacation");
		String resp = leaveServiceClient.applyLeave(leaveApplyDTO);

		return resp;
	}

	@GetMapping("/updateLeaveStatus")
	public String updateLeaveStatus() {
		List<LeaveApplyDTO> leaveApplyDTOs = new ArrayList<>();
		LeaveApplyDTO leaveApplyDTO = new LeaveApplyDTO("100", Types.ANNUAL_LEAVE, LocalDate.now(),LocalDate.of(2020, 07, 12), Status.REJECTED, "Vacation");
		leaveApplyDTOs.add(leaveApplyDTO);
		
		String resp = leaveServiceClient.updateLeaveStatus(leaveApplyDTOs);

		return resp;
	}
    


  
}
