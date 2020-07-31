/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * ShellChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/ShellChainJavaAPI/blob/master/LICENSE
 *
 */
package com.ustb.shellchain.command;

import com.ustb.shellchain.command.builders.QueryBuilderKey;

/**
 * @author Ub - H. MARTEAU
 * @version 3.0
 */
public class KeyCommand extends QueryBuilderKey {
	public KeyCommand(String ip, String port, String login, String password) {
		initialize(ip, port, login, password);
	}

	public Object getPrivkey(String privkey) throws ShellChainException {
		return executeDumpPrivkey(privkey);
	}
	
	public Object importPrivkey(String privkey) throws ShellChainException {
		return executeImportPrivkey(privkey);
	}

}
