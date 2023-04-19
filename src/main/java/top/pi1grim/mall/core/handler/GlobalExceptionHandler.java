package top.pi1grim.mall.core.handler;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.pi1grim.mall.exception.BaseException;
import top.pi1grim.mall.response.Response;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<Response> handler(BaseException exception, HttpServletRequest request) {
        Response response = Response.error(exception, request.getRequestURI());
        return new ResponseEntity<>(response, new HttpHeaders(), exception.getErrorCode().getStatus());
    }
}
