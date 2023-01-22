package pasman;

import java.security.SecureRandom;

import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Hex;

import de.taimos.totp.TOTP;

public class TwoFactorAuth{
	public static String getRan() {
		SecureRandom rval=new SecureRandom();
		
		byte []byteArr=new byte[20];
		rval.nextBytes(byteArr);
		Base32 base32=new Base32();
		base32.encode(byteArr);
		return base32.encodeToString(byteArr);
	}
	public static String getTimeBasedOTP(String SecretKey) {
		byte []bytes=new byte[20];
		Base32 base32=new Base32();
		bytes=base32.decode(SecretKey);
		 String pkey=Hex.encodeHexString(bytes);
		return TOTP.getOTP(pkey);
		
	}
	

}
