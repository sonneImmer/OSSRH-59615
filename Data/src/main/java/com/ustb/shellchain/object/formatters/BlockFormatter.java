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
import com.ustb.shellchain.object.Block;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ub - H. MARTEAU
 * @version 1.0
 */
public class BlockFormatter {
	public final static long formatBlockCount(String stringBlockCount) {
		final Gson gson = new GsonBuilder().create();

		final Long blockCount = gson.fromJson(stringBlockCount, Long.class);

		return blockCount.longValue();
	}

	public final static Block formatBlock(Object objectBlock) {
		Block block = new Block();

		if (objectBlock != null && LinkedTreeMap.class.isInstance(objectBlock)) {
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();

			String jsonValue = gson.toJson(objectBlock);
			block = gson.fromJson(jsonValue, Block.class);
		}

		return block;
	}
	public final static List<Block> formatBlockList(List<Object> objectBlocks) {
		List<Block> blocks = new ArrayList<Block>();

		if (objectBlocks != null) {
			for (Object objectBlock : objectBlocks) {
				blocks.add(formatBlock(objectBlock));
			}
		}
		return blocks;
	}


}
