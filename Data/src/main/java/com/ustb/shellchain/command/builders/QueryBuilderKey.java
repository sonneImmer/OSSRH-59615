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
public class QueryBuilderKey extends QueryBuilderCommon {

	protected Object executeDumpPrivkey(String privkey) throws ShellChainException {
		return execute(CommandEnum.DUMPPRIVKEY, privkey);
	}
	
	protected Object executeImportPrivkey(String privkey) throws ShellChainException {
		return execute(CommandEnum.IMPORTPRIVKEY, privkey,"",false);
	}
	
}
