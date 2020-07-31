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
import com.ustb.shellchain.object.formatters.CustomParamFormatter;
import com.ustb.shellchain.object.queryobjects.AssetParams;
import com.ustb.shellchain.object.queryobjects.CustomParamString;
import jdk.nashorn.tools.Shell;

import java.util.List;
import java.util.Map;

/**
 * @author Ub - H. MARTEAU
 * @version 4.4
 */
public class QueryBuilderIssue extends QueryBuilderCommon {

	/**
	 * getassetbalances ( "account" minconf includeWatchonly includeLocked)
	 * 
	 * If account is not specified, returns the server's total available asset
	 * balances. If account is specified, returns the balances in the account.
	 * Note that the account "" is not the same as leaving the parameter out.
	 * The server total may be different to the balance in the default ""
	 * account.
	 * 
	 * Arguments: 1. "account" (string, optional) The selected account, or "*"
	 * for entire wallet. It may be the default account using "". 2. minconf
	 * (numeric, optional, default=1) Only include transactions confirmed at
	 * least this many times. 3. includeWatchonly (bool, optional,
	 * default=false) Also include balance in watchonly addresses (see
	 * 'importaddress') 4. includeLocked (bool, optional, default=false) Also
	 * take locked outputs into account Results are an array of Objects with
	 * totals and details for each asset.
	 * 
	 * @return
	 * @throws ShellChainException
	 * 
	 */
	protected Object executeGetAssetBalances() throws ShellChainException {
		return execute(CommandEnum.GETASSETBALANCES);
	}

	/**
	 * Creates a new asset on the blockchain, sending the initial qty units to
	 * address. If open is true then additional units can be issued in future by
	 * the same key which signed the original issuance, via the issuemore or
	 * issuemorefrom command.
	 * 
	 * issue "address" asset-name|asset-params quantity ( smallest-unit
	 * native-amount custom-fields )
	 * 
	 * Issue new asset
	 * 
	 * Arguments: 1. "address" (string, required) The address to send newly
	 * created asset to. 2. "asset-name" (string, required) Asset name, if not
	 * "" should be unique. or 2. "asset-params" (object, required) A json
	 * object of with asset params { "name" : "asset-name" (string, optional)
	 * Asset name "open" : true|false (boolean, optional, default false) True if
	 * follow-on issues are allowed ,... } 3. "quantity" (numeric, required) The
	 * asset total amount in display units. eg. 1234.56 4. "smallest-unit"
	 * (numeric, optional, default=1) Number of raw units in one displayed unit,
	 * eg 0.01 for cents 5. "native-amount" (numeric, optional) native currency
	 * amount to send. eg 0.1, Default: minimum-per-output. 6 "custom-fields"
	 * (object, optional) a json object with custom fields { "param-name":
	 * "param-value" (strings, required) The key is the parameter name, the
	 * value is parameter value ,... }
	 * 
	 * Result: "transactionid" (string) The transaction id.
	 * 
	 * @param address
	 * @param assetName
	 * @param quantity
	 * @param unit
	 *            the smallest transactable unit is given by units, e.g. 0.01.
	 * @param amount
	 * @param customFields
	 * @return
	 * @throws ShellChainException
	 */
	protected Object executeIssue(	String address,
									String assetName,
									float quantity,
									float unit,
									float amount,
									List<CustomParamString> customFields) throws ShellChainException {
		ShellChainTestParameter.isNotNullOrEmpty("address", address);
		ShellChainTestParameter.isNotNullOrEmpty("assetName", assetName);
		ShellChainTestParameter.valueIsPositive("quantity", quantity);
		ShellChainTestParameter.valueIsPositive("unit", unit);
		ShellChainTestParameter.valueIsNotNegative("float", amount);

		Map<String, String> customParams = CustomParamFormatter.formatCustomParamString(customFields);

		if (customParams == null || customParams.size() == 0) {
			return execute(CommandEnum.ISSUE, address, assetName, quantity, unit, amount);
		} else {
			return execute(CommandEnum.ISSUE, address, assetName, quantity, unit, amount, customParams);
		}
	}

