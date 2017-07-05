package tw.dou.servlet;

public class testfilename {

	public static void main(String[] args) {
		String header = "form-data; name=\"sfileupload\"; filename=\"C:\\Users\\Yujen\\Desktop\\url.txt\"";
		int start = header.indexOf("filename");
		System.out.println("start: " + start);
		
		String temp = header.substring(start+10);
		System.out.println("temp: " + temp);
		
		String filename = temp.substring(0, temp.lastIndexOf("\""));
		System.out.println("filename: " + filename);
		
		
		int s1 = filename.lastIndexOf("\\");
		System.out.println(s1);
		
		String sfile = null;
		if(s1>=0) {
			sfile = filename.substring(filename.lastIndexOf("\\")+1);
		}else {
			sfile = filename;
		}
		System.out.println(sfile);
	}

}
