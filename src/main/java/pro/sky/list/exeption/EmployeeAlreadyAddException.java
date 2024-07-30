package pro.sky.list.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeAlreadyAddException extends RuntimeException{

  public EmployeeAlreadyAddException() {
  }

  public EmployeeAlreadyAddException(String message) {

    super(message);
  }

  public EmployeeAlreadyAddException(String message, Throwable cause) {

    super(message, cause);
  }

  public EmployeeAlreadyAddException(Throwable cause) {

    super(cause);
  }

  public EmployeeAlreadyAddException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
