package tw.dou.j2ee;

public class Dou170702021 {
	private int x, y;
	
	public Dou170702021(String x, String y) {
		this.x = Integer.parseInt(x);
		this.y = Integer.parseInt(y);
	}
	
	public int add() {	
		return x+y;
	}
}
