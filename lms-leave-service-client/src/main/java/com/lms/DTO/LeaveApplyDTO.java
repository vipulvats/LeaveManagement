package com.lms.DTO;

import java.time.LocalDate;
import java.time.Period;

public class LeaveApplyDTO {

	public enum Types {
		ANNUAL_LEAVE("AL"), SICK_LEAVE("SL"), MATERNITY_LEAVE("ML"), PATERNITY_LEAVE("PL");

		private final String typeCode;

		Types(String type) {
			this.typeCode = type;
		}

		public String getTypeCode() {
			return this.typeCode;
		}
	}

	public enum Status {
		SUBMITTED, APPROVED, REJECTED, CANCELLED
	}





	private Long id;
	private String emp_id;
	private Types leaveType;
	private Status leaveStatus;
	private LocalDate startDate;
	private LocalDate endDate;
	private LocalDate appliedDate;
	private String reason;
	private Integer duration;

	public LeaveApplyDTO() {
	}

	public LeaveApplyDTO(String emp_id, Types leaveType, LocalDate startDate, LocalDate endDate, Status status, String reason) {
		this.emp_id = emp_id;
		this.leaveType = leaveType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.appliedDate = LocalDate.now();
		this.reason = reason;
		this.leaveStatus = status;
		this.duration = Period.between(startDate, endDate).getDays();
	}

	public String getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}

	public Types getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(Types leaveType) {
		this.leaveType = leaveType;
	}

	public Status getLeaveStatus() {
		return leaveStatus;
	}

	public void setLeaveStatus(Status leaveStatus) {
		this.leaveStatus = leaveStatus;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public LocalDate getAppliedDate() {
		return appliedDate;
	}

	public void setAppliedDate(LocalDate appliedDate) {
		this.appliedDate = appliedDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(LocalDate startDate, LocalDate endDate) {
		this.duration = Period.between(startDate, endDate).getDays();
	}

	@Override
	public String toString() {
		return "Leave [id=" + id + ", emp_id=" + emp_id + ", leaveType=" + leaveType + ", leaveStatus=" + leaveStatus
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", appliedDate=" + appliedDate + ", reason="
				+ reason + ", duration=" + duration + "]";
	}







}