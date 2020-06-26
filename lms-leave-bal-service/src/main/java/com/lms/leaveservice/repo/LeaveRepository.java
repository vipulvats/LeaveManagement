package com.lms.leaveservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.leaveservice.LeaveBalance;

public interface LeaveRepository extends JpaRepository<LeaveBalance, Integer>{


}
