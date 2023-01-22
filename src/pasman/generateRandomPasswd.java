package pasman;


import java.util.Random;
/*
 * Class to generate Random Passwords based on the users' preference 
 * Constructor Inputs password Length ,Level range .
 * Lvl1 ---> Includes only small and capital English alphabets.
 * Lvl2 ---> includes  Alphanumeric cases.
 * Lvl3 ---> Maximal Strength Password Mix of Alphanumeric and Symbols .
 * ranpas()->returns password.
 * */
public class generateRandomPasswd{
	int strength,lvl;
	private String passwd="";																				//String to be returned
	String chars="qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890!@#$%^&*(){}<>?:~`-+=[]|";	//All available charecters.
	generateRandomPasswd(int strength,int lvl){
		this.strength=strength;
		this.lvl=lvl;
	}
	public String ranpas() {
		
		Random r=new Random();																				//Random number Generation
		if(lvl==1) {
			for(int i=0;i<strength;i++) {
				
				int k=r.nextInt()%52;
				if(k<0) {k=-k;}
				passwd+=chars.charAt(k);
			}
			
			return passwd;
		}
		if(lvl==2) {
			for(int i=0;i<strength;i++) {
				
				int k=r.nextInt()%62;
				if(k<0) {k=-k;}
				passwd+=chars.charAt(k);
			}
			return passwd;
		}
		
		for(int i=0;i<strength;i++) {
			
			int k=r.nextInt()%chars.length();
			if(k<0) {k=-k;}
			passwd+=chars.charAt(k);
		}
		return passwd;
		
	}
}