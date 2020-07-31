/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * ShellChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/ShellChainJavaAPI/blob/master/LICENSE
 *
 */
package com.ustb.shellchain.command;

import com.ustb.shellchain.command.builders.QueryBuilderChain;
import com.ustb.shellchain.object.BlockChainInfo;
import com.ustb.shellchain.object.PeerInfo;
import com.ustb.shellchain.object.formatters.BlockChainInfoFormatter;
import com.ustb.shellchain.object.formatters.PeerInfoFormatter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ub - H. MARTEAU
 * @version 3.0
 */
public class ChainCommand extends QueryBuilderChain {

	public ChainCommand(String ip, String port, String login, String password) {
		initialize(ip, port, login, password);
	}

	/**
	 * getinfo
	 * Returns an object containing various state info.
	 * 
	 * Result:
	 * {
	 * "version": xxxxx, (numeric) the server version
	 * "protocolversion": xxxxx, (numeric) the protocol version
	 * "chainname": "xxxx", (string) shellchain network name
	 * "description": "xxxx", (string) network desctription
	 * "protocol": "xxxx", (string) protocol - shellchain or bitcoin
	 * "port": xxxx, (numeric) network port
	 * "setupblocks": "xxxx", (string) number of network setup blocks
	 * "walletversion": xxxxx, (numeric) the wallet version
	 * "balance": xxxxxxx, (numeric) the total native currency balance of the wallet
	 * "walletdbversion": xxxxx, (numeric) the wallet database version
	 * "blocks": xxxxxx, (numeric) the current number of blocks processed in the server
	 * "timeoffset": xxxxx, (numeric) the time offset
	 * "connections": xxxxx, (numeric) the number of connections
	 * "proxy": "host:port", (string, optional) the proxy used by the server
	 * "difficulty": xxxxxx, (numeric) the current difficulty
	 * "testnet": true|false, (boolean) if the server is using testnet or not
	 * "keypoololdest": xxxxxx, (numeric) the timestamp (seconds since GMT epoch) of the oldest pre-generated key in the
	 * key pool
	 * "keypoolsize": xxxx, (numeric) how many new keys are pre-generated
	 * "unlocked_until": ttt, (numeric) the timestamp in seconds since epoch (midnight Jan 1 1970 GMT) that the wallet
	 * is unlocked for transfers, or 0
	 * if the wallet is locked
	 * "paytxfee": x.xxxx, (numeric) the transaction fee set in btc/kb
	 * "relayfee": x.xxxx, (numeric) minimum relay fee for non-free transactions in btc/kb
	 * "errors": "..." (string) any error messages
	 * }
	 * 
	 * @return
	 * @throws ShellChainException
	 */
	public BlockChainInfo getInfo() throws ShellChainException {
		BlockChainInfo blockChainInfo=null;
		Object objBlockChainInfo=executeGetInfo();
		blockChainInfo= BlockChainInfoFormatter.formatPeerInfo(objBlockChainInfo);
		return blockChainInfo;
	}


	public List<PeerInfo> getPeerInfo() throws ShellChainException{
		List<PeerInfo> peerInfos = new ArrayList<PeerInfo>();

		Object objectBalanceAsset = executeGetPeerInfo();

		if (verifyInstance(objectBalanceAsset, ArrayList.class)) {
			peerInfos = PeerInfoFormatter.formatPeerInfoList((ArrayList<Object>) objectBalanceAsset);
		}
		return peerInfos;
	}


	public BlockChainInfo getBlockChainInfo() throws ShellChainException{
		BlockChainInfo blockChainInfo=null;
		Object objBlockChainInfo=executeGetBlockChainInfo();
		if(verifyInstance(objBlockChainInfo,BlockChainInfo.class)){
			blockChainInfo= BlockChainInfoFormatter.formatPeerInfo(objBlockChainInfo);
		}
		return blockChainInfo;
	}

}
