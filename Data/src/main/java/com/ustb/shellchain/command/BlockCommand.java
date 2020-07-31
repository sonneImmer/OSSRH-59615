/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * ShellChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/ShellChainJavaAPI/blob/master/LICENSE
 *
 */
package com.ustb.shellchain.command;

import com.ustb.shellchain.command.builders.QueryBuilderBlock;
import com.ustb.shellchain.object.Block;
import com.ustb.shellchain.object.formatters.BlockFormatter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ub - H. MARTEAU
 * @version 3.0
 */
public class BlockCommand extends QueryBuilderBlock {

	public BlockCommand(String ip, String port, String login, String password) {
		initialize(ip, port, login, password);
	}

	/**
	 * getbestblockhash
	 * 
	 * Returns the hash of the best (tip) block in the longest block chain.
	 * 
	 * Result
	 * "hex" (string) the block hash hex encoded
	 * 
	 * @return the hash of the best block
	 * @throws ShellChainException
	 */
	public String getBestBlockHash() throws ShellChainException {
		String stringBestBlockHash = "";

		Object objectBestBlockHash = executeGetBestBlockHash();
		if (verifyInstance(objectBestBlockHash, String.class)) {
			stringBestBlockHash = (String) objectBestBlockHash;
		}

		return stringBestBlockHash;
	}

	/**
	 * getblock "hash/height" ( verbose )
	 * 
	 * If verbose is false, returns a string that is serialized, hex-encoded data for block 'hash'.
	 * If verbose is true, returns an Object with information about block <hash>.
	 * 
	 * Arguments:
	 * 1. "hash/height" (string, required) The block hash or block height in active chain
	 * 2. verbose (boolean, optional, default=true) true for a json object, false for the hex encoded data
	 * 
	 * Result (for verbose = true):
	 * {
	 * "hash" : "hash", (string) the block hash (same as provided)
	 * "miner" : "miner", (string) the address of the miner
	 * "confirmations" : n, (numeric) The number of confirmations, or -1 if the block is not on the main chain
	 * "size" : n, (numeric) The block size
	 * "height" : n, (numeric) The block height or index
	 * "version" : n, (numeric) The block version
	 * "merkleroot" : "xxxx", (string) The merkle root
	 * "tx" : [ (array of string) The transaction ids
	 * "transactionid" (string) The transaction id
	 * ,...
	 * ],
	 * "time" : ttt, (numeric) The block time in seconds since epoch (Jan 1 1970 GMT)
	 * "nonce" : n, (numeric) The nonce
	 * "bits" : "1d00ffff", (string) The bits
	 * "difficulty" : x.xxx, (numeric) The difficulty
	 * "previousblockhash" : "hash", (string) The hash of the previous block
	 * "nextblockhash" : "hash" (string) The hash of the next block
	 * }
	 * 
	 * Result (for verbose=false):
	 * "data" (string) A string that is serialized, hex-encoded data for block 'hash'.
	 * 
	 * 
	 * @param hash
	 * @param verbose
	 * @return Block : information about the block with hash (retrievable from getblockhash) or at the given height in
	 *         the active chain
	 * @throws ShellChainException
	 */
	public Block getBlock(String blockHash, boolean verbose) throws ShellChainException {
		Object objectBlock = executeGetBlock(blockHash, verbose);
		Block block = BlockFormatter.formatBlock(objectBlock);

		return block;
	}

	/**
	 * {@link #getBlock(String, boolean)} without verbose
	 * 
	 * @param blockHash
	 * @return Block : information about the block with hash (retrievable from getblockhash) or at the given height in
	 *         the active chain
	 * @throws ShellChainException
	 */
	public Block getBlock(String blockHash) throws ShellChainException {
		return getBlock(blockHash, true);
	}

