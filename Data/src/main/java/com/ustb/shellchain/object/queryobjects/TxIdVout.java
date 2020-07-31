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
public class TxIdVout {
	String txId;
	int vOut;

	public void isFilled() throws ShellChainException {
		ShellChainTestParameter.isNotNullOrEmpty("txId", txId);
		ShellChainTestParameter.valueIsNotNegative("vOut", vOut);
	}

	/**
	 * @return the txId
	 */
	public String getTxId() {
		return txId;
	}
	/**
	 * @param txId the txId to set
	 */
	public void setTxId(String txId) {
		this.txId = txId;
	}
	/**
	 * @return the vOut
	 */
	public int getvOut() {
		return vOut;
	}
	/**
	 * @param vOut the vOut to set
	 */
	public void setvOut(int vOut) {
		this.vOut = vOut;
	}


}
