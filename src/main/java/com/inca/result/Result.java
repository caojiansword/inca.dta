package com.inca.result;

public class Result<T> {
	private Integer code;
	private String message;
	private T result;
	public static <T> Result<T> success(T result){
		return new Result<T>(result,CodeMsg.SUCCESS);
	}
	public static <T> Result<T> error(CodeMsg cm){
		return new Result<T>(cm);
	} 
	private Result(T result,CodeMsg cm) {
		if(cm != null) {
			this.code=cm.getCode();
			this.message = cm.getMessage();
		}
		this.result = result;
	}
	public Result(CodeMsg cm) {
		if(cm != null) {
			this.code = cm.getCode();
			this.message = cm.getMessage();
			
		}
	}
	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
	public T getResult() {
		return result;
	}

	
	
}
