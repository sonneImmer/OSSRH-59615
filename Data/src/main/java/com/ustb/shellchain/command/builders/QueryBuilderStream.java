/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * ShellChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/ShellChainJavaAPI/blob/master/LICENSE
 *
 */
package com.ustb.shellchain.command.builders;

import com.ustb.shellchain.command.ShellChainException;
import com.ustb.shellchain.command.tools.ShellChainTestParameter;

/**
 * @author Ub - H. MARTEAU & Jagrut KOSTI
 * @version 3.1
 */
public class QueryBuilderStream extends QueryBuilderCommon {
	/**
	 * create stream "stream-name" open ( custom-fields )
	 * 
	 * Creates stream
	 * 
	 * 
	 * Arguments: 1. entity-type (string, required) The only possible value: stream
	 * 2. "stream-name" (string, required) Stream name, if not "" should be unique.
	 * 3. open (boolean, required) Allow anyone to publish in this stream 4
	 * custom-fields (object, optional) a json object with custom fields {
	 * "param-name": "param-value" (strings, required) The key is the parameter
	 * name, the value is parameter value ,... }
	 * 
	 * Result: "transactionid" (string) The transaction id.
	 * 
	 * @param streamName
	 * @param open
	 * @return TxId
	 * @throws ShellChainException
	 */
	protected Object executeCreate(String streamName, boolean open) throws ShellChainException {
		ShellChainTestParameter.isNotNullOrEmpty("streamName", streamName);

		return execute(CommandEnum.CREATE, "stream", streamName, open);
	}

	/**
	 * {@link #executeCreate(String, boolean)} with control over the from-address
	 * used to create the stream
	 * 
	 * @param addressFrom
	 *            (String) The from-address used to create the stream
	 * @param streamName
	 *            (String) The name of the stream to create
	 * @param open
	 *            (Boolean) True if the stream is open, else false
	 * @return (String) The transaction id
	 * @throws ShellChainException
	 */
	protected Object executeCreateFrom(String addressFrom, String streamName, boolean open) throws ShellChainException {
		ShellChainTestParameter.isNotNullOrEmpty("streamName", streamName);
		ShellChainTestParameter.isNotNullOrEmpty("addressFrom", addressFrom);

		return execute(CommandEnum.CREATEFROM, addressFrom, "stream", streamName, open);
	}

	/**
	 * 
	 * liststreamkeys "stream-identifier" ( key(s) verbose count start
	 * local-ordering )
	 * 
	 * Returns stream keys.
	 * 
	 * Arguments: 1. "stream-identifier"(string, required) Stream identifier - one
	 * of the following: stream txid, stream reference, stream name. 2. "key"
	 * (string, optional, default=*) Stream key or 2. key(s) (array, optional) A
	 * json array of stream keys 3. verbose (boolean, optional, default=false) If
	 * true, returns extended information about key 4. count (number, optional,
	 * default=INT_MAX - all) The number of items to display 5. start (number,
	 * optional, default=-count - last) Start from specific item, 0 based, if
	 * negative - from the end 6. local-ordering (boolean, optional, default=false)
	 * If true, items appear in the order they were processed by the wallet, if
	 * false - in the order they apppear in blockchain
	 * 
	 * Result: "stream-keys" (array) List of stream keys.
	 * 
	 * @param streamName
	 * @param key
	 * @param verbose
	 * @param count
	 * @param start
	 * @return
	 * @throws ShellChainException
	 */
	protected Object executeListStreams(String streamName, boolean verbose, int count, int start)
			throws ShellChainException {
		ShellChainTestParameter.isNotNullOrEmpty("streamName", streamName);
		ShellChainTestParameter.valueIsPositive("count", count);

		return execute(CommandEnum.LISTSTREAMS, streamName, verbose, count, start);
	}

	/**
	 * {@link #executeListStreams(String, boolean, int, int)} without start
	 * 
	 * @param streamName
	 * @param verbose
	 * @param count
	 * @param start
	 * @return
	 * @throws ShellChainException
	 */
	protected Object executeListStreams(String streamName, boolean verbose, int count) throws ShellChainException {
		ShellChainTestParameter.isNotNullOrEmpty("streamName", streamName);
		ShellChainTestParameter.valueIsPositive("count", count);

		return execute(CommandEnum.LISTSTREAMS, streamName, verbose, count);

	}

