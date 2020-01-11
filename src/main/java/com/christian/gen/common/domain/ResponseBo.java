package com.christian.gen.common.domain;

import java.util.HashMap;

public class ResponseBo extends HashMap<String, Object> {

	private static final long serialVersionUID = -8713837118340960775L;

	public ResponseBo() {
		put("code", ResultConstant.SUCCESS.getCode());
		put("msg", ResultConstant.SUCCESS.getMsg());
	}

	public static ResponseBo error() {
		ResponseBo ResponseBo = new ResponseBo();
		ResponseBo.put("code", ResultConstant.ERROR.getCode());
		ResponseBo.put("msg", ResultConstant.ERROR.getMsg());
		return ResponseBo;
	}
	
	public static ResponseBo error(Object msg) {
		ResponseBo ResponseBo = new ResponseBo();
		ResponseBo.put("code", ResultConstant.ERROR.getCode());
		ResponseBo.put("msg", msg);
		return ResponseBo;
	}

	public static ResponseBo ok(Object msg) {
		ResponseBo ResponseBo = new ResponseBo();
		ResponseBo.put("code", ResultConstant.SUCCESS.getCode());
		ResponseBo.put("msg", msg);
		return ResponseBo;
	}
	
	public static ResponseBo ok(Object msg,Object data) {
		ResponseBo ResponseBo = new ResponseBo();
		ResponseBo.put("code", ResultConstant.SUCCESS.getCode());
		ResponseBo.put("msg", msg == null ? "操作成功" : msg);
		ResponseBo.put("data", data);
		return ResponseBo;
	}
	
	public static ResponseBo resp(ResultConstant constant, Object data) {
		ResponseBo ResponseBo = new ResponseBo();
		ResponseBo.put("code", constant.getCode());
		ResponseBo.put("msg", constant.getMsg());
		if(null != data) {
			ResponseBo.put("data", data);
		}
		return ResponseBo;
	}

	public static ResponseBo ok() {
		return new ResponseBo();
	}

	@Override
	public ResponseBo put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}
