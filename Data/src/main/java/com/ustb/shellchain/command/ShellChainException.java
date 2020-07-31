/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * ShellChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/ShellChainJavaAPI/blob/master/LICENSE
 *
 */
package com.ustb.shellchain.command;

/**
 * @author Ub - H. MARTEAU
 * @version 4.2
 */
public class ShellChainException extends Exception {

	private String object;
	private String reason;

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 2412952380749244614L;

	public ShellChainException(String excep_object, String excep_reason) {
		object = excep_object;
		reason = excep_reason;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ShellChainException [\r\n" + "                      object=" + object + ",\r\n"
				+ "                      reason=" + reason + ",\r\n" + "                      message=" + getMessage()
				+ ",\r\n" + "                      cause=" + getCause() + "\r\n]";
	}

	public String toShortString() {
		return "ShellChainException [\r\n" + "                      object=" + object + ",\r\n"
				+ "                      reason=" + reason + "\r\n]";
	}

	/**
	 * @return the object
	 */
	public String getObject() {
		return object;
	}

	/**
	 * @param object
	 *            the object to set
	 */
	public void setObject(String object) {
		this.object = object;
	}

	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @param reason
	 *            the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	public Integer getChainErrorCode() {
		String code[] = object.split(":");
		if(code.length == 2) {
			return (int)(double)Double.parseDouble(code[1]);
		}
		return null;
	}

}
