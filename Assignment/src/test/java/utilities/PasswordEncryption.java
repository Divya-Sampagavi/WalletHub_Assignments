package utilities;

import org.apache.commons.codec.binary.Base64;

public class PasswordEncryption {

	public static void main(final String[] args) {

		String str = "Johnny@123";

		byte[] encodestr = Base64.encodeBase64(str.getBytes());
		System.out.println("String before encode: " + str);
		System.out.println("String after encode: " + new String(encodestr));

		byte[] decodestr = Base64.decodeBase64(encodestr);

		System.out.println("String after decode: " + new String(decodestr));
	}
}
