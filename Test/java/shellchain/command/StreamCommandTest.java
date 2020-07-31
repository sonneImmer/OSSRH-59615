/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * ShellChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/ShellChainJavaAPI/blob/master/LICENSE
 *
 */
package shellchain.command;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.ustb.shellchain.command.ShellChainCommand;
import com.ustb.shellchain.command.ShellChainException;
import com.ustb.shellchain.object.Stream;
import com.ustb.shellchain.object.StreamKey;
import com.ustb.shellchain.object.StreamKeyItem;

/**
 * @author Ub - H. MARTEAU
 * @version 1.1
 */
public class StreamCommandTest {
	static ShellChainCommand shellChainCommand;

	static String streamName = "";

	/**
	 *
	 */
	public StreamCommandTest() {
		// TODO Auto-generated constructor stub
	}

	private static void testlistStreams() {
		List<Stream> result = null;
		System.out.println("testlistStreams :");
		try {
			System.out.println("Stream *");
			result = shellChainCommand.getStreamCommand().listStreams("*");
		} catch (ShellChainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Result :");
		for (Stream stream : result) {
			System.out.println("   Stream :");
			System.out.println(stream.toString());
		}
		System.out.println();
		System.out.println();
		System.out.println();

		try {
			System.out.println("Stream * true");
			result = shellChainCommand.getStreamCommand().listStreams("*", true);
		} catch (ShellChainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Result :");
		for (Stream stream : result) {
			System.out.println("   Stream :");
			System.out.println(stream.toString());
		}
		System.out.println();
		System.out.println();
		System.out.println();

		try {
			System.out.println("Stream * true 1");
			result = shellChainCommand.getStreamCommand().listStreams("*", true, 1);
		} catch (ShellChainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Result :");
		for (Stream stream : result) {
			System.out.println("   Stream :");
			System.out.println(stream.toString());
		}
		System.out.println();
		System.out.println();
		System.out.println();

		try {
			System.out.println("Stream * true 1 0");
			result = shellChainCommand.getStreamCommand().listStreams("*", true, 1, 0);
		} catch (ShellChainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Result :");
		for (Stream stream : result) {
			System.out.println("   Stream :");
			System.out.println(stream.toString());
		}
	}

	private static void testcreate() {
		String result = "";
		System.out.println("testcreate :");
		try {

			result = shellChainCommand.getStreamCommand().create(streamName);
		} catch (ShellChainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == null || "".equals(result)) {
			System.err.println("testcreate - result is empty");
		} else {
			System.out.println("Result :");
			System.out.println(result);
		}
	}

	private static void testpublish() {
		String result = "";
		System.out.println("testpublish :");
		try {
			result = shellChainCommand.getStreamCommand().publish(streamName, "StreamKey", "0123456789abcdef");

			for (int i = 0; i < 10; i++) {
				shellChainCommand.getStreamCommand().publish(streamName, "StreamKey-1",
						"10abcdef01234567890" + String.valueOf(i));
			}
			for (int i = 0; i < 10; i++) {
				shellChainCommand.getStreamCommand().publish(streamName, "StreamKey-2",
						"20abcdef01234567890" + String.valueOf(i));
			}
			for (int i = 0; i < 10; i++) {
				shellChainCommand.getStreamCommand().publish(streamName, "StreamKey-3",
						"30abcdef01234567890" + String.valueOf(i));
			}
		} catch (ShellChainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == null || "".equals(result)) {
			System.err.println("testpublish - result is empty");
		} else {
			System.out.println("Result :");
			System.out.println(result);
		}

	}

	private static void testsubscribe() {
		System.out.println("testsubscribe :");
		try {

			shellChainCommand.getStreamCommand().subscribe(streamName);
		} catch (ShellChainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Result : done !");
	}

	private static void testunsubscribe() {
		System.out.println("testunsubscribe :");
		try {

			shellChainCommand.getStreamCommand().unsubscribe(streamName);
		} catch (ShellChainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Result : done !");
	}

	private static void testlistStreamKeys() {
		List<StreamKey> result = null;
		System.out.println("testlistStreamKeys :");
		try {
			System.out.println("StreamKey " + streamName);
			result = shellChainCommand.getStreamCommand().listStreamKeys(streamName);
		} catch (ShellChainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == null || result.size() == 0) {
			System.err.println("testcreate - result list is null or empty");
		} else {
			System.out.println("Result :");
			for (StreamKey item : result) {
				System.out.println("   Key :");
				System.out.println(item.toString());
			}
		}
		System.out.println();
		System.out.println();
		System.out.println();

		try {
			System.out.println("StreamKey " + streamName + " StreamKey");
			result = shellChainCommand.getStreamCommand().listStreamKeys(streamName, "StreamKey");
		} catch (ShellChainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == null || result.size() == 0) {
			System.err.println("testcreate - result list is null or empty");
		} else {
			System.out.println("Result :");
			for (StreamKey item : result) {
				System.out.println("   Key :");
				System.out.println(item.toString());
			}
		}
		System.out.println();
		System.out.println();
		System.out.println();

		try {
			System.out.println("StreamKey " + streamName + " StreamKey true");
			result = shellChainCommand.getStreamCommand().listStreamKeys(streamName, "StreamKey", true);
		} catch (ShellChainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == null || result.size() == 0) {
			System.err.println("testcreate - result list is null or empty");
		} else {
			System.out.println("Result :");
			for (StreamKey item : result) {
				System.out.println("   Key :");
				System.out.println(item.toString());
			}
		}
		System.out.println();
		System.out.println();
		System.out.println();

		try {
			System.out.println("StreamKey " + streamName + " StreamKey false");
			result = shellChainCommand.getStreamCommand().listStreamKeys(streamName, "StreamKey", false);
		} catch (ShellChainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == null || result.size() == 0) {
			System.err.println("testcreate - result list is null or empty");
		} else {
			System.out.println("Result :");
			for (StreamKey item : result) {
				System.out.println("   Key :");
				System.out.println(item.toString());
			}
		}
		System.out.println();
		System.out.println();
		System.out.println();

		try {
			System.out.println("StreamKey " + streamName + " * false 1");
			result = shellChainCommand.getStreamCommand().listStreamKeys(streamName, "*", false, 1);
		} catch (ShellChainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == null || result.size() == 0) {
			System.err.println("testcreate - result list is null or empty");
		} else {
			System.out.println("Result :");
			for (StreamKey item : result) {
				System.out.println("   Key :");
				System.out.println(item.toString());
			}
		}
		System.out.println();
		System.out.println();
		System.out.println();

		try {
			System.out.println("StreamKey " + streamName + " * false 1 1");
			result = shellChainCommand.getStreamCommand().listStreamKeys(streamName, "*", false, 1, 1);
		} catch (ShellChainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == null || result.size() == 0) {
			System.err.println("testcreate - result list is null or empty");
		} else {
			System.out.println("Result :");
			for (StreamKey item : result) {
				System.out.println("   Key :");
				System.out.println(item.toString());
			}
		}
		System.out.println();
		System.out.println();
		System.out.println();

	}

	private static void testlistStreamKeyItems() {
		List<StreamKeyItem> result = null;
		System.out.println("testlistStreamKeyItems :");
		try {
			System.out.println("StreamKey " + streamName + " StreamKey-1");
			result = shellChainCommand.getStreamCommand().listStreamKeyItems(streamName, "StreamKey-1");
		} catch (ShellChainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == null || result.size() == 0) {
			System.err.println("testcreate - result list is null or empty");
		} else {
			System.out.println("Result :");
			for (StreamKeyItem item : result) {
				System.out.println("   Key :");
				System.out.println(item.toString());
			}
		}
		System.out.println();
		System.out.println();
		System.out.println();

		try {
			System.out.println("StreamKey " + streamName + " StreamKey-1 true");
			result = shellChainCommand.getStreamCommand().listStreamKeyItems(streamName, "StreamKey-1", true);
		} catch (ShellChainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == null || result.size() == 0) {
			System.err.println("testcreate - result list is null or empty");
		} else {
			System.out.println("Result :");
			for (StreamKeyItem item : result) {
				System.out.println("   Key :");
				System.out.println(item.toString());
			}
		}
		System.out.println();
		System.out.println();
		System.out.println();

		try {
			System.out.println("StreamKey " + streamName + " StreamKey-1 false");
			result = shellChainCommand.getStreamCommand().listStreamKeyItems(streamName, "StreamKey-1", false);
		} catch (ShellChainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == null || result.size() == 0) {
			System.err.println("testcreate - result list is null or empty");
		} else {
			System.out.println("Result :");
			for (StreamKeyItem item : result) {
				System.out.println("   Key :");
				System.out.println(item.toString());
			}
		}
		System.out.println();
		System.out.println();
		System.out.println();

		try {
			System.out.println("StreamKey " + streamName + " * false 1");
			result = shellChainCommand.getStreamCommand().listStreamKeyItems(streamName, "*", false, 1);
		} catch (ShellChainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == null || result.size() == 0) {
			System.err.println("testcreate - result list is null or empty");
		} else {
			System.out.println("Result :");
			for (StreamKeyItem item : result) {
				System.out.println("   Key :");
				System.out.println(item.toString());
			}
		}
		System.out.println();
		System.out.println();
		System.out.println();

		try {
			System.out.println("StreamKey " + streamName + " * false 1 1");
			result = shellChainCommand.getStreamCommand().listStreamKeyItems(streamName, "*", false, 1, 1);
		} catch (ShellChainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == null || result.size() == 0) {
			System.err.println("testcreate - result list is null or empty");
		} else {
			System.out.println("Result :");
			for (StreamKeyItem item : result) {
				System.out.println("   Key :");
				System.out.println(item.toString());
			}
		}
		System.out.println();
		System.out.println();
		System.out.println();

	}
	private static void testgetStreamItem() {
		String result = "";
		System.out.println("testgetStreamItem :");
		try {

			StreamKeyItem streamKeyItem = shellChainCommand.getStreamCommand().getStreamItem("TestAPI1181117085139","cf4b54461517381b85f8a5f748ded85a866b2f7c11609b1769510ef4e71ae813",true);
			result=streamKeyItem.toString();
		} catch (ShellChainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == null || "".equals(result)) {
			System.err.println("testgetStreamItem - result is empty");
		} else {
			System.out.println("Result :");
			System.out.println(result);
		}
	}



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("--- Start of StreamCommandTest ---");

		// BlockChain TestCommand has to be created and started before
		shellChainCommand = new ShellChainCommand(TestConst.MULTICHAIN_SERVER_IP,TestConst.MULTICHAIN_SERVER_PORT,TestConst.MULTICHAIN_SERVER_LOGIN,TestConst.MULTICHAIN_SERVER_PWD);

		// BlockChain TestCommand has to be created and started before
		// ChainCommand.initializeChain("TestAPI1");
		SimpleDateFormat formater = new SimpleDateFormat("ddMMyyhhmmss");
		streamName = "TestAPI1" + formater.format(new Date());

		testlistStreams();

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

		testcreate();

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

		testsubscribe();

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

		testpublish();

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

		testlistStreamKeys();

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

		testlistStreamKeyItems();

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

		testunsubscribe();

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

		testgetStreamItem();

		System.out.println("--- End of StreamCommandTest ---");
	}

}
