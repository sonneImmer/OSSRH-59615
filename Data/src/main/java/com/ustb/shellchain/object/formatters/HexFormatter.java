package com.ustb.shellchain.object.formatters;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import java.io.UnsupportedEncodingException;

public class HexFormatter {

	private static final String CHARSET = "UTF-8";

	public static String toHex(String asciiValue) {
		try {
			return Hex.encodeHexString(asciiValue.getBytes(CHARSET));
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}

	public static String fromHex(String hexValue) {
		try {
			final byte[] bytes = Hex.decodeHex(hexValue.toCharArray());
			return new String(bytes, CHARSET);
		} catch (DecoderException e) {
			return null;
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}

}
