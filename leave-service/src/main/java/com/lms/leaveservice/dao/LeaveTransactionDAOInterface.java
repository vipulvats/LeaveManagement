package com.lms.leaveservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.leaveservice.model.LeaveTransaction;

public interface LeaveTransactionDAOInterface extends JpaRepository<LeaveTransaction, Long>{

	
	/*List<LeaveTransaction> findAllLeaves();
	LeaveTransaction saveAndFlush(LeaveTransaction leave); 
	*/
}
