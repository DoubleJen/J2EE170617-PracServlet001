package tw.brad.Bean;

/*
 * JavaBean為滿足以下條件的純粹Java物件：
 * 1. 必須實做java.io.Serializable介面
 * 2. 無public類別變數
 * 3. 具無傳參數建構式
 * 		(無定義任何建構式時，編譯器會自動幫你加上一個無引數沒有任何內容的建構式)
 * 4. 具public的setXxx()與getXxx()方法
 * */

public class MemberBean170709 {
	private String id, name;
	
	public MemberBean170709() {
		System.out.println("MEMBER()");
	}
	
	public MemberBean170709(String id, String name) {
		System.out.println("MEMBER(String, String)");
		this.id=id; this.name=name;
	}
	
	public void setId(String id) {this.id=id;}
	public void setName(String name) {this.name=name;}
	public String getId() {return id;}
	public String getName() {return name;}
	
	public void m1() {
		System.out.println("MEMBER.m1()");
	}
	
	@Override
	public String toString() {
		return id + " : " + name;
	}
}
