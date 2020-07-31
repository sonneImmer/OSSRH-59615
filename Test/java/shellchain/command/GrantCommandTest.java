/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * ShellChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/ShellChainJavaAPI/blob/master/LICENSE
 *
 */
package shellchain.command;

import java.util.List;

import com.ustb.shellchain.command.ShellChainCommand;
import com.ustb.shellchain.command.ShellChainException;
import com.ustb.shellchain.object.Permission;

/**
 * @author Ub - H. MARTEAU
 * @version 2.0
 */
public class GrantCommandTest {
	static ShellChainCommand shellChainCommand;

	/**
	 *
	 */
	public GrantCommandTest() {
		// TODO Auto-generated constructor stub
	}

	private static void testlistPermissions() {
		List<Permission> result = null;
		try {
			result = shellChainCommand.getGrantCommand().listPermissions(shellChainCommand.getGrantCommand().WALLET);
		} catch (ShellChainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (result == null || result.size() == 0) {
			System.err.println("testlistPermissions (WALLET) - result list is empty");
		} else {
			System.out.println("testlistPermissions (WALLET) - Result :");
			for (Permission res : result) {
				System.out.println(res);
			}
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("--- Start of AddressCommandTest ---");

		// BlockChain TestCommand has to be created and started before
		shellChainCommand = new ShellChainCommand("10.25.20.13", "8338", "shellchainrpc",
				"R1KEa7nQgRjb8NDAu5DfJacrEDquV4Mgake4AuvnhdP");
		
		int value1 = shellChainCommand.getGrantCommand().CREATE;
		int value2 = shellChainCommand.getGrantCommand().CONNECT;
		int value3 = shellChainCommand.getGrantCommand().ADMIN;
		try{
			shellChainCommand.getGrantCommand().grant("1STtQ8zhCMpR18DKzQH25LNZVzZxsZwjhCTxEQ",shellChainCommand.getGrantCommand().CREATE|shellChainCommand.getGrantCommand().CONNECT|shellChainCommand.getGrantCommand().SEND|shellChainCommand.getGrantCommand().RECEIVE);
		}catch (Exception e){
			e.printStackTrace();
		}

		System.out.println("---");
		int value = value1;
		System.out.println(value);
		System.out.println(value | 0);
		System.out.println(value & value1);
		System.out.println(value & value2);
		System.out.println(value & value3);
		value = value | value2;
		System.out.println("---");
		System.out.println(value);
		System.out.println(value & value1);
		System.out.println(value & value2);
		System.out.println(value & value3);
		value = value | value3;
		System.out.println("---");
		System.out.println(value);
		System.out.println(value & value1);
		System.out.println(value & value2);
		System.out.println(value & value3);
		System.out.println("---");
		
		testlistPermissions();

		System.out.println("--- End of AddressCommandTest ---");
	}

}
