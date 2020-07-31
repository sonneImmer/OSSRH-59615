/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * ShellChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/ShellChainJavaAPI/blob/master/LICENSE
 *
 */
package com.ustb.shellchain.object.formatters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ustb.shellchain.object.ShellChainInfo;

/**
 * @author Ub - H. MARTEAU
 * @version 1.0
 */
public class ShellChainInfoFormatter {

	public final static ShellChainInfo formatShellChainInfo(String stringShellChainInfo) {
		final Gson gson = new GsonBuilder().create();
		final ShellChainInfo shellChainInfo = gson.fromJson(
				stringShellChainInfo, ShellChainInfo.class);

		return shellChainInfo;
	}

}