	/**
	 * Creates a new asset on the blockchain, sending the initial qty units to
	 * address. If open is true then additional units can be issued in future by
	 * the same key which signed the original issuance, via the issuemore or
	 * issuemorefrom command.
	 * 
	 * issue "address" asset-name|asset-params quantity ( smallest-unit
	 * native-amount custom-fields )
	 * 
	 * Issue new asset
	 * 
	 * Arguments: 1. "address" (string, required) The address to send newly
	 * created asset to. 2. "asset-name" (string, required) Asset name, if not
	 * "" should be unique. or 2. "asset-params" (object, required) A json
	 * object of with asset params { "name" : "asset-name" (string, optional)
	 * Asset name "open" : true|false (boolean, optional, default false) True if
	 * follow-on issues are allowed ,... } 3. "quantity" (numeric, required) The
	 * asset total amount in display units. eg. 1234.56 4. "smallest-unit"
	 * (numeric, optional, default=1) Number of raw units in one displayed unit,
	 * eg 0.01 for cents 5. "native-amount" (numeric, optional) native currency
	 * amount to send. eg 0.1, Default: minimum-per-output. 6 "custom-fields"
	 * (object, optional) a json object with custom fields { "param-name":
	 * "param-value" (strings, required) The key is the parameter name, the
	 * value is parameter value ,... }
	 * 
	 * Result: "transactionid" (string) The transaction id.
	 * 
	 * @param address
	 * @param assets
	 * @param quantity
	 * @param unit
	 *            the smallest transactable unit is given by units, e.g. 0.01.
	 * @param amount
	 * @param customFields
	 * @return
	 * @throws ShellChainException
	 */
	protected Object executeIssue(	String address,
									AssetParams assets,
									float quantity,
									float unit,
									float amount,
									List<CustomParamString> customFields) throws ShellChainException {
		ShellChainTestParameter.isNotNullOrEmpty("address", address);

		if (assets == null) {
			throw new ShellChainException("assets", "assets needed to be sent");
		}
		assets.isFilled();

		ShellChainTestParameter.valueIsPositive("quantity", quantity);
		ShellChainTestParameter.valueIsPositive("unit", unit);
		ShellChainTestParameter.valueIsNotNegative("float", amount);

		Map<String, String> customParams = CustomParamFormatter.formatCustomParamString(customFields);

		if (customParams == null || customParams.size() == 0) {
			return execute(CommandEnum.ISSUE, address, assets, quantity, unit, amount);
		} else {
			return execute(CommandEnum.ISSUE, address, assets, quantity, unit, amount, customParams);
		}
	}

	/**
	 * This works like issue, but with control over the from-address used to
	 * issue the asset. If there are multiple addresses with asset issuing
	 * permissions on one node, this allows control over which address is used.
	 * 
	 * issuefrom "from-address" "to-address" asset-name|asset-params quantity (
	 * smallest-unit native-amount custom-fields )
	 * 
	 * Issue asset using specific address
	 * 
	 * Arguments: 1. "from-address" (string, required) Address used for issuing.
	 * 2. "to-address" (string, required) The address to send newly created
	 * asset to. 3. "asset-name" (string, required) Asset name, if not "" should
	 * be unique. or 3. "asset-params" (object, required) A json object of with
	 * asset params { "name" : "asset-name" (string, optional) Asset name "open"
	 * : true|false (boolean, optional, default false) True if follow-on issues
	 * are allowed ,... } 4. "quantity" (numeric, required) The asset total
	 * amount in display units. eg. 1234.56 5. "smallest-unit" (numeric,
	 * optional, default=1) Number of raw units in one displayed unit, eg 0.01
	 * for cents 6. "native-amount" (numeric, optional) native currency amount
	 * to send. eg 0.1, Default: minimum-per-output. 7 "custom-fields" (object,
	 * optional) a json object with custom fields { "param-name": "param-value"
	 * (strings, required) The key is the parameter name, the value is parameter
	 * value ,... }
	 * 
	 * Result: "transactionid" (string) The transaction id.
	 * 
	 * @param toAddress
	 * @param assetName
	 * @param amount
	 * @param quantity
	 * @param unit
	 *            the smallest transactable unit is given by units, e.g. 0.01.
	 * @return
	 * @throws ShellChainException
	 */
	protected Object executeIssueFrom(	String fromAddress,
										String toAddress,
										String assetName,
										int quantity,
										float unit,
										float amount,
										List<CustomParamString> customFields) throws ShellChainException {
		ShellChainTestParameter.isNotNullOrEmpty("toAddress", toAddress);
		ShellChainTestParameter.isNotNullOrEmpty("fromAddress", fromAddress);
		ShellChainTestParameter.isNotNullOrEmpty("assetName", assetName);
		ShellChainTestParameter.valueIsPositive("quantity", quantity);
		ShellChainTestParameter.valueIsPositive("unit", unit);

		Map<String, String> customParams = CustomParamFormatter.formatCustomParamString(customFields);

		if (customParams == null || customParams.size() == 0) {
			return execute(CommandEnum.ISSUEFROM, fromAddress, toAddress, assetName, quantity, unit);
		} else {
			return execute(CommandEnum.ISSUEFROM, fromAddress, toAddress, assetName, quantity, unit, amount,
					customParams);
		}
	}

