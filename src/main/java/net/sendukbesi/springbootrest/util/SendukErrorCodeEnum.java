package net.sendukbesi.springbootrest.util;

public enum SendukErrorCodeEnum {
	SENDUK001(200, "Successful"),

	SENDUK002(400, "Bad Request"),
	SENDUK003(400, "Missing Mandatory Field {0}"),

	SENDUK004(401, "Unauthorized Access"),

	SENDUK005(404, "No Record Found"),

	SENDUK006(408, "Request timed out connecting to BACnet"),

	SENDUK007(409, "Record already exists"),

	SENDUK008(500, "Failed to create record."),
	SENDUK009(500, "Failed to update record."),
	SENDUK010(500, "Failed to delete record."),
	SENDUK011(500, "Failed to retrieve record."),

	SENDUK012(503, "Service Unreachable"),
	SENDUK013(503, "System unavailable. Please contact administrator."),;

	private final int code;

	private final String message;


	SendukErrorCodeEnum(int code, String message) {
		this.code = code;
		this.message = message;
	}


	public static SendukErrorCodeEnum findByName(String name) {
		for (SendukErrorCodeEnum v : SendukErrorCodeEnum.values()) {
			if (v.name().equals(name)) {
				return v;
			}
		}

		return null;
	}


	public static int findInternalCode(String name) {
		for (SendukErrorCodeEnum v : SendukErrorCodeEnum.values()) {
			if (v.name().equals(name)) {
				return v.getCode();
			}
		}

		return 0;
	}


	public String getMessage() {
		return message;
	}


	public int getCode() {
		return code;
	}

}
