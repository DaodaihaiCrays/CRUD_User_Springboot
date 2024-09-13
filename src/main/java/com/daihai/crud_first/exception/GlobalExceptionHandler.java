package com.daihai.crud_first.exception;


import com.daihai.crud_first.model.ApiRespone;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = RuntimeException.class)
    ResponseEntity<ApiRespone> handlingRuntimeException(RuntimeException exception) {
        ApiRespone apiRespone = new ApiRespone();

        apiRespone.setCode(400);
        apiRespone.setMessage(exception.getMessage());

        return ResponseEntity.badRequest().body(apiRespone);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiRespone> handlingValidation(MethodArgumentNotValidException exception) {
        ApiRespone apiRespone = new ApiRespone();

        apiRespone.setCode(400);
        apiRespone.setMessage(exception.getFieldError().getDefaultMessage());

        return ResponseEntity.badRequest().body(apiRespone);
    }

    @ExceptionHandler(value = Exception.class)
    ResponseEntity<ApiRespone> handlingGenericException(Exception exception) {
        ApiRespone apiRespone = new ApiRespone();

        apiRespone.setCode(400);
        apiRespone.setMessage("Error when handling process");

        return ResponseEntity.badRequest().body(apiRespone);
    }
}