	/**
	 * getblock "hash/height" ( verbose )
	 * 
	 * If verbose is false, returns a string that is serialized, hex-encoded data for block 'hash'.
	 * If verbose is true, returns an Object with information about block <hash>.
	 * 
	 * Arguments:
	 * 1. "hash/height" (string, required) The block hash or block height in active chain
	 * 2. verbose (boolean, optional, default=true) true for a json object, false for the hex encoded data
	 * 
	 * Result (for verbose = true):
	 * {
	 * "hash" : "hash", (string) the block hash (same as provided)
	 * "miner" : "miner", (string) the address of the miner
	 * "confirmations" : n, (numeric) The number of confirmations, or -1 if the block is not on the main chain
	 * "size" : n, (numeric) The block size
	 * "height" : n, (numeric) The block height or index
	 * "version" : n, (numeric) The block version
	 * "merkleroot" : "xxxx", (string) The merkle root
	 * "tx" : [ (array of string) The transaction ids
	 * "transactionid" (string) The transaction id
	 * ,...
	 * ],
	 * "time" : ttt, (numeric) The block time in seconds since epoch (Jan 1 1970 GMT)
	 * "nonce" : n, (numeric) The nonce
	 * "bits" : "1d00ffff", (string) The bits
	 * "difficulty" : x.xxx, (numeric) The difficulty
	 * "previousblockhash" : "hash", (string) The hash of the previous block
	 * "nextblockhash" : "hash" (string) The hash of the next block
	 * }
	 * 
	 * Result (for verbose=false):
	 * "data" (string) A string that is serialized, hex-encoded data for block 'hash'.
	 * 
	 * 
	 * @param height
	 * @param verbose
	 * @return Block : information about the block with hash (retrievable from getblockhash) or at the given height in
	 *         the active chain
	 * @throws ShellChainException
	 */
	public Block getBlock(int blockHeight, boolean verbose) throws ShellChainException {
		Object objectBlock = executeGetBlock(blockHeight, verbose);
		Block block = BlockFormatter.formatBlock(objectBlock);

		return block;
	}

	/**
	 * {@link #getBlock(long, boolean)} without verbose
	 * 
	 * @param blockHash
	 * @return Block : information about the block with hash (retrievable from getblockhash) or at the given height in
	 *         the active chain
	 * @throws ShellChainException
	 */
	public Block getBlock(int blockHeight) throws ShellChainException {
		return getBlock(blockHeight, true);
	}

	/**
	 * getblockcount
	 * 
	 * Returns the number of blocks in the longest block chain.
	 * 
	 * Result:
	 * n (numeric) The current block count
	 * 
	 * @return The Actual count of blocks in the BlockChain.
	 * @throws ShellChainException
	 */
	public long getBlockCount() throws ShellChainException {
		long stringBlockCount = 0;

		Object objectBlockCount = executeGetBlockCount();
		if (verifyInstance(objectBlockCount, long.class)) {
			stringBlockCount = (Long) objectBlockCount;
		}

		return stringBlockCount;
	}

	/**
	 * getblockhash index
	 * 
	 * Returns hash of block in best-block-chain at index provided.
	 * 
	 * Arguments:
	 * 1. index (numeric, required) The block index
	 * 
	 * Result:
	 * "hash" (string) The block hash
	 * 
	 * @return the hash of the best block
	 * @throws ShellChainException
	 */
	public String getBlockHash(long index) throws ShellChainException {
		String stringBlockHash = "";

		Object objectBlockHash = executeGetBlockHash(index);
		if (verifyInstance(objectBlockHash, String.class)) {
			stringBlockHash = (String) objectBlockHash;
		}

		return stringBlockHash;
	}


	public List<Block> listBlock(int start, int max, boolean verbose)throws ShellChainException{
		List<Block> blocks = new ArrayList<Block>();
		Object objectBlocks = executeListBlocks(start+"-"+(start+max), verbose);
		if (verifyInstance(objectBlocks, ArrayList.class) && verifyInstanceofList((ArrayList<Object>) objectBlocks, Block.class)) {
			blocks = BlockFormatter.formatBlockList((ArrayList<Object>) objectBlocks);
		}
		return blocks;
	}

	public List<Block> listBlock(String rang, boolean verbose) throws ShellChainException{
		List<Block> blocks = new ArrayList<Block>();
		Object objectBlocks = executeListBlocks(rang, verbose);
		if (verifyInstance(objectBlocks, ArrayList.class) && verifyInstanceofList((ArrayList<Object>) objectBlocks, Block.class)) {
			blocks = BlockFormatter.formatBlockList((ArrayList<Object>) objectBlocks);
		}
		return blocks;
	}

}
