/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * ShellChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/ShellChainJavaAPI/blob/master/LICENSE
 *
 */
package shellchain.command;

import com.ustb.shellchain.command.ShellChainCommand;
import com.ustb.shellchain.command.ShellChainException;
import com.ustb.shellchain.object.Block;

/**
 * @author Ub - H. MARTEAU
 * @version 2.0
 */
public class BlockCommandTest {
	static ShellChainCommand shellChainCommand;

	/**
	 *
	 */
	public BlockCommandTest() {
		// TODO Auto-generated constructor stub
	}

	private static void testgetBlock() {
		Block result = null;
		try {
			result = shellChainCommand.getBlockCommand().getBlock(1);
		} catch (ShellChainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Result Block(1) (default verbose) :" + result);
		System.out.println("");

		try {
			result = shellChainCommand.getBlockCommand().getBlock(1, true);
		} catch (ShellChainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Result Block(1) (default verbose=true) :" + result);
		System.out.println("");

		try {
			result = shellChainCommand.getBlockCommand().getBlock(1, false);
		} catch (ShellChainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Result Block(1) (default verbose=false) :" + result);

		System.out.println("");
		System.out.println("");

		//
		try {
			result = shellChainCommand.getBlockCommand().getBlock(
					"0074ba967e7f7c3b04ed0429b796900136d82b52ecf44d5878f1f2dfdf5e1fb8");
		} catch (ShellChainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out
				.println("Result Block(0074ba967e7f7c3b04ed0429b796900136d82b52ecf44d5878f1f2dfdf5e1fb8) (default verbose) :"
						+ result);
		System.out.println("");

		try {
			result = shellChainCommand.getBlockCommand().getBlock(
					"0074ba967e7f7c3b04ed0429b796900136d82b52ecf44d5878f1f2dfdf5e1fb8", true);
		} catch (ShellChainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out
				.println("Result Block(0074ba967e7f7c3b04ed0429b796900136d82b52ecf44d5878f1f2dfdf5e1fb8) (default verbose=true) :"
						+ result);
		System.out.println("");

		try {
			result = shellChainCommand.getBlockCommand().getBlock(
					"0074ba967e7f7c3b04ed0429b796900136d82b52ecf44d5878f1f2dfdf5e1fb8", false);
		} catch (ShellChainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out
				.println("Result Block(0074ba967e7f7c3b04ed0429b796900136d82b52ecf44d5878f1f2dfdf5e1fb8) (default verbose=false) :"
						+ result);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("--- Start of AddressCommandTest ---");

		// BlockChain TestCommand has to be created and started before
		shellChainCommand = new ShellChainCommand("localhost", "6824", "shellchainrpc",
				"73oYQWzx45hossFPPWUgicpLvHhsD8PempYxnSF6bnY9");

		testgetBlock();

		System.out.println("--- End of AddressCommandTest ---");
	}

}
