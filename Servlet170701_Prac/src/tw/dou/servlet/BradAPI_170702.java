package tw.dou.servlet;
//catch filename for 014 & 015
public class BradAPI_170702 {

	public static String getHeaderFileName(String header) {
		int start = header.indexOf("filename");
		String temp = header.substring(start+10);
		String filename = temp.substring(0, temp.lastIndexOf("\""));
		
		int s1 = filename.lastIndexOf("\\");
		String sfile = null;
		if(s1>=0) {
			sfile = filename.substring(filename.lastIndexOf("\\")+1);
		}else {
			sfile = filename;
		}
		
		return sfile;
	}
		

	

}