	/**
	 * This works like issue, but with control over the from-address used to
	 * issue the asset. If there are multiple addresses with asset issuing
	 * permissions on one node, this allows control over which address is used.
	 * 
	 * issuefrom "from-address" "to-address" asset-name|asset-params quantity (
	 * smallest-unit native-amount custom-fields )
	 * 
	 * Issue asset using specific address
	 * 
	 * Arguments: 1. "from-address" (string, required) Address used for issuing.
	 * 2. "to-address" (string, required) The address to send newly created
	 * asset to. 3. "asset-name" (string, required) Asset name, if not "" should
	 * be unique. or 3. "asset-params" (object, required) A json object of with
	 * asset params { "name" : "asset-name" (string, optional) Asset name "open"
	 * : true|false (boolean, optional, default false) True if follow-on issues
	 * are allowed ,... } 4. "quantity" (numeric, required) The asset total
	 * amount in display units. eg. 1234.56 5. "smallest-unit" (numeric,
	 * optional, default=1) Number of raw units in one displayed unit, eg 0.01
	 * for cents 6. "native-amount" (numeric, optional) native currency amount
	 * to send. eg 0.1, Default: minimum-per-output. 7 "custom-fields" (object,
	 * optional) a json object with custom fields { "param-name": "param-value"
	 * (strings, required) The key is the parameter name, the value is parameter
	 * value ,... }
	 * 
	 * Result: "transactionid" (string) The transaction id.
	 * 
	 * @param toAddress
	 * @param assets
	 * @param amount
	 * @param quantity
	 * @param unit
	 *            the smallest transactable unit is given by units, e.g. 0.01.
	 * @return
	 * @throws ShellChainException
	 */
	protected Object executeIssueFrom(	String fromAddress,
										String toAddress,
										AssetParams assets,
										float quantity,
										float unit,
										float amount,
										List<CustomParamString> customFields) throws ShellChainException {
		ShellChainTestParameter.isNotNullOrEmpty("toAddress", toAddress);
		ShellChainTestParameter.isNotNullOrEmpty("fromAddress", fromAddress);

		if (assets == null) {
			throw new ShellChainException("assets", "assets needed to be sent");
		}
		assets.isFilled();

		ShellChainTestParameter.valueIsPositive("quantity", quantity);
		ShellChainTestParameter.valueIsPositive("unit", unit);

		Map<String, String> customParams = CustomParamFormatter.formatCustomParamString(customFields);

		if (customParams == null || customParams.size() == 0) {
			return execute(CommandEnum.ISSUEFROM, fromAddress, toAddress, assets, quantity, unit);
		} else {
			return execute(CommandEnum.ISSUEFROM, fromAddress, toAddress, assets, quantity, unit, amount, customParams);
		}
	}

	/**
	 * Issues qty additional units of asset, sending them to address. The asset
	 * can be specified using its name, ref or issuance txid
	 * 
	 * issuemore "address" asset-identifier quantity ( native-amount
	 * custom-fields )
	 * 
	 * Create more units for asset
	 * 
	 * Arguments: 1. "address" (string, required) The address to send newly
	 * created asset to. 2. "asset-identifier" (string, required) Asset
	 * identifier - one of the following: issue txid. asset reference, asset
	 * name. 3. "quantity" (numeric, required) The asset total amount in display
	 * units. eg. 1234.56 4. "native-amount" (numeric, optional) native currency
	 * amount to send. eg 0.1, Default: minimum-per-output. 5 "custom-fields"
	 * (object, optional) a json object with custom fields { "param-name":
	 * "param-value" (strings, required) The key is the parameter name, the
	 * value is parameter value ,... }
	 * 
	 * Result: "transactionid" (string) The transaction id.
	 * 
	 * @param address
	 * @param assetName
	 * @param quantity
	 * @return
	 * @throws ShellChainException
	 */
	protected Object executeIssueMore(String address, String assetName, int quantity) throws ShellChainException {
		ShellChainTestParameter.isNotNullOrEmpty("address", address);
		ShellChainTestParameter.isNotNullOrEmpty("assetName", assetName);
		ShellChainTestParameter.valueIsPositive("quantity", quantity);
		return execute(CommandEnum.ISSUEMORE, address, assetName, quantity);
	}

