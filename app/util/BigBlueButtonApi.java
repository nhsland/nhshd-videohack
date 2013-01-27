package util;

import java.io.IOException;

public interface BigBlueButtonApi {
	String create(String meetingID) throws IOException;
	String join(String meetingID, String fullName, String password) throws IOException;
}
