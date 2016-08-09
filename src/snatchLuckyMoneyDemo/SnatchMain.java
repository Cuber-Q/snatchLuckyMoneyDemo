package snatchLuckyMoneyDemo;

import java.text.DecimalFormat;

public class SnatchMain {
	public DecimalFormat  df = new DecimalFormat("0.00");
	
	public static void main(String[] args){
		System.out.println("snatch lucky money start...");
		new SnatchMain();
	}
	public SnatchMain(){
		LuckyMoney luckyMoney = new LuckyMoney(12,4);
		int count = 5;
		while(count > 0){
			new Snatcher("snatcher-"+count).setLuckyMoney(luckyMoney).start();
			count --;
		}
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("total money is " + df.format(luckyMoney.getTotal()));
		System.out.println("the rest money is " + df.format(luckyMoney.getRest()));
	}
	public  double snatch(LuckyMoney money){
		while(null == money){
			
		}
		return money.snatch();
	}
	
	public  void print(double snatchedMoney, String name){
		if(snatchedMoney > 0)
			System.out.println(name + " snatched " + df.format(snatchedMoney));
		else
			System.out.println(name + " is slow, got nothing~");
	}
	
	class Snatcher extends Thread{
		private LuckyMoney luckyMoney;
		public String name;
		public Snatcher(String name){
			this.name = name;
		}
		public Snatcher setLuckyMoney(LuckyMoney money){
			this.luckyMoney = money;
			return this;
		}
		@Override
		public void run(){
			print(snatch(luckyMoney),name);
		}
	}
	
}