	/**
	 * Issues qty additional units of asset, sending them to address. The asset
	 * can be specified using its name, ref or issuance txid
	 * 
	 * issuemorefrom "from-address" "to-address" asset-identifier quantity (
	 * native-amount custom-fields )
	 * 
	 * Create more units for asset from specific address
	 * 
	 * Arguments: 1. "from-address" (string, required) Address used for issuing.
	 * 2. "to-address" (string, required) The address to send newly created
	 * asset to. 3. "asset-identifier" (string, required) Asset identifier - one
	 * of the following: issue txid. asset reference, asset name. 4. "quantity"
	 * (numeric, required) The asset total amount in display units. eg. 1234.56
	 * 5. "native-amount" (numeric, optional) native currency amount to send. eg
	 * 0.1, Default: minimum-per-output. 6 "custom-fields" (object, optional) a
	 * json object with custom fields { "param-name": "param-value" (strings,
	 * required) The key is the parameter name, the value is parameter value
	 * ,... }
	 * 
	 * Result: "transactionid" (string) The transaction id.
	 * 
	 * @param fromAddress
	 * @param assetName
	 * @param quantity
	 * @return
	 * @throws ShellChainException
	 */
	protected Object executeIssueMoreFrom(	String fromAddress,
											String toAddress,
											String assetName,
											int quantity) throws ShellChainException {
		ShellChainTestParameter.isNotNullOrEmpty("toAddress", toAddress);
		ShellChainTestParameter.isNotNullOrEmpty("fromAddress", fromAddress);
		ShellChainTestParameter.isNotNullOrEmpty("assetName", assetName);
		ShellChainTestParameter.valueIsPositive("quantity", quantity);
		return execute(CommandEnum.ISSUEMOREFROM, fromAddress, toAddress, assetName, quantity);
	}

	/**
	 * 
	 * listassets ("asset-identifier" verbose) 1. "asset-identifier" (string,
	 * optional) Asset identifier - one of the following: issue txid, asset
	 * reference, asset name. 2. verbose (boolean, optional, default=false) If
	 * true, returns list of all issue transactions, including follow-ons
	 * 
	 * Returns list of defined assets
	 * 
	 * @param asset
	 * @param verbose
	 * @return information about assets issued on the blockchain. Provide an
	 *         asset name, ref or issuance txid
	 * @throws ShellChainException
	 */
	protected Object executeListAssets(String asset, boolean verbose) throws ShellChainException {
		ShellChainTestParameter.isNotNullOrEmpty("asset", asset);
		if (asset != null && !"".equals(asset)) {
			return execute(CommandEnum.LISTASSETS, asset, verbose);
		} else {
			return execute(CommandEnum.LISTASSETS);
		}
	}

	/**
	 * Sends assets to address, returning the txid.
	 * 
	 * sendassetfrom "from-address" "to-address" asset-identifier asset-qty (
	 * native-amount "comment" "comment-to" )
	 * 
	 * Send an asset amount using specific address.
	 * 
	 * Arguments: 1. "from-address" (string, required) Address to send from. 2.
	 * "to-address" (string, required) The address to send to. 3.
	 * "asset-identifier" (string, required) Asset identifier - one of the
	 * following: issue txid. asset reference, asset name. 4. "asset-qty"
	 * (numeric, required) Asset quantity to send. eg 0.1 5. "native-amount"
	 * (numeric, optional) native currency amount to send. eg 0.1, Default:
	 * minimum-per-output. 6. "comment" (string, optional) A comment used to
	 * store what the transaction is for. This is not part of the transaction,
	 * just kept in your wallet. 7. "comment-to" (string, optional) A comment to
	 * store the name of the person or organization to which you're sending the
	 * transaction. This is not part of the transaction, just kept in your
	 * wallet.
	 * 
	 * Result: "transactionid" (string) The transaction id.
	 * 
	 * @param fromAddress
	 * @param toAddress
	 * @param assetName
	 * @param quantity
	 * @return
	 * @throws ShellChainException
	 */
	protected Object executeSendAssetFrom(	String fromAddress,
											String toAddress,
											String assetName,
											float quantity) throws ShellChainException {
		ShellChainTestParameter.isNotNullOrEmpty("fromAddress", fromAddress);
		ShellChainTestParameter.isNotNullOrEmpty("toAddress", toAddress);
		ShellChainTestParameter.isNotNullOrEmpty("assetName", assetName);
		ShellChainTestParameter.valueIsPositive("quantity", quantity);
		return execute(CommandEnum.SENDASSETFROM, fromAddress, toAddress, assetName, quantity);
	}

