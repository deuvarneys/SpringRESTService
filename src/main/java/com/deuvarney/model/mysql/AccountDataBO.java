package com.deuvarney.model.mysql;



public interface AccountDataBO {
	


		public String getFirstName(); 

		public void setFirstName(String firstName);
		
		public String getLastName();

		public void setLastName(String lastName);
		
		public long getRegDate();

		public void setRegDate(long regDate);
		


		

//		@NotNull
//		@DateTimeFormat(pattern="dd/MM/yyyy") 
//		@Column(name = "JOINING_DATE", nullable = false)
//		@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
//		private LocalDate joiningDate;

//		@NotNull
//		@Digits(integer=8, fraction=2)
//		@Column(name = "SALARY", nullable = false)
//		private BigDecimal salary;
//		
//		@NotEmpty
//		@Column(name = "SSN", unique=true, nullable = false)
//		private String ssn;
//
//		public int getId() {
//			return id;
//		}
//
//		public void setId(int id) {
//			this.id = id;
//		}
//
//		public String getName() {
//			return name;
//		}
//
//		public void setName(String name) {
//			this.name = name;
//		}
//
//		public LocalDate getJoiningDate() {
//			return joiningDate;
//		}
//
//		public void setJoiningDate(LocalDate joiningDate) {
//			this.joiningDate = joiningDate;
//		}
//
//		public BigDecimal getSalary() {
//			return salary;
//		}
//
//		public void setSalary(BigDecimal salary) {
//			this.salary = salary;
//		}


}
