package com.lms.uizuulapp;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import lombok.Data;

@Controller
public class HomeController {

    @Autowired
    OAuth2RestTemplate restTemplate;
    
    @Autowired 
  	private LoadBalancerClient cc;

	/*
	 * @Value("${catalog.api:http://localhost:8181/lms}") String lmsApi;
	 */

    @GetMapping("/leaveBalance")
    public String index(Model model)
    {        
    	ServiceInstance ss = cc.choose("lms-service");
    	String url = ss.getUri().toString();
    	
    	ResponseEntity<LeaveBalanceDTO[]> productResp = restTemplate.getForEntity(url, LeaveBalanceDTO[].class);
        List<LeaveBalanceDTO> productDTOS = Arrays.asList(productResp.getBody());

        model.addAttribute("leaveBalance", productDTOS);

        return "index.vue";
    }
    
    @PostMapping("/applyLeave")
    public String applyLeave(Model model)
    {        
        ServiceInstance ss = cc.choose("lms-service");
        String applyLeaveApi = ss.getUri().toString();
        applyLeaveApi = applyLeaveApi + "/leave/applyLeave";
        ResponseEntity<String> applyLeaveResp = restTemplate.getForEntity(applyLeaveApi, String.class);
        String resp = applyLeaveResp.getBody();
        model.addAttribute("applyLeaveResp", resp);


        return "index.vue2";
    }
    
    @PutMapping("/updateLeave")
    public String updateLeave(Model model)
    {        
        ServiceInstance ss = cc.choose("lms-service");
        String updateLeaveApi = ss.getUri().toString();
        updateLeaveApi = updateLeaveApi + "/leave/updateLeave";
        ResponseEntity<String> updateLeaveResp = restTemplate.getForEntity(updateLeaveApi, String.class);
        String resp = updateLeaveResp.getBody();
        model.addAttribute("updateLeaveResp", resp);


        return "index.vue3";
    }
    
}

@Data
class LeaveBalanceDTO
{
    int id;
    int empId;
   
}
