package util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.digest.DigestUtils;

public class BigBlueButton {
	
	private static final String BBB_SERVER_FORMAT = "http://%s/bigbluebutton/api/";
	
	private String bbb_server_base;
	private String bbb_server_salt;

	public BigBlueButton(String base, String salt) {
		this.bbb_server_base = String.format(BBB_SERVER_FORMAT, base);
		this.bbb_server_salt = salt;
	}

	public String create(String meeting) throws IOException {
		return this.callBbbApi("create", String.format("meetingID=%s&record=true&welcome=blargle", meeting));
	}

	private String callBbbApi(String method, String params) throws IOException {
		try {
			return formatBBBUrl(method, params);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	protected String formatBBBUrl(String method, String params) throws MalformedURLException, NoSuchAlgorithmException, UnsupportedEncodingException{
		String command=String.format("%s?%s", method, params);
		String shaCommand=String.format("%s%s", method, params);
		return String.format("%s%s&checksum=%s",bbb_server_base, command, DigestUtils.shaHex(shaCommand + bbb_server_salt) );
	}

}
