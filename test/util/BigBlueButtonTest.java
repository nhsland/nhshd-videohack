package util;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import util.BigBlueButton;


public class BigBlueButtonTest {

	private static final String BBB_SERVER = "192.168.190.194";
	private static final String BBB_SERVER_SALT = "cb357f07e25eaaa116dde56fd9411a6c";
	
	private static BigBlueButton bbb_api;

	@BeforeClass
	public static void setUp() throws Exception {
		bbb_api = new BigBlueButton(BBB_SERVER,BBB_SERVER_SALT);
	}

	@AfterClass
	public static void tearDown() throws Exception {
		bbb_api = null;
	}

	@Test
	public void BbbUrlUpToChecksumTest() throws MalformedURLException, NoSuchAlgorithmException, UnsupportedEncodingException{
		String ret = bbb_api.formatBBBUrl("create", "meetingID=helloworld2&record=true&welcome=blargle");
		System.out.println(ret);
		assertEquals("URL does not return correctly",
				String.format("http://%s/bigbluebutton/api/create?&meeting=helloworld2%s&checksum=",BBB_SERVER,BBB_SERVER_SALT),
				ret.subSequence(0, ret.length()-11));
	}

}
