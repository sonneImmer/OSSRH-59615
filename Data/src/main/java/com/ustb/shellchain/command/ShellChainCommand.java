/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * ShellChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/ShellChainJavaAPI/blob/master/LICENSE
 *
 */
package com.ustb.shellchain.command;

import com.ustb.bean.ChainParam;

/**
 * @author Ub - H. MARTEAU
 * @version 3.0
 */
public class ShellChainCommand {

	private Integer chainId;
	private String ip,port,login,password;
//	private AddressCommand addressCommand;
//	private BalanceCommand balanceCommand;
//	private BlockCommand blockCommand;
//	private ChainCommand chainCommand;
//	private GrantCommand grantCommand;
//	private IssueCommand issueCommand;
//	private MessagingCommand messagingCommand;
//	private RAWTransactionCommand rawTransactionCommand;
//	private StreamCommand streamCommand;
//	private WalletTransactionCommand walletTransactionCommand;
//	private KeyCommand keyCommand;

	private  ThreadLocal<AddressCommand> addressCommand = new ThreadLocal<AddressCommand>();
	private  ThreadLocal<BalanceCommand> balanceCommand = new ThreadLocal<BalanceCommand>();
    private  ThreadLocal<BlockCommand> blockCommand = new ThreadLocal<BlockCommand>();
	private  ThreadLocal<ChainCommand> chainCommand = new ThreadLocal<ChainCommand>();
    private  ThreadLocal<GrantCommand> grantCommand = new ThreadLocal<GrantCommand>();
	private  ThreadLocal<IssueCommand> issueCommand = new ThreadLocal<IssueCommand>();
	private  ThreadLocal<MessagingCommand> messagingCommand = new ThreadLocal<MessagingCommand>();
	private  ThreadLocal<RAWTransactionCommand> rawTransactionCommand = new ThreadLocal<RAWTransactionCommand>();
	private  ThreadLocal<StreamCommand> streamCommand = new ThreadLocal<StreamCommand>();
	private  ThreadLocal<WalletTransactionCommand> walletTransactionCommand = new ThreadLocal<WalletTransactionCommand>();
	private  ThreadLocal<KeyCommand> keyCommand = new ThreadLocal<KeyCommand>();

	/**
	 * 
	 */
	public ShellChainCommand(String ip, String port, String login, String password) {
		super();
		this.chainId=null;
//		addressCommand = new AddressCommand(ip, port, login, password);
//		balanceCommand = new BalanceCommand(ip, port, login, password);
//		blockCommand = new BlockCommand(ip, port, login, password);
//		chainCommand = new ChainCommand(ip, port, login, password);
//		grantCommand = new GrantCommand(ip, port, login, password);
//		issueCommand = new IssueCommand(ip, port, login, password);
//		messagingCommand = new MessagingCommand(ip, port, login, password);
//		rawTransactionCommand = new RAWTransactionCommand(ip, port, login, password);
//		streamCommand = new StreamCommand(ip, port, login, password);
//		walletTransactionCommand = new WalletTransactionCommand(ip, port, login, password);
//		keyCommand = new KeyCommand(ip, port, login, password);
	}

	public ShellChainCommand(ChainParam chainParam){
		super();
		this.chainId=chainParam.getSysId();
		this.ip=chainParam.getChainIp();
		this.port=chainParam.getChainRpcPort();
		this.login=chainParam.getChainUsername();
		this.password=chainParam.getChainPassword();
//		addressCommand = new AddressCommand(ip, port, login, password);
//		balanceCommand = new BalanceCommand(ip, port, login, password);
//		blockCommand = new BlockCommand(ip, port, login, password);
//		chainCommand = new ChainCommand(ip, port, login, password);
//		grantCommand = new GrantCommand(ip, port, login, password);
//		issueCommand = new IssueCommand(ip, port, login, password);
//		messagingCommand = new MessagingCommand(ip, port, login, password);
//		rawTransactionCommand = new RAWTransactionCommand(ip, port, login, password);
//		streamCommand = new StreamCommand(ip, port, login, password);
//		walletTransactionCommand = new WalletTransactionCommand(ip, port, login, password);
//		keyCommand = new KeyCommand(ip, port, login, password);
	}

