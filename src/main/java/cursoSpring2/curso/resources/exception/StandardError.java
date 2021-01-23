package cursoSpring2.curso.resources.exception;

import java.io.Serializable;

public class StandardError implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer satus;
	private String msg;
	private Long timeStamp;
	
	public StandardError() {
	}

	public StandardError(Integer satus, String msg, Long timeStamp) {
		super();
		this.satus = satus;
		this.msg = msg;
		this.timeStamp = timeStamp;
	}

	public Integer getSatus() {
		return satus;
	}

	public void setSatus(Integer satus) {
		this.satus = satus;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	

	
}
