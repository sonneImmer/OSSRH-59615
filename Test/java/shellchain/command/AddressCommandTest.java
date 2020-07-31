package shellchain.command;

import java.util.List;

import com.ustb.shellchain.command.ShellChainCommand;
import com.ustb.shellchain.command.ShellChainException;
import org.junit.Test;

import junit.framework.TestCase;
import com.ustb.shellchain.object.KeyPairs;

public class AddressCommandTest extends TestCase {

	@Test
	public void testcreateKeyPairs() {
		ShellChainCommand shellChainCommand = new ShellChainCommand(TestConst.MULTICHAIN_SERVER_IP,
				TestConst.MULTICHAIN_SERVER_PORT, TestConst.MULTICHAIN_SERVER_LOGIN, TestConst.MULTICHAIN_SERVER_PWD);

		List<KeyPairs> listKeyPairs01 = null;

		try {
			listKeyPairs01 = shellChainCommand.getAddressCommand().createKeyPairs();
		} catch (ShellChainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNotNull(listKeyPairs01);
		for (KeyPairs keyPairs : listKeyPairs01) {
			System.out.println(keyPairs.toString());
		}
		assertEquals(listKeyPairs01.size(), 1);

		List<KeyPairs> listKeyPairs05 = null;

		try {
			listKeyPairs05 = shellChainCommand.getAddressCommand().createKeyPairs(5);
		} catch (ShellChainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNotNull(listKeyPairs05);
		for (KeyPairs keyPairs : listKeyPairs05) {
			System.out.println(keyPairs.toString());
		}
		assertEquals(listKeyPairs05.size(), 5);

	}

	// @Test
	// public void testgetAddresses() {
	// ShellChainCommand shellChainCommand = new
	// ShellChainCommand(TestConst.MULTICHAIN_SERVER_IP,
	// TestConst.MULTICHAIN_SERVER_PORT, TestConst.MULTICHAIN_SERVER_LOGIN,
	// TestConst.MULTICHAIN_SERVER_PWD);
	//
	// List<String> result = null;
	// List<Address> resultAddress = null;
	// try {
	// result = shellChainCommand.getAddressCommand().getAddresses();
	// } catch (ShellChainException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// assertNotNull(result);
	// assertFalse(result.size() == 0);
	//
	// try {
	// resultAddress = shellChainCommand.getAddressCommand().getAddressesList();
	// } catch (ShellChainException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// assertNotNull(resultAddress);
	// assertFalse(resultAddress.size() == 0);
	// }
	//
	// @Test
	// public void testvalidateAddress() {
	// ShellChainCommand shellChainCommand = new
	// ShellChainCommand(TestConst.MULTICHAIN_SERVER_IP,
	// TestConst.MULTICHAIN_SERVER_PORT, TestConst.MULTICHAIN_SERVER_LOGIN,
	// TestConst.MULTICHAIN_SERVER_PWD);
	//
	// List<String> resultAddresses = null;
	// Address result = null;
	// try {
	// resultAddresses = shellChainCommand.getAddressCommand().getAddresses();
	//
	// assertNotNull(resultAddresses);
	// assertFalse(resultAddresses.size() == 0);
	//
	// for (String addressString : resultAddresses) {
	// result =
	// shellChainCommand.getAddressCommand().validateAddress(addressString);
	//
	// assertNotNull(result);
	// assertNotNull(result.getAddress());
	// assertNotSame("", result.getAddress());
	// }
	// } catch (ShellChainException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	//
	// @Test
	// public void testgetNewAddress() {
	// ShellChainCommand shellChainCommand = new
	// ShellChainCommand(TestConst.MULTICHAIN_SERVER_IP,
	// TestConst.MULTICHAIN_SERVER_PORT, TestConst.MULTICHAIN_SERVER_LOGIN,
	// TestConst.MULTICHAIN_SERVER_PWD);
	//
	// String resultAddress = "";
	// Address result = null;
	//
	// try {
	// resultAddress = shellChainCommand.getAddressCommand().getNewAddress();
	//
	// assertNotNull(resultAddress);
	// assertNotSame("", resultAddress);
	//
	// result = shellChainCommand.getAddressCommand().getNewAddressFilled();
	//
	// assertNotNull(result);
	// assertNotNull(result.getAddress());
	// assertNotSame("", result.getAddress());
	//
	// } catch (ShellChainException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

}