	/**
	 * @return the issueCommand
	 */
	public IssueCommand getIssueCommand() {
//		return issueCommand;
		if(this.issueCommand.get()==null){
			IssueCommand Command=new IssueCommand(ip, port, login, password);
            this.issueCommand.set(Command);
            return Command;
        }else {
            return this.issueCommand.get();
        }
	}

	/**
	 * @param issueCommand
	 *            the issueCommand to set
	 */
	public void setIssueCommand(IssueCommand issueCommand) {
//		this.issueCommand = issueCommand;
		this.issueCommand.set(issueCommand);
	}

	public void removeIssueCommand() {
//		this.issueCommand = issueCommand;
		this.issueCommand.remove();
	}

	/**
	 * @return the messagingCommand
	 */
	public MessagingCommand getMessagingCommand() {
//		return messagingCommand;
		if(this.messagingCommand.get()==null){
			MessagingCommand Command=new MessagingCommand(ip, port, login, password);
			this.messagingCommand.set(Command);
			return Command;
		}else {
			return this.messagingCommand.get();
		}
	}

	/**
	 * @param messagingCommand
	 *            the messagingCommand to set
	 */
	public void setMessagingCommand(MessagingCommand messagingCommand) {
//		this.messagingCommand = messagingCommand;
		this.messagingCommand.set(messagingCommand);
	}

	/**
	 * @return the streamCommand
	 */
	public StreamCommand getStreamCommand() {
//		return streamCommand;
		if(this.streamCommand.get()==null){
			StreamCommand Command=new StreamCommand(ip, port, login, password);
			this.streamCommand.set(Command);
			return Command;
		}else {
			return this.streamCommand.get();
		}
	}

	/**
	 * @param streamCommand
	 *            the streamCommand to set
	 */
	public void setStreamCommand(StreamCommand streamCommand) {
//		this.streamCommand = streamCommand;
		this.streamCommand.set(streamCommand);
	}

	/**
	 * @return the rawTransactionCommand
	 */
	public RAWTransactionCommand getRawTransactionCommand() {
//		return rawTransactionCommand;
		if(this.rawTransactionCommand.get()==null){
			RAWTransactionCommand Command=new RAWTransactionCommand(ip, port, login, password);
			this.rawTransactionCommand.set(Command);
			return Command;
		}else {
			return this.rawTransactionCommand.get();
		}
	}

	/**
	 * @param rawTransactionCommand
	 *            the rawTransactionCommand to set
	 */
	public void setRawTransactionCommand(RAWTransactionCommand rawTransactionCommand) {
//		this.rawTransactionCommand = rawTransactionCommand;
		this.rawTransactionCommand.set(rawTransactionCommand);
	}

	public void removeRawTransactionCommand(){
		if(this.rawTransactionCommand.get()!=null){
			this.rawTransactionCommand.remove();
		}
	}
	/**
	 * @return the addressCommand
	 */
	public AddressCommand getAddressCommand() {
//		return addressCommand;
		if(this.addressCommand.get()==null){
			AddressCommand Command=new AddressCommand(ip, port, login, password);
			this.addressCommand.set(Command);
			return Command;
		}else {
			return this.addressCommand.get();
		}
	}

	/**
	 * @param addressCommand
	 *            the addressCommand to set
	 */
	public void setAddressCommand(AddressCommand addressCommand) {
//		this.addressCommand = addressCommand;
		this.addressCommand.set(addressCommand);
	}

