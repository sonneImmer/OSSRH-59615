/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * ShellChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/ShellChainJavaAPI/blob/master/LICENSE
 *
 */
package shellchain.command;

import java.text.SimpleDateFormat;
import java.util.*;

import com.ustb.bean.ChainParam;
import com.ustb.shellchain.command.ShellChainCommand;
import com.ustb.shellchain.command.ShellChainException;
import com.ustb.shellchain.object.BalanceAsset;
import com.ustb.shellchain.object.Stream;
import com.ustb.shellchain.object.queryobjects.AssetParams;
import com.ustb.shellchain.object.queryobjects.CustomParamString;
import org.junit.Before;
import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Ub - H. MARTEAU
 * @version 2.1
 */

//@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试

public class IssueCommandTest {
	static ShellChainCommand shellChainCommand;

	static String assetName = "";


	/*@Before
	public void init(){
		System.out.println("--- Start of IssueCommandTest ---");

		// BlockChain TestCommand has to be created and started before
		shellChainCommand = new ShellChainCommand(TestConst.MULTICHAIN_SERVER_IP, TestConst.MULTICHAIN_SERVER_PORT, TestConst.MULTICHAIN_SERVER_LOGIN,
				TestConst.MULTICHAIN_SERVER_PWD);

		SimpleDateFormat formater = new SimpleDateFormat("ddMMyyhhmmss");
		assetName = "TestAPI1" + formater.format(new Date());
		System.out.println("--- End of IssueCommandTest ---");
	}*/

	/*@Test
	public void testregisterObject() {
		Map<String,Float> ownerWithWeight = new HashMap<>();
		ownerWithWeight.put("17RhQVoVihoxba3Bi5PUzRuqx3ndFwH1tHRX4a",(float)50);
		ownerWithWeight.put("1YpByMvzCjMmXj7B3QEjSu8saVwNA4PTnPr52j",(float)50);
		String hash = "ABD3437SRER";
		String version = "ABD3437SRER";
		Map<String,Object> attributes = new HashMap<>();
		attributes.put("file_id","yes2");
		attributes.put("file_type",123);
		String result;
		try {
			result = (String)shellChainCommand.getIssueCommand().registerObject(ownerWithWeight,hash,version,attributes);
			System.out.println("Result :");
			System.out.println(result);
		} catch (ShellChainException e) {
			e.printStackTrace();
		}
	}


	@Test
	public void testissue() {
		String resultClosed = "";
		String resultOpened = "";
		try {
			List<String> addresses = shellChainCommand.getAddressCommand().getAddresses();
			if (addresses != null && addresses.size() > 0) {
				String address = addresses.get(0);

				List<CustomParamString> customFields = new ArrayList<CustomParamString>();
				customFields.add(new CustomParamString("name1", "value1"));
				customFields.add(new CustomParamString("name2", "value2"));
				customFields.add(new CustomParamString("name3", "value3"));

				// Closed Asset
				System.out.println("Creation of the asset : " + assetName + "Closed");
				resultClosed = shellChainCommand.getIssueCommand().issue(address, assetName + "Closed", 100, 1, 0,
						customFields);

				// Opened Asset
				AssetParams params = new AssetParams(assetName + "Opened", true);
				System.out.println("Creation of the asset : " + assetName + "Opened");
				resultOpened = shellChainCommand.getIssueCommand().issue(address, params, 100, 1, 0, customFields);

			}
		} catch (ShellChainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (resultClosed == null || "".equals(resultClosed) || resultOpened == null || "".equals(resultOpened)) {
			System.err.println("testissue - resultClosed or resultOpened is empty");
		} else {
			System.out.println("testissue");
			System.out.println("Result for asset " + assetName + "Closed :");
			System.out.println(resultClosed);
			System.out.println("Result for asset " + assetName + "Opened :");
			System.out.println(resultOpened);
		}
	}

	private static void testlistAssets() {
		List<BalanceAsset> result = null;
		try {
			result = shellChainCommand.getIssueCommand().listAssets(assetName + "Closed");
		} catch (ShellChainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == null || result.size() != 1) {
			System.err.println("testlistAssets - result is empty");
		} else {
			BalanceAsset balanceAsset = result.get(0);
			System.out.println("testlistAssets");
			System.out.println("Result :");
			System.out.println(balanceAsset.toString());
		}
	}*/

	/**
	 */
//	public static void main(String[] args) {
//		System.out.println("--- Start of IssueCommandTest ---");
//
//		// BlockChain TestCommand has to be created and started before
//		shellChainCommand = new ShellChainCommand("localhost", "6824", "shellchainrpc",
//				"73oYQWzx45hossFPPWUgicpLvHhsD8PempYxnSF6bnY9");
//
//		SimpleDateFormat formater = new SimpleDateFormat("ddMMyyhhmmss");
//		assetName = "TestAPI1" + formater.format(new Date());
//		testissue();
//		testlistAssets();
//
//		System.out.println("--- End of IssueCommandTest ---");
//	}

	/*@Test
	public void testIssueCommand(){
		System.out.println("--- Start of IssueCommandTest ---");

		// BlockChain TestCommand has to be created and started before
		shellChainCommand = new ShellChainCommand("222.28.66.120", "4334", "multichainrpc",
				"AqoBuGFrrsRfDfBALCLDczZQHSGdKGEoheHTUfhL1YF6");

		SimpleDateFormat formater = new SimpleDateFormat("ddMMyyhhmmss");
		assetName = "TestAPI1" + formater.format(new Date());
		testissue();
		testlistAssets();

		System.out.println("--- End of IssueCommandTest ---");
	}
	*/

	@Test
	public void testGetInfo() throws Exception{
		ChainParam chainParam = new ChainParam(1,TestConst.MULTICHAIN_SERVER_CHAINNAME,TestConst.MULTICHAIN_SERVER_IP,TestConst.MULTICHAIN_SERVER_PORT,TestConst.MULTICHAIN_SERVER_LOGIN,TestConst.MULTICHAIN_SERVER_PWD);
		shellChainCommand = new ShellChainCommand(chainParam);
		String result = shellChainCommand.getIssueCommand().getInfo().toString();
		System.out.println(result);
	}

	@Test
	public void testExecuteContract() throws Exception{
		Map<String,Object> attributes = new HashMap<>();
		System.out.println(attributes.get("weight"));
		ChainParam chainParam = new ChainParam(1,TestConst.MULTICHAIN_SERVER_CHAINNAME,TestConst.MULTICHAIN_SERVER_IP,TestConst.MULTICHAIN_SERVER_PORT,TestConst.MULTICHAIN_SERVER_LOGIN,TestConst.MULTICHAIN_SERVER_PWD);
		shellChainCommand = new ShellChainCommand(chainParam);
		String result = (String)shellChainCommand.getIssueCommand().executeContract("1CdaYPxEkQ495bMtKySTq5dbKoUHdBtya8JLbH","addT","10");
		System.out.println(result);
	}
}
