package api.ecommerce.grupo3.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler{

    //E-MAIL. Gerenciar Exceções
    @ExceptionHandler(EmailException.class)
    protected ResponseEntity<Object> emailExceptionHandler(EmailException ex) {
        return ResponseEntity.unprocessableEntity().body(ex.getMessage());
    }

    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
        List<String> erros = new ArrayList<String>();
        for (FieldError erro : ex.getBindingResult().getFieldErrors()) {
            erros.add(erro.getField() + ": " + erro.getDefaultMessage());
        }

        ErroResposta erroResposta = new ErroResposta(status.value(), "Existem campos inválidos. Confira o preenchimento. ", LocalDateTime.now(), erros);

        return super.handleExceptionInternal(ex, erroResposta, headers, status, request);
    }
}