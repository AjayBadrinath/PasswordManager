package pasman;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
 * @version :1.0.0
 * @author :Ajay.B
 * Hashing Class -.
 * sha1 -
 * This class is only implemented for the sole purpose of API Query to haveibeenpwned.com as it accepts only 5chars of sha1 hash without salt...
 * Implemented from the  java.security.* library.
 * sha1 constructor input-> string to generate one way hash
 * */
public class sha1 {
	String value;
	public sha1(String value){
		this.value=value;
	}
	public String encrypt() {
		String hashe="";
	try {
		MessageDigest key=MessageDigest.getInstance("SHA-1");
		byte[]digest=key.digest(value.getBytes());
		BigInteger num=new BigInteger(1,digest);
		 hashe=num.toString(16);
		while(hashe.length()<32) {
			hashe="0"+hashe;
		}
		return hashe;
	}catch( NoSuchAlgorithmException e) {
		e.printStackTrace();
	}
	return hashe;
	
	
	}
}
