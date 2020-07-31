/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * ShellChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/ShellChainJavaAPI/blob/master/LICENSE
 *
 */
package com.ustb.shellchain.command.builders;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;
import com.ustb.shellchain.command.ShellChainException;
import com.ustb.shellchain.object.ShellChainRPCAnswer;
import com.ustb.shellchain.object.formatters.GsonFormatters;
import org.apache.http.HttpEntity;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * @author Ub - H. MARTEAU & Jagrut KOSTI
 * @version 4.3
 */
abstract class QueryBuilderCommon extends GsonFormatters {

	private CloseableHttpClient httpclient = null;
	private HttpPost httppost = null;

	protected enum CommandEnum {
								ADDMULTISIGADDRESS,
								ADDNODE,
								APPENDRAWCHANGE,
								APPENDRAWEXCHANGE,
								APPENDROWMETADA,
								CLEARMEMPOOL,
								COMBINEUNPSENT,
								CREATE,
								CREATEFROM,
								CREATEKEYPAIRS,
								CREATEMULTISIG,
								CREATERAWEXCHANGE,
								CREATERAWSENDFROM,
								CREATERAWTRANSACTION,
								DECODERAWEXCHANGE,
								DECODERAWTRANSACTION,
								DISABLERAWTRANSACTION,
								DUMPPRIVKEY,
								EXECUTECONTRACT,
								GETADDRESSBALANCES,
								GETADDRESSES,
								GETADDRESSTRANSACTION,
								GETASSETBALANCES,
								GETBESTBLOCKHASH,
								GETBLOCK,
								GETBLOCKCHAININFO,
								GETBLOCKCHAINPARAMS,
								GETBLOCKCOUNT,
								GETBLOCKHASH,
								GETINFO,
								GETMULTIBALANCES,
								GETNEWADDRESS,
								GETRAWCHANGEADDRESS,
								GETPEERINFO,
								GETRAWTRANSACTION,
								GETSTREAMITEM,
								GETTOTALBALANCES,
								GETTRANSACTION,
								GETTXOUT,
								GETTXOUTDATA,
								GETUNCONFIRMEDBALANCE,
								GETWALLETTRANSACTION,
								GRANT,
								GRANTFROM,
								GRANTWITHMETADATA,
								GRANTWITHMETADATAFROM,
								HELP,
								IMPORTADDRESS,
								IMPORTPRIVKEY,
								ISSUE,
								ISSUEFROM,
								ISSUEMORE,
								ISSUEMOREFROM,
								LISTADDRESSTRANSACTIONS,
								LISTASSETS,
								LISTBLOCKS,
								LISTLOCKUNPSENT,
								LISTPERMISSIONS,
								LISTSTREAMITEMS,
								LISTSTREAMKEYITEMS,
								LISTSTREAMKEYS,
								LISTSTREAMPUBLISHERS,
								LISTSTREAMPUBLISHERITEMS,
								LISTSTREAMS,
								LISTUNSPENT,
								LISTWALLETTRANSACTIONS,
								LOCKUNSPENT,
								PAUSE,
								PING,
								PREPARELOCKUNSPENT,
								PREPARELOCKUNSPENTFROM,
								PUBLISH,
								PUBLISHFROM,
								RESUME,
								REVOKE,
								REVOKEFROM,
								SENDASSETFROM,
								SENDASSETTOADDRESS,
								SENDCUSTOM,
								SENDFROM,
								SENDFROMADDRESS,
								SENDRAWTRANSACTION,
								SENDTOADDRESS,
								SENDWITHMETADATA,
								SENDWITHMETADATAFROM,
								SETLASTBLOCK,
								SIGNMESSAGE,
								SIGNRAWTRANSACTION,
								STOP,
								SUBSCRIBE,
								UNSUBSCRIBE,
								VALIDATEADDRESS,
								VERIFYMESSAGE,
								SENDWITHDATA,
								SENDWITHDATAFROM,
								ISSUEENTITY,
								ISSUEENTITYFROM,
								CREATEENTITY,
								REQUESTENTITY,
								REGISTEROBJECT,
								UPDATEOBJECT,
								REGISTERTORT,
								UPDATETORT,
	}

