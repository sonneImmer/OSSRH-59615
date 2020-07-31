/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * ShellChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/ShellChainJavaAPI/blob/master/LICENSE
 *
 */
package com.ustb.shellchain.object;

/**
 * @author Ub - H. MARTEAU
 * @version 1.0
 */
public class ScriptSig {
    String asm;
    String hex;

	/**
	 * @return the asm
	 */
	public String getAsm() {
		return asm;
	}
	/**
	 * @param asm the asm to set
	 */
	public void setAsm(String asm) {
		this.asm = asm;
	}
	/**
	 * @return the hex
	 */
	public String getHex() {
		return hex;
	}
	/**
	 * @param hex the hex to set
	 */
	public void setHex(String hex) {
		this.hex = hex;
	}


}
