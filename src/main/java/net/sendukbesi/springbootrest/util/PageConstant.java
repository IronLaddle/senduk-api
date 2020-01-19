package net.sendukbesi.springbootrest.util;

public class PageConstant {
	
	/*
	 * private PageConstant() { throw new
	 * IllegalStateException("Page Constant class"); }
	 */
	
	public static final String API_VERSION = "/api/v1";	
	
	public static final String ALL_EMPLOYEES = API_VERSION + "/employees";
	public static final String GET_EMPLOYEES_ID = API_VERSION + "/employees/{0}";
	public static final String CREATE_EMPLOYEES = API_VERSION + "/employees";
	public static final String UPDATE_EMPLOYEES = API_VERSION + "/employees/{0}";
	public static final String DELETE_EMPLOYEES = API_VERSION + "/employees/{0}";
}