	/**
	 * 
	 * liststreamkeys "stream-identifier" ( key(s) verbose count start
	 * local-ordering )
	 * 
	 * Returns stream keys.
	 * 
	 * Arguments: 1. "stream-identifier"(string, required) Stream identifier - one
	 * of the following: stream txid, stream reference, stream name. 2. "key"
	 * (string, optional, default=*) Stream key or 2. key(s) (array, optional) A
	 * json array of stream keys 3. verbose (boolean, optional, default=false) If
	 * true, returns extended information about key 4. count (number, optional,
	 * default=INT_MAX - all) The number of items to display 5. start (number,
	 * optional, default=-count - last) Start from specific item, 0 based, if
	 * negative - from the end 6. local-ordering (boolean, optional, default=false)
	 * If true, items appear in the order they were processed by the wallet, if
	 * false - in the order they apppear in blockchain
	 * 
	 * Result: "stream-keys" (array) List of stream keys.
	 * 
	 * @param streamName
	 * @param key
	 * @param verbose
	 * @param count
	 * @param start
	 * @return
	 * @throws ShellChainException
	 */
	protected Object executeListStreamKeys(String streamName, String key, boolean verbose, int count, int start)
			throws ShellChainException {
		ShellChainTestParameter.isNotNullOrEmpty("streamName", streamName);
		ShellChainTestParameter.isNotNullOrEmpty("key", key);
		ShellChainTestParameter.valueIsPositive("count", count);

		return execute(CommandEnum.LISTSTREAMKEYS, streamName, key, verbose, count, start);
	}

	/**
	 * 
	 * {@link executeListStreamKeys(String streamName, String key, boolean verbose,
	 * int count, int start)} without start
	 * 
	 * @param streamName
	 * @param key
	 * @param verbose
	 * @param count
	 * @return
	 * @throws ShellChainException
	 */
	protected Object executeListStreamKeys(String streamName, String key, boolean verbose, int count)
			throws ShellChainException {
		ShellChainTestParameter.isNotNullOrEmpty("streamName", streamName);
		ShellChainTestParameter.isNotNullOrEmpty("key", key);
		ShellChainTestParameter.valueIsPositive("count", count);

		return execute(CommandEnum.LISTSTREAMKEYS, streamName, key, verbose, count);
	}

	/**
	 * liststreamkeyitems "stream-identifier" "key" ( verbose count start
	 * local-ordering )
	 * 
	 * Returns stream items for specific key.
	 * 
	 * Arguments: 1. "stream-identifier"(string, required) Stream identifier - one
	 * of the following: stream txid, stream reference, stream name. 2. "key"
	 * (string, required) Stream key 3. verbose (boolean, optional, default=false)
	 * If true, returns information about item transaction 4. count (number,
	 * optional, default=10) The number of items to display 5. start (number,
	 * optional, default=-count - last) Start from specific item, 0 based, if
	 * negative - from the end 6. local-ordering (boolean, optional, default=false)
	 * If true, items appear in the order they were processed by the wallet, if
	 * false - in the order they appear in blockchain
	 * 
	 * Result: "stream-items" (array) List of stream items for specific key.
	 * 
	 * @param streamName
	 * @param key
	 * @param verbose
	 * @param count
	 * @param start
	 * @return
	 * @throws ShellChainException
	 */
	protected Object executeListStreamKeyItems(String streamName, String key, boolean verbose, int count, int start)
			throws ShellChainException {
		ShellChainTestParameter.isNotNullOrEmpty("streamName", streamName);
		ShellChainTestParameter.isNotNullOrEmpty("key", key);
		ShellChainTestParameter.valueIsPositive("count", count);

		return execute(CommandEnum.LISTSTREAMKEYITEMS, streamName, key, verbose, count, start);
	}

	/**
	 * liststreamkeyitems "stream-identifier" "key" ( verbose count start
	 * local-ordering )
	 * 
	 * Returns stream items for specific key.
	 * 
	 * Arguments: 1. "stream-identifier"(string, required) Stream identifier - one
	 * of the following: stream txid, stream reference, stream name. 2. "key"
	 * (string, required) Stream key 3. verbose (boolean, optional, default=false)
	 * If true, returns information about item transaction 4. count (number,
	 * optional, default=10) The number of items to display 5. start (number,
	 * optional, default=-count - last) Start from specific item, 0 based, if
	 * negative - from the end 6. local-ordering (boolean, optional, default=false)
	 * If true, items appear in the order they were processed by the wallet, if
	 * false - in the order they appear in blockchain
	 * 
	 * Result: "stream-items" (array) List of stream items for specific key.
	 * 
	 * @param streamName
	 * @param key
	 * @param verbose
	 * @param count
	 * @param start
	 * @return
	 * @throws ShellChainException
	 */
	protected Object executeListStreamKeyItems(String streamName, String key, boolean verbose, int count)
			throws ShellChainException {
		ShellChainTestParameter.isNotNullOrEmpty("streamName", streamName);
		ShellChainTestParameter.isNotNullOrEmpty("key", key);
		ShellChainTestParameter.valueIsPositive("count", count);

		return execute(CommandEnum.LISTSTREAMKEYITEMS, streamName, key, verbose, count);
	}