	/**
	 * Sends assets to address, returning the txid.
	 * 
	 * sendassettoaddress "address" asset-identifier asset-qty ( native-amount
	 * "comment" "comment-to" )
	 * 
	 * Send asset amount to a given address. The amounts are real.
	 * 
	 * Arguments: 1. "address" (string, required) The address to send to. 2.
	 * "asset-identifier" (string, required) Asset identifier - one of the
	 * following: issue txid. asset reference, asset name. 3. "asset-qty"
	 * (numeric, required) Asset quantity to send. eg 0.1 4. "native-amount"
	 * (numeric, optional) native currency amount to send. eg 0.1, Default:
	 * minimum-per-output. 5. "comment" (string, optional) A comment used to
	 * store what the transaction is for. This is not part of the transaction,
	 * just kept in your wallet. 6. "comment-to" (string, optional) A comment to
	 * store the name of the person or organization to which you're sending the
	 * transaction. This is not part of the transaction, just kept in your
	 * wallet.
	 * 
	 * Result: "transactionid" (string) The transaction id.
	 * 
	 * @param address
	 * @param assetName
	 * @param quantity
	 * @return
	 * @throws ShellChainException
	 */
	protected Object executeSendAssetToAddress(	String address,
												String assetName,
												float quantity) throws ShellChainException {
		ShellChainTestParameter.isNotNullOrEmpty("address", address);
		ShellChainTestParameter.isNotNullOrEmpty("assetName", assetName);
		ShellChainTestParameter.valueIsPositive("quantity", quantity);
		return execute(CommandEnum.SENDASSETTOADDRESS, address, assetName, quantity);
	}

	protected Object executeIssueEntity(	String fromAddress, String toAddress, String type, String userid, String secretkey, String password, Map<String,Object> attributes) throws ShellChainException {
		ShellChainTestParameter.isNotNullOrEmpty("from_address", fromAddress);
		ShellChainTestParameter.isNotNullOrEmpty("to_address", toAddress);
		ShellChainTestParameter.isNotNullOrEmpty("type", type);
		ShellChainTestParameter.isNotNullOrEmpty("secret_key", secretkey);
		ShellChainTestParameter.isNotNullOrEmpty("password", password);

		return execute(CommandEnum.ISSUEENTITYFROM, fromAddress, toAddress, type,userid,secretkey,password,attributes);
	}

	protected Object executeRegisterObject( Map<String,Float> ownerWithWeight, String hash, String assetName, Map<String,Object> attributes) throws ShellChainException{
		ShellChainTestParameter.isNotNull("ownerWithWeight", ownerWithWeight);
		ShellChainTestParameter.isNotNullOrEmpty("file_hash", hash);
		ShellChainTestParameter.isNotNullOrEmpty("assetName", assetName);
		ShellChainTestParameter.isNotNullOrEmpty("file_id", (String)attributes.get("file_id"));

		return execute(CommandEnum.REGISTEROBJECT, ownerWithWeight, hash, assetName, attributes);
	}

	protected Object executeUpdateObject( Map<String,Float> ownerWithWeight, String txid, String hash, String assetName, Map<String,Object> attributes) throws ShellChainException{
		ShellChainTestParameter.isNotNullOrEmpty("txid", txid);
		ShellChainTestParameter.isNotNullOrEmpty("file_hash", hash);
		ShellChainTestParameter.isNotNullOrEmpty("assetName", assetName);
//		if(ownerWithWeight.size() == 0)
//			return execute(CommandEnum.UPDATEOBJECT, "*", txid, hash, attributes);
		return execute(CommandEnum.UPDATEOBJECT, ownerWithWeight, txid, hash, assetName, attributes);
	}

	protected Object executeSendCustom(String toAddress, float amount, Map<String,Object> attributes) throws ShellChainException{
		ShellChainTestParameter.isNotNullOrEmpty("toAddress", toAddress);
		ShellChainTestParameter.valueIsNotNegative("amount", amount);
		return execute(CommandEnum.SENDCUSTOM, toAddress, amount, attributes);
	}

	protected Object executeGetInfo() throws ShellChainException {
		return execute(CommandEnum.GETINFO);
	}
	protected Object executeExecuteContract(Object... attributes) throws ShellChainException {
		//ShellChainTestParameter.isNotNullOrEmpty("toAddress", toAddress);
		//ShellChainTestParameter.isNotNullOrEmpty("method", method);
		return execute(CommandEnum.EXECUTECONTRACT, attributes);
	}

}
