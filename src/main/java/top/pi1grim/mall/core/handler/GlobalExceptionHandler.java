package top.pi1grim.mall.core.handler;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.pi1grim.mall.exception.BaseException;
import top.pi1grim.mall.common.response.Response;

@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<Response> handler(BaseException exception, HttpServletRequest request) {
        Response response = Response.error(exception, request.getRequestURI());
        log.warn("Exception catch!", exception);
        return new ResponseEntity<>(response, new HttpHeaders(), exception.getErrorCode().getStatus());
    }
}
