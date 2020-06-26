package com.lms.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Repository;

import com.lms.DTO.LeaveApplyDTO;
import com.lms.DTO.LeaveBalanceDTO;

@Repository
public class LeaveBlanceServiceClient {

    @Autowired
    OAuth2RestTemplate restTemplate;
    
    @Autowired 
	private LoadBalancerClient cc;

    //String url = "http://localhost:8282/leave/LeaveBalance";

    public LeaveBalanceDTO[] getLeaveBalnce() {
        ServiceInstance ss = cc.choose("lms-servicer");
		String url = ss.getUri().toString();
		url = url + "/leaveBal/leaveBalance";
        ResponseEntity<LeaveBalanceDTO[]> resp = restTemplate.getForEntity(url, LeaveBalanceDTO[].class);
        LeaveBalanceDTO[] myList =  resp.getBody();
        return myList;
    }
    
    public String applyLeave(LeaveApplyDTO leaveApplyDTO) {
		 System.out.println("Applying Leave for user: " + leaveApplyDTO.getEmp_id());
	        ServiceInstance ss = cc.choose("leave-apply-update-producer");
			String url = ss.getUri().toString();
			url = url + "/leave/applyLeave";
			System.out.println("promotions URL ===============>>>>" + url);
	        String resp = restTemplate.postForObject( url, leaveApplyDTO, String.class);
	        return resp;
	}
	
	public String updateLeaveStatus(List<LeaveApplyDTO> leaveApplyDTO) {
		 System.out.println("Updating Leave for " + leaveApplyDTO.size() + " user/s");
	        ServiceInstance ss = cc.choose("leave-apply-update-producer");
			String url = ss.getUri().toString();
			url = url + "/leave/updateLeaveStatus";
			System.out.println("promotions URL ===============>>>>" + url);
	        String resp = restTemplate.postForObject( url, leaveApplyDTO, String.class);
	        return resp;
	}
}


