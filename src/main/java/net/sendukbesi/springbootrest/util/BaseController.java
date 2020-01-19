package net.sendukbesi.springbootrest.util;

public abstract class BaseController {
    
    public static final String API_VERSIONS = "/api/v1";	
	
	public static final String ALL_EMPLOYEESS = API_VERSIONS + "/employees";
	public static final String GET_EMPLOYEES_IDS = API_VERSIONS + "/employees/{0}";
	public static final String CREATE_EMPLOYEESS = API_VERSIONS + "/employees";
	public static final String UPDATE_EMPLOYEESS = API_VERSIONS + "/employees/{0}";
	public static final String DELETE_EMPLOYEESS = API_VERSIONS + "/employees/{0}";

}
