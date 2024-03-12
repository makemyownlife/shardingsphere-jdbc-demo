package cn.javayong.shardingjdbc5.spring.common.result;

import java.util.List;

public class ResponseEntity<T> {

    private int code;

    private String message;

    private T data;

    public static final int SUCCESS = 200;

    public static final int FAIL = 400;

    public static final int NO_PERMISSION = 403;

    public static final int ERROR = 500;

    public static final int SIGN_ERROR = 600;

    private ResponseEntity() {
    }

    public static <T> ResponseEntity<T> custom(int code, String message, T data) {
        ResponseEntity<T> responseEntity = new ResponseEntity<>();
        responseEntity.message = message;
        responseEntity.code = code;
        responseEntity.data = data;
        return responseEntity;
    }

    public static <T> ResponseEntity<T> custom(int code, String message) {
        ResponseEntity<T> responseEntity = new ResponseEntity<>();
        responseEntity.message = message;
        responseEntity.code = code;
        return responseEntity;
    }

    public static <T> ResponseEntity<T> custom(int code, T data) {
        ResponseEntity<T> responseEntity = new ResponseEntity<>();
        responseEntity.data = data;
        responseEntity.code = code;
        return responseEntity;
    }

    public static <T> ResponseEntity<T> successResult(T data) {
        ResponseEntity<T> responseEntity = new ResponseEntity<>();
        responseEntity.data = data;
        responseEntity.code = SUCCESS;
        return responseEntity;
    }

    public static <T> ResponseEntity<T> successPageResult(List<T> data, int total) {
        ResponseEntity<T> responseEntity = new ResponseEntity<>();
        responseEntity.data = (T) new ResultPage().setData(data).setTotal(total);
        responseEntity.code = SUCCESS;
        return responseEntity;
    }

    public static <T> ResponseEntity<T> failResult(String message) {
        ResponseEntity<T> responseEntity = new ResponseEntity<>();
        responseEntity.code = FAIL;
        responseEntity.message = message;
        return responseEntity;
    }

    public static <T> ResponseEntity<T> failCustom(String message, T data) {
        ResponseEntity<T> responseEntity = new ResponseEntity<>();
        responseEntity.message = message;
        responseEntity.code = FAIL;
        responseEntity.data = data;
        return responseEntity;
    }

    public static <T> ResponseEntity<T> noPermissionResult(String message) {
        ResponseEntity<T> responseEntity = new ResponseEntity<>();
        responseEntity.code = NO_PERMISSION;
        responseEntity.message = message;
        return responseEntity;
    }

    public static <T> ResponseEntity<T> errorResult(String message) {
        ResponseEntity<T> responseEntity = new ResponseEntity<>();
        responseEntity.code = ERROR;
        responseEntity.message = message;
        return responseEntity;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}

