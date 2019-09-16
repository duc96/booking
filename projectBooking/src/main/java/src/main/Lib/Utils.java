package src.main.Lib;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Utils {
	/**
	 * Generate password
	 * @param txt
	 * @return
	 */
	public static String generatePassword(String txt)
	{
		 // getInstance() method is called with algorithm SHA-512 
        MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-512");
		
System.out.print(txt);
        byte[] messageDigest = md.digest(txt.getBytes()); 

        BigInteger no = new BigInteger(1, messageDigest); 

        String hashtext = no.toString(16); 

        while (hashtext.length() < 32) { 
            hashtext = "0" + hashtext; 
        } 

        return hashtext; 
        
		} catch (NoSuchAlgorithmException e) {
			return txt;
		} 
	}
	
	/**
	 * Generate Token
	 * @return
	 */
	public static String generateToken()
	{
		SecureRandom random = new SecureRandom();
		byte bytes[] = new byte[20];
		random.nextBytes(bytes);
		return bytes.toString();
	}
}
