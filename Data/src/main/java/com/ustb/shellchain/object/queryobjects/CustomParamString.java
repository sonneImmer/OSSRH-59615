/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * ShellChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/ShellChainJavaAPI/blob/master/LICENSE
 *
 */
package com.ustb.shellchain.object.queryobjects;

import com.ustb.shellchain.command.ShellChainException;
import com.ustb.shellchain.command.tools.ShellChainTestParameter;

/**
 * @author Ub - H. MARTEAU
 * @version 1.1
 */
public class CustomParamString {
	String name;
	String value;

	public boolean isFilled() throws ShellChainException {
		ShellChainTestParameter.isNotNullOrEmpty("name", getName());
		return true;
	}

	/**
	 * 
	 */
	public CustomParamString() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @param value
	 */
	public CustomParamString(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
