package com.christian.gen.common.exception;


import java.sql.SQLIntegrityConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class GlobalExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * <p>
     * 自定义 REST 业务异常
     * <p>
     *
     * @param e 异常类型
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> handleBadRequest(Exception e) {
    	
        /*
         * url异常
         */
        if(e instanceof HttpRequestMethodNotSupportedException) {
        	//return ResponseBo.error("调用方式或路径错误");
        	return new ResponseEntity<String>("调用方式或路径错误",HttpStatus.METHOD_NOT_ALLOWED);
        }
        
        /*
         * 数据库唯一约束异常
         */
        if(e instanceof SQLIntegrityConstraintViolationException) {
        	//return ResponseBo.error("违反唯一约束条件");
        	return new ResponseEntity<String>("违反唯一约束条件",HttpStatus.METHOD_NOT_ALLOWED);
        }
        
        /*
         * Content type类型异常
         */
        if(e instanceof HttpMediaTypeNotSupportedException) {
        	//return ResponseBo.error("Content type类型不支持");
        	return new ResponseEntity<String>("Content type类型不支持",HttpStatus.UNSUPPORTED_MEDIA_TYPE);
        }
        
        /*
         * 数据库连接异常
         */
        if(e instanceof java.net.ConnectException) {
        	//return ResponseBo.error("数据库连接超时");
        	return new ResponseEntity<String>("数据库连接超时",HttpStatus.REQUEST_TIMEOUT);
        }
        
        /*
         * 数据异常
         */
        if(e instanceof IllegalAccessException) {
        	//return ResponseBo.error("是否最新版本号？");
        	return new ResponseEntity<String>("是否最新版本号？",HttpStatus.NOT_ACCEPTABLE);
        }
        
        /*
         * sql异常
         */
        if(e instanceof java.sql.SQLException) {
        	return new ResponseEntity<String>("sql异常",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        /*
         * sql异常
         */
        if(e instanceof org.springframework.jdbc.UncategorizedSQLException) {
        	return new ResponseEntity<String>("sql异常",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        /*
         * sql异常
         */
        if(e instanceof RuntimeException) {
        	return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

        /**
         * 系统内部异常，打印异常栈
         */
        //return ResponseBo.error(e.getMessage());
        return new ResponseEntity<String>("系统异常",HttpStatus.BAD_GATEWAY);
    }

}
