package com.ustb.shellchain.command.builders;

import com.ustb.shellchain.command.ShellChainException;
import com.ustb.shellchain.command.tools.ShellChainTestParameter;

public class QueryBuilderMessaging extends QueryBuilderCommon {

	/**
	 * Verifies that message was approved by the owner of address by checking
	 * the base64-encoded digital signature provided.
	 * 
	 * @param address
	 *            (String, required) The owner address
	 * @param signature
	 *            (String, required) The base64-encoded digital signature to
	 *            check
	 * @param message
	 *            (String, required) The message
	 * @return (Boolean) True if the message is approved, else false
	 * @throws ShellChainException
	 */
	protected Object executeVerifyMessage(String address, String signature, String message) throws ShellChainException {
		ShellChainTestParameter.isNotNullOrEmpty("address", address);
		ShellChainTestParameter.isNotNullOrEmpty("signature", signature);
		ShellChainTestParameter.isNotNullOrEmpty("message", message);
		return execute(CommandEnum.VERIFYMESSAGE, address, signature, message);
	}

	/**
	 * Returns a base64-encoded digital signature which proves that message was
	 * approved by the owner of the address or any other private key given in
	 * addressORPrivateKey.
	 * 
	 * @param addressORPrivateKey
	 *            (String, required) The address or the private key (which must
	 *            belong to this wallet)
	 * @param message
	 *            (String, required) The message to approved
	 * @return (String) The base64-encoded digital signature
	 * @throws ShellChainException
	 */
	protected Object executeSignMessage(String addressORPrivKey, String message) throws ShellChainException {
		ShellChainTestParameter.isNotNullOrEmpty("addressORPrivKey", addressORPrivKey);
		ShellChainTestParameter.isNotNullOrEmpty("message", message);
		return execute(CommandEnum.SIGNMESSAGE, addressORPrivKey, message);
	}
}