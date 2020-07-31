/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * ShellChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/ShellChainJavaAPI/blob/master/LICENSE
 *
 */
package com.ustb.shellchain.object;

import com.ustb.shellchain.command.ShellChainException;
import com.ustb.shellchain.command.tools.ShellChainTestParameter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ub - H. MARTEAU
 * @version 1.0
 */
public class AddressBalanceAsset {
	String address;
	List<BalanceAssetBase> assets;

	public AddressBalanceAsset() {
		assets = new ArrayList<BalanceAssetBase>();
	}

	public void isFilled() throws ShellChainException {
		ShellChainTestParameter.isNotNullOrEmpty("address", address);
		for (BalanceAssetBase asset : assets) {
			asset.isFilled();
		}
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the assets
	 */
	public List<BalanceAssetBase> getAssets() {
		return assets;
	}

	/**
	 * @param assets the assets to set
	 */
	public void setAssets(List<BalanceAssetBase> assets) {
		this.assets = assets;
	}

	public void addAsset(BalanceAssetBase asset) {
		if (asset != null) {
			this.assets.add(asset);
		}
	}


}
