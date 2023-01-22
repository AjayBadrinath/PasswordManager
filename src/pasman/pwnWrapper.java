package pasman;


import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class pwnWrapper extends pwnedOrNot {
	
	boolean checkVal;
	public boolean assertion=false;
	public pwnWrapper(String shaHash){
		
		super(shaHash);
		
		 checkVal=super.check();
		 if(checkVal) {
			 //System.out.println("Password is breached Kindly Try someother Password");
			 //System.out.println();
			 assertion=true;
		 }
		 else {
			 //System.out.println("Cool!This password looks good!");
			 assertion=false;
		 }
		
	}
}
 class pwnedOrNot implements checkpwn{
	String passwd;
	
	pwnedOrNot(String passwd){
		this.passwd=passwd;
	}
	
	public boolean check()  {
		String url=apiget.concat(passwd.substring(0,5));
		try {
			
		URL resource=new URL(url);
		URLConnection conn=resource.openConnection();
		
			InputStream s=conn.getInputStream();
			byte[] arr=s.readAllBytes();
			
			
			String op=new String(arr);
			op+="\r\n";
			op.stripTrailing();
			
			String reparse="";
			
			char []arr1=op.toCharArray();
			s.close();
			for(int i=0;i<arr1.length;i++) {
				if(arr1[i]==':') {
					while(arr1[i]!='\r') {
						i++;
					}
					reparse+='\n';
					
					//System.out.println();
				}
				reparse+=arr1[i];
				//System.out.print(arr1[i]);
			}
			//System.out.print(reparse);
			String otherhalf=passwd.substring(5);
			System.out.println(otherhalf);
			if(reparse.contains(otherhalf.toUpperCase())) {
				return true;
			}	
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
}
