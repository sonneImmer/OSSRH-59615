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
 * @version 1.0
 */
public class AssetParams {
	String name;
	boolean open;

	/**
	 * @param name
	 * @param open
	 */
	public AssetParams(String name, boolean open) {
		super();
		this.name = name;
		this.open = open;
	}

	public void isFilled() throws ShellChainException {
		ShellChainTestParameter.isNotNullOrEmpty("name", getName());
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
	 * @return the open
	 */
	public boolean isOpen() {
		return open;
	}

	/**
	 * @param open
	 *            the open to set
	 */
	public void setOpen(boolean open) {
		this.open = open;
	}

}
