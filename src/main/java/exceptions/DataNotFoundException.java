/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author mpanagrosso
 */
public class DataNotFoundException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 3709798871231571953L;
    private String msg;

    public DataNotFoundException() {
        super();
    }

    public DataNotFoundException(String msg) {
        super();
        this.msg = msg;
    }

    public DataNotFoundException(Throwable e) {
        super(e);
    }

    public DataNotFoundException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public DataNotFoundException(final DataNotFoundException itself) {
        super(itself.getMessage());
        this.msg = itself.msg;
    }

    public String getMsg() {
        return this.msg;
    }

    @Override
    public StackTraceElement[] getStackTrace() {
        return super.getStackTrace();
    }

    @Override
    public String toString() {
        return this.getMessage();
    }
}
