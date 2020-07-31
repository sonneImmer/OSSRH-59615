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
import com.google.gson.internal.LinkedTreeMap;
import com.ustb.shellchain.object.TxOut;

/**
 * @author Ub - H. MARTEAU
 * @version 1.0
 */
public class TxOutFormatter {
	public final static TxOut formatTxOut(Object objectTxOut) {
		TxOut txOut = new TxOut();

		if (objectTxOut != null && LinkedTreeMap.class.isInstance(objectTxOut)) {
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();

			String jsonValue = gson.toJson(objectTxOut);
			txOut = gson.fromJson(jsonValue, TxOut.class);
		}

		return txOut;
	}

}