	protected void initialize(String ip, String port, String login, String password) {
		PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
		httppost = new HttpPost("http://" + ip + ":" + port);

		CredentialsProvider provider = new BasicCredentialsProvider();
		UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(login, password);
		provider.setCredentials(AuthScope.ANY, credentials);
		//PoolingHttpClientConnectionManager cm=ApplicationUtil.getBean("poolingHttpClientConnectionManager");
		httpclient = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).setConnectionManager(cm).build();

	}

	/**
	 * 
	 * @param command
	 * @param parameters
	 * 
	 * @return
	 * 
	 * 		example :
	 *         ShellChainQueryBuidlder.executeProcess(ShellChainCommand
	 *         .SENDTOADDRESS,"1EyXuq2JVrj4E3CpM9iNGNSqBpZ2iTPdwGKgvf
	 *         {\"rdcoin\":0.01}"
	 * @throws ShellChainException
	 */
	protected Object execute(CommandEnum command, Object... parameters) throws ShellChainException {

		if (httpclient != null && httppost != null) {
			try {
				// Generate Mapping of calling arguments
				Map<String, Object> entityValues = prepareMap(command, parameters);
				// Generate the entity and initialize request
				StringEntity rpcEntity = prepareRpcEntity(entityValues);
				httppost.setEntity(rpcEntity);
				// Execute the request and get the answer
				return executeRequest();

			} catch (IOException e) {
				e.printStackTrace();
				throw new ShellChainException(null, e.toString());
			}
		} else {
			throw new ShellChainException("Initialization Problem",
					"ShellChainCommand not initialized, please specify ip, port, user and pwd !");

		}
	}

	protected StringEntity prepareRpcEntity(Map<String, Object> entityValues) throws UnsupportedEncodingException {
		return new StringEntity(formatJson(entityValues));
	}

	private Object executeRequest() throws IOException, ClientProtocolException, ShellChainException {
		CloseableHttpResponse response=null;
		HttpEntity httpEntity=null;
		try{
			response = httpclient.execute(httppost);
			httpEntity=response.getEntity();
//		int statusCode = response.getStatusLine().getStatusCode();
			String rpcAnswer = EntityUtils.toString(httpEntity,"UTF-8");

//		if (statusCode >= 400) {
//			final Gson gson = new GsonBuilder().create();
//			final ShellChainRPCAnswer shellChainRPCAnswer = gson.fromJson(rpcAnswer, ShellChainRPCAnswer.class);
//			throw new ShellChainException("code :" + statusCode,
//					"message : " + response.getStatusLine().getReasonPhrase());
//		}
			int statusCode = response.getStatusLine().getStatusCode();
			final Gson gson = new GsonBuilder().create();
			final ShellChainRPCAnswer shellChainRPCAnswer = gson.fromJson(rpcAnswer, ShellChainRPCAnswer.class);
			if (statusCode >= 400) {
				if (shellChainRPCAnswer != null && shellChainRPCAnswer.getError() == null) {
					return shellChainRPCAnswer.getResult();
				} else if (shellChainRPCAnswer != null && shellChainRPCAnswer.getError() != null) {
					throw new ShellChainException("code :" + shellChainRPCAnswer.getError().get("code").toString(),
							"message : " + shellChainRPCAnswer.getError().get("message").toString());
				} else {
					throw new ShellChainException("code :" + statusCode,
							"message : " + response.getStatusLine().getReasonPhrase());
				}
			}
			//String rpcAnswer = EntityUtils.toString(entity);
//		final Gson gson = new GsonBuilder().create();
//		final ShellChainRPCAnswer shellChainRPCAnswer = gson.fromJson(rpcAnswer, ShellChainRPCAnswer.class);

			if (shellChainRPCAnswer != null && shellChainRPCAnswer.getError() == null) {
				return shellChainRPCAnswer.getResult();
			} else if (shellChainRPCAnswer != null && shellChainRPCAnswer.getError() != null) {
				throw new ShellChainException("code :" + shellChainRPCAnswer.getError().get("code").toString(),
						"message : " + shellChainRPCAnswer.getError().get("message").toString());
			} else {
				throw new ShellChainException(null, "General RPC Exceution Technical Error");
			}

		}finally {
			if(response!=null){
				response.close();
			}
			if(httpEntity!=null){
				EntityUtils.consume(httpEntity);
			}

		}


	}

	private Map<String, Object>  prepareMap(CommandEnum command, Object... parameters) {
		Map<String, Object> entityValues = new HashMap<String, Object>();
		entityValues.put("id", UUID.randomUUID().toString());
		entityValues.put("method", command.toString().toLowerCase());
		List<Object> paramList = new ArrayList<Object>(Arrays.asList(parameters));
		entityValues.put("params", paramList);
		return entityValues;
	}

	@SuppressWarnings("rawtypes")
	protected boolean verifyInstance(Object obj, Class TheClass) {
		return TheClass.isInstance(obj);
	}

	@SuppressWarnings("rawtypes")
	protected boolean verifyInstanceofList(List<Object> obj, Class TheClass) {
		boolean verify = true;

		// Verify only the first Element of the list
		if (obj.size() > 0) {
			Object objElt = obj.get(0);
			if (!LinkedTreeMap.class.isInstance(objElt)) {
				verify = TheClass.isInstance(objElt);
			}
		}

		return verify;
	}

}
