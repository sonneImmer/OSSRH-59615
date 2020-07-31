package com.ustb.shellchain.command;

import com.ustb.util.ErrorCode;

/**
 * Created by admin on 2018/7/6 0006.
 */
public class ShellChainWebException extends Exception {
    private static final long serialVersionUID = 8317821342200239484L;
    private ErrorCode code;

    public ShellChainWebException(ErrorCode code) {
        this.code = code;
    }

    public ErrorCode getCode() {
        return code;
    }

    public void setCode(ErrorCode code) {
        this.code = code;
    }
    /*
 * (non-Javadoc)
 *
 * @see java.lang.Object#toString()
 */
    @Override
    public String toString() {
        return "ShellChainException [\r\n" + "                      code=" + this.code.getValue() + ",\r\n"
                + "                      reason=" + this.code.getDesc() + ",\r\n" + "                      message=" + getMessage()
                + ",\r\n" + "                      cause=" + getCause() + "\r\n]";
    }

}
