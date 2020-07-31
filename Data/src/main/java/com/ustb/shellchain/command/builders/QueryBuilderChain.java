/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * ShellChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/ShellChainJavaAPI/blob/master/LICENSE
 *
 */
package com.ustb.shellchain.command.builders;

import com.ustb.shellchain.command.ShellChainException;

/**
 * @author Ub - H. MARTEAU
 * @version 3.0
 */
public class QueryBuilderChain extends QueryBuilderCommon {

	protected Object executeGetInfo() throws ShellChainException {
		return execute(CommandEnum.GETINFO);
	}

	protected Object executeGetPeerInfo() throws ShellChainException{
		return execute(CommandEnum.GETPEERINFO);
	}

	protected Object executeGetBlockChainInfo() throws ShellChainException{
		return execute(CommandEnum.GETBLOCKCHAININFO);
	}
}
