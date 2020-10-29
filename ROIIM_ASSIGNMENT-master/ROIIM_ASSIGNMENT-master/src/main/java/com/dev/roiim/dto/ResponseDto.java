package com.dev.roiim.dto;

import org.springframework.http.HttpStatus;

public class ResponseDto<T> {

    private T data;

    private HttpStatus status;

    public ResponseDto(HttpStatus status, T data){
        this.data = data;
        this.status = status;
    }

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
    
    
    
}