	public void removeAddressCommand(){
		if(this.getAddressCommand()!=null){
			this.addressCommand.remove();
		}
	}
	/**
	 * @return the balanceCommand
	 */
	public BalanceCommand getBalanceCommand() {
//		return balanceCommand;
		if(this.balanceCommand.get()==null){
			BalanceCommand Command=new BalanceCommand(ip, port, login, password);
			this.balanceCommand.set(Command);
			return Command;
		}else {
			return this.balanceCommand.get();
		}
	}

	/**
	 * @param balanceCommand
	 *            the balanceCommand to set
	 */
	public void setBalanceCommand(BalanceCommand balanceCommand) {
//		this.balanceCommand = balanceCommand;
		this.balanceCommand.set(balanceCommand);
	}

	/**
	 * @return the blockCommand
	 */
	public BlockCommand getBlockCommand() {
//		return blockCommand;
		if(this.blockCommand.get()==null){
			BlockCommand Command=new BlockCommand(ip, port, login, password);
			this.blockCommand.set(Command);
			return Command;
		}else {
			return this.blockCommand.get();
		}
	}

	/**
	 * @param blockCommand
	 *            the blockCommand to set
	 */
	public void setBlockCommand(BlockCommand blockCommand) {
//		this.blockCommand = blockCommand;
		this.blockCommand.set(blockCommand);
	}

	/**
	 * @return the grantCommand
	 */
	public GrantCommand getGrantCommand() {
//		return grantCommand;
		if(this.grantCommand.get()==null){
			GrantCommand Command=new GrantCommand(ip, port, login, password);
			this.grantCommand.set(Command);
			return Command;
		}else {
			return this.grantCommand.get();
		}
	}

	/**
	 * @param grantCommand
	 *            the grantCommand to set
	 */
	public void setGrantCommand(GrantCommand grantCommand) {
//		this.grantCommand = grantCommand;
		this.grantCommand.set(grantCommand);
	}

	public void removeGrantCommand(){
		this.grantCommand.remove();
	}

	/**
	 * @return the walletTransactionCommand
	 */
	public WalletTransactionCommand getWalletTransactionCommand() {
//		return walletTransactionCommand;
		if(this.walletTransactionCommand.get()==null){
			WalletTransactionCommand Command=new WalletTransactionCommand(ip, port, login, password);
			this.walletTransactionCommand.set(Command);
			return Command;
		}else {
			return this.walletTransactionCommand.get();
		}
	}

	/**
	 * @param walletTransactionCommand
	 *            the walletTransactionCommand to set
	 */
	public void setWalletTransactionCommand(WalletTransactionCommand walletTransactionCommand) {
//		this.walletTransactionCommand = walletTransactionCommand;
		this.walletTransactionCommand.set(walletTransactionCommand);
	}

	public void removeWalletTransactionCommand(){
		if(this.walletTransactionCommand.get()!=null){
			this.walletTransactionCommand.remove();
		}
	}
	/**
	 * @return the chainCommand
	 */
	public ChainCommand getChainCommand() {
//		return chainCommand;
		if(this.chainCommand.get()==null){
			ChainCommand Command=new ChainCommand(ip, port, login, password);
			this.chainCommand.set(Command);
			return Command;
		}else {
			return this.chainCommand.get();
		}
	}

	public void removeChainCommand(){
		this.chainCommand.remove();
	}

	/**
	 * @param chainCommand
	 *            the chainCommand to set
	 */
	public void setChainCommand(ChainCommand chainCommand) {
//		this.chainCommand = chainCommand;
		this.chainCommand.set(chainCommand);
	}

	public KeyCommand getKeyCommand() {
//		return keyCommand;
		if(this.keyCommand.get()==null){
			KeyCommand Command=new KeyCommand(ip, port, login, password);
			this.keyCommand.set(Command);
			return Command;
		}else {
			return this.keyCommand.get();
		}
	}

	public void setKeyCommand(KeyCommand keyCommand) {
//		this.keyCommand = keyCommand;
		this.keyCommand.set(keyCommand);
	}

	public Integer getChainId() {
		return chainId;
	}

	public ShellChainCommand() {
	}
}
