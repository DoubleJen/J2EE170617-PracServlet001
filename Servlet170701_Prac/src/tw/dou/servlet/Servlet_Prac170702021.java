package tw.dou.servlet;
//Model("M"VC)
public class Servlet_Prac170702021 {
	private int x, y;
	
	public Servlet_Prac170702021(String x, String y) {
		this.x = Integer.parseInt(x);
		this.y = Integer.parseInt(y);
	}
	
	public int add() {
		return x+y;
	}
	
}
