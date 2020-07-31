/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * ShellChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/ShellChainJavaAPI/blob/master/LICENSE
 *
 */
package com.ustb.shellchain.object.formatters;

import com.ustb.shellchain.command.ShellChainException;
import com.ustb.shellchain.object.queryobjects.CustomParamString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ub - H. MARTEAU
 * @version 4.2
 */
public class CustomParamFormatter extends GsonFormatters {
	public final static Map<String, String> formatCustomParamString(List<CustomParamString> customParam)
			throws ShellChainException {
		Map<String, String> mapFormat = new HashMap<String, String>();

		if (customParam != null) {
			for (CustomParamString param : customParam) {
				if (param.isFilled()) {
					mapFormat.put(param.getName(), param.getValue());
				}
			}
		}

		return mapFormat;
	}
}