	/**
	 * publish "stream-identifier" "key" data-hex
	 * 
	 * Publishes stream item
	 * 
	 * 
	 * Arguments: 1. "stream-identifier" (string, required) Stream identifier - one
	 * of the following: stream txid, stream reference, stream name. 2. "key"
	 * (string, required) Item key 3. data-hex (string, required) Item data hex
	 * string
	 * 
	 * Result: "transactionid" (string) The transaction id.
	 * 
	 * @param streamName
	 * @param key
	 * @param dataHex
	 *            : data in hexadecimal in string format
	 * @return
	 * @throws ShellChainException
	 */
	protected Object executePublish(String streamName, String key, String dataHex) throws ShellChainException {
		ShellChainTestParameter.isNotNullOrEmpty("streamName", streamName);
		ShellChainTestParameter.isNotNullOrEmpty("key", key);
		ShellChainTestParameter.isNotNullOrEmpty("dataHex", dataHex);

		return execute(CommandEnum.PUBLISH, streamName, key, dataHex);
	}

	/**
	 * {@link #executePublish(String, String, String)} with control over the
	 * from-address used to publish
	 * 
	 * @param addressFrom
	 *            (String) The from-address used to publish
	 * @param streamName
	 *            (String) The name of the stream
	 * @param key
	 *            (String) The key of the item
	 * @param dataHex
	 *            (String) Data in hexadecimal
	 * @return (String) The transaction id
	 * @throws ShellChainException
	 */
	protected Object executePublishFrom(String addressFrom ,String streamName, String key, String dataHex) throws ShellChainException {
		ShellChainTestParameter.isNotNullOrEmpty("addressFrom", addressFrom);
		ShellChainTestParameter.isNotNullOrEmpty("streamName", streamName);
		ShellChainTestParameter.isNotNullOrEmpty("key", key);
		ShellChainTestParameter.isNotNullOrEmpty("dataHex", dataHex);

		return execute(CommandEnum.PUBLISHFROM, addressFrom, streamName, key, dataHex);
	}

	/**
	 * subscribe entity-identifier(s) ( rescan )
	 * 
	 * Subscribes to the stream.
	 * 
	 * Arguments: 1. "stream-identifier" (string, required) Stream identifier - one
	 * of the following: stream txid, stream reference, stream name. or 1.
	 * "asset-identifier" (string, required) Asset identifier - one of the
	 * following: asset txid, asset reference, asset name. or 1.
	 * entity-identifier(s) (array, optional) A json array of stream or asset
	 * identifiers 2. rescan (boolean, optional, default=true) Rescan the wallet for
	 * transactions
	 * 
	 * Note: This call can take minutes to complete if rescan is true.
	 * 
	 * @param streamName
	 * @throws ShellChainException
	 */
	protected void executeSubscribe(String streamName) throws ShellChainException {
		ShellChainTestParameter.isNotNullOrEmpty("streamName", streamName);

		execute(CommandEnum.SUBSCRIBE, streamName);
	}

	/**
	 * unsubscribe entity-identifier(s)
	 * 
	 * Unsubscribes from the stream.
	 * 
	 * Arguments: 1. "stream-identifier" (string, required) Stream identifier - one
	 * of the following: stream txid, stream reference, stream name. or 1.
	 * "asset-identifier" (string, required) Asset identifier - one of the
	 * following: asset txid, asset reference, asset name. or 1.
	 * entity-identifier(s) (array, optional) A json array of stream or asset
	 * identifiers
	 * 
	 * @param streamName
	 * @throws ShellChainException
	 */
	protected void executeUnsubscribe(String streamName) throws ShellChainException {
		ShellChainTestParameter.isNotNullOrEmpty("streamName", streamName);

		execute(CommandEnum.UNSUBSCRIBE, streamName);
	}


	/**
	 * Retrieves a specific item with txid from stream, passed as a stream name,
	 * ref or creation txid, to which the node must be subscribed. Set verbose
	 * to true for additional information about the item’s transaction.
	 * If an item’s data is larger than the maxshowndata runtime parameter,
	 * it will be returned as an object whose fields can be used with gettxoutdata.
	 * @param streamName
	 * @param txid
	 * @param verbose
	 * @throws ShellChainException
	 */
	protected Object executeGetStreamItem(String streamName,String txid,boolean verbose) throws ShellChainException {
		ShellChainTestParameter.isNotNullOrEmpty("streamName", streamName);
		ShellChainTestParameter.isNotNullOrEmpty("txid", txid);

		return execute(CommandEnum.GETSTREAMITEM, streamName,txid,verbose);
	}


}