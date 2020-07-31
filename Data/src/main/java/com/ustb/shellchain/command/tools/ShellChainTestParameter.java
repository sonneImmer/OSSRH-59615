/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * ShellChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/ShellChainJavaAPI/blob/master/LICENSE
 *
 */
package com.ustb.shellchain.command.tools;

import com.ustb.shellchain.command.ShellChainException;

import java.util.List;

/**
 * @author Ub - H. MARTEAU
 * @version 1.1
 */
public class ShellChainTestParameter {

	public static void isNotNullOrEmpty(String name, String string) throws ShellChainException {
		if (string != null) {
			if (string.isEmpty()) {
				throw new ShellChainException(name, "is null or empty.");
			}
		} else {
			throw new ShellChainException(name, "is null or empty.");
		}
	}

	public static void isNotNull(String name, Object object) throws ShellChainException {
		if (object == null) {
			throw new ShellChainException(name, "is null or empty.");
		}
	}

	public static void isNotNullOrEmpty(String name, Object[] array) throws ShellChainException {
		if (array != null) {
			if (array.length <= 0) {
				throw new ShellChainException(name, "size is 0.");
			}
		} else {
			throw new ShellChainException(name, "is null.");
		}
	}

	public static void isNotNullOrEmpty(String name, List<Object> list) throws ShellChainException {
		if (list != null) {
			if (list.size() <= 0) {
				throw new ShellChainException(name, "size is 0.");
			}
		} else {
			throw new ShellChainException(name, "is null.");
		}
	}

	public static boolean isArrayNotNullOrEmpty(Object[] array) {
		if (array == null || array.length <= 0) {
			return false;
		}
		return true;
	}

	public static void arrayNotContainNullOrEmptyValues(String name, Object[] array) throws ShellChainException {
		for (Object object : array) {
			if (object == null) {
				throw new ShellChainException(name, "array contain null value.");
			} else if (object.getClass() == String.class) {
				if (((String) object).isEmpty()) {
					throw new ShellChainException(name, "array contain empty string.");
				}
			}
		}
	}

	public static void floatArrayContainNullOrNegativeValue(String name, float[] array) throws ShellChainException {
		for (float f : array) {
			if (f < 0) {
				throw new ShellChainException(name, "array contain negative value.");
			} else if (f == 0) {
				throw new ShellChainException(name, "array contain null values.");
			}
		}
	}

	public static void intArrayContainNullOrNegativeValue(String name, int[] array) throws ShellChainException {
		for (int i : array) {
			if (i < 0) {
				throw new ShellChainException(name, "array contain negative value.");
			} else if (i == 0) {
				throw new ShellChainException(name, "array contain null values.");
			}
		}
	}

	public static void valueIsNotNegative(String name, int value) throws ShellChainException {
		if (value < 0) {
			throw new ShellChainException(name, "is negative.");
		}
	}

	public static void valueIsNotNegative(String name, float value) throws ShellChainException {
		if (value < 0) {
			throw new ShellChainException(name, "is negative.");
		}
	}

	public static void valueIsNotNegative(String name, double value) throws ShellChainException {
		if (value < 0) {
			throw new ShellChainException(name, "is negative.");
		}
	}

	public static void valueIsPositive(String name, int value) throws ShellChainException {
		if (value < 0) {
			throw new ShellChainException(name, "is negative.");
		} else if (value == 0) {
			throw new ShellChainException(name, "is null.");
		}
	}

	public static void valueIsPositive(String name, float value) throws ShellChainException {
		if (value < 0) {
			throw new ShellChainException(name, "is negative.");
		} else if (value == 0) {
			throw new ShellChainException(name, "is null.");
		}
	}

	public static void valueIsPositive(String name, double value) throws ShellChainException {
		if (value < 0) {
			throw new ShellChainException(name, "is negative.");
		} else if (value == 0) {
			throw new ShellChainException(name, "is null.");
		}
	}

}
