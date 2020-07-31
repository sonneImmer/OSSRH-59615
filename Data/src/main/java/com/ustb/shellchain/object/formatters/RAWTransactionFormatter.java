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
import com.ustb.shellchain.object.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ub - H. MARTEAU
 * @version 3.0
 */
public class RAWTransactionFormatter {
	public final static TransactionRAW formatTransactionRAW(Object objectTransactionRAW) {
		TransactionRAW transactionRAW = new TransactionRAW();

		if (objectTransactionRAW != null && LinkedTreeMap.class.isInstance(objectTransactionRAW)) {
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();

			String jsonValue = gson.toJson(objectTransactionRAW);
			transactionRAW = gson.fromJson(jsonValue, TransactionRAW.class);
		}

		return transactionRAW;
	}

	public final static TransactionRawDetail formatTransactionRawDetail(Object objectTransactionRAW) {
		TransactionRawDetail transactionRAW = new TransactionRawDetail();

		if (objectTransactionRAW != null && LinkedTreeMap.class.isInstance(objectTransactionRAW)) {
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();

			String jsonValue = gson.toJson(objectTransactionRAW);
			transactionRAW = gson.fromJson(jsonValue, TransactionRawDetail.class);
		}
		return transactionRAW;
	}

	public final static TransactionRawDetail formatTransactionTypes(Object objectTransactionRAW) {

		if (objectTransactionRAW != null && LinkedTreeMap.class.isInstance(objectTransactionRAW)) {
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();

			String jsonValue = gson.toJson(objectTransactionRAW);
			if(((LinkedTreeMap)objectTransactionRAW).get("account") != null){
				TransactionSubject transactionRAW = new TransactionSubject();
				transactionRAW = gson.fromJson(jsonValue, TransactionSubject.class);
				return transactionRAW;
			} else if(((LinkedTreeMap)objectTransactionRAW).get("video_hash") != null) {
				TransactionObject transactionRAW = new TransactionObject();
				transactionRAW = gson.fromJson(jsonValue, TransactionObject.class);
				return transactionRAW;
			} else {
				TransactionRawDetail transactionRAW = new TransactionRawDetail();
				transactionRAW = gson.fromJson(jsonValue, TransactionRawDetail.class);
				return transactionRAW;
			}
		}
		return new TransactionRawDetail();
	}

	public final static Map<String,Object> formatTransactionMap(Object objectTransactionRAW) {
		Map<String,Object> transactionRAW = new HashMap<>();

		if (objectTransactionRAW != null && LinkedTreeMap.class.isInstance(objectTransactionRAW)) {
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();

			String jsonValue = gson.toJson(objectTransactionRAW);
			transactionRAW = gson.fromJson(jsonValue, HashMap.class);
		}
		return transactionRAW;
	}

	public final static SignedTransactionRAW formatSignedTransactionRAW(Object objectSignedTransactionRAW) {
		SignedTransactionRAW signedTransactionRAW = new SignedTransactionRAW();

		if (objectSignedTransactionRAW != null && LinkedTreeMap.class.isInstance(objectSignedTransactionRAW)) {
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();

			String jsonValue = gson.toJson(objectSignedTransactionRAW);
			signedTransactionRAW = gson.fromJson(jsonValue, SignedTransactionRAW.class);
		}

		return signedTransactionRAW;
	}

}
