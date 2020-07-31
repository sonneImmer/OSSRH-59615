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
import com.ustb.shellchain.object.BlockChainInfo;

/**
 * @author Ub - H. MARTEAU
 * @version 2.0
 */
public class GetInfoCommandTest {
	static ShellChainCommand shellChainCommand;

	/**
	 *
	 */
	public GetInfoCommandTest() {
		// TODO Auto-generated constructor stub
	}

	private static void testgetInfo() {
		BlockChainInfo result = null;
		try {
			result = shellChainCommand.getChainCommand().getInfo();
		} catch (ShellChainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Result :" + result);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("--- Start of AddressCommandTest ---");

		// BlockChain TestCommand has to be created and started before
		shellChainCommand = new ShellChainCommand("localhost", "6824", "shellchainrpc",
				"73oYQWzx45hossFPPWUgicpLvHhsD8PempYxnSF6bnY9");

		testgetInfo();

		System.out.println("--- End of AddressCommandTest ---");
	}

}
