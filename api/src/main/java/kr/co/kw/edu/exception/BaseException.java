package kr.co.kw.edu.exception;

public class BaseException extends RuntimeException {

    public BaseException(){
        super();
    }

    public BaseException(String message){
        super(message);
    }
}
