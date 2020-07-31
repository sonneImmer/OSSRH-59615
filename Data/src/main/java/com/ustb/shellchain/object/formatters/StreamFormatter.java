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
import com.ustb.shellchain.object.Stream;
import com.ustb.shellchain.object.StreamKey;
import com.ustb.shellchain.object.StreamKeyItem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ub - H. MARTEAU & Jagrut KOSTI
 * @version 3.1
 */
public class StreamFormatter {
	public final static Stream formatStream(Object objectStream) {
		Stream stream = new Stream();

		if (objectStream != null && LinkedTreeMap.class.isInstance(objectStream)) {
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();

			String jsonValue = gson.toJson(objectStream);
			stream = gson.fromJson(jsonValue, Stream.class);
		}

		return stream;
	}

	public final static List<Stream> formatStreams(List<Object> objectStreams) {
		List<Stream> streams = new ArrayList<Stream>();

		if (objectStreams != null) {
			for (Object objectStream : objectStreams) {
				streams.add(formatStream(objectStream));
			}
		}

		return streams;
	}

	public final static StreamKey formatStreamKey(Object objectStreamKey) {
		StreamKey streamKey = new StreamKey();

		if (objectStreamKey != null && LinkedTreeMap.class.isInstance(objectStreamKey)) {
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();

			String jsonValue = gson.toJson(objectStreamKey);
			streamKey = gson.fromJson(jsonValue, StreamKey.class);
		}

		return streamKey;
	}

	public final static List<StreamKey> formatStreamKeys(List<Object> objectStreamKeys) {
		List<StreamKey> streamKeys = new ArrayList<StreamKey>();

		if (objectStreamKeys != null) {
			for (Object objectStreamKey : objectStreamKeys) {
				streamKeys.add(formatStreamKey(objectStreamKey));
			}
		}

		return streamKeys;
	}

	public final static StreamKeyItem formatStreamKeyItem(Object objectStreamKeyItem) {
		StreamKeyItem streamKeyItem = new StreamKeyItem();

		if (objectStreamKeyItem != null && LinkedTreeMap.class.isInstance(objectStreamKeyItem)) {
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();

			String jsonValue = gson.toJson(objectStreamKeyItem);
			streamKeyItem = gson.fromJson(jsonValue, StreamKeyItem.class);
		}

		return streamKeyItem;
	}

	public final static List<StreamKeyItem> formatStreamKeyItems(List<Object> objectStreamKeyItems) {
		List<StreamKeyItem> streamKeyItems = new ArrayList<StreamKeyItem>();

		if (objectStreamKeyItems != null) {
			for (Object objectStreamKeyItem : objectStreamKeyItems) {
				streamKeyItems.add(formatStreamKeyItem(objectStreamKeyItem));
			}
		}

		return streamKeyItems;
	}
}
