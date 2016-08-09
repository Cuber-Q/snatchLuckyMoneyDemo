package snatchLuckyMoneyDemo;

import java.util.Random;

public  class LuckyMoney {
	private double total; 	//红包总金额
	private double rest;	//红包剩余金额
	private int number;		//红包总个数
	private Random random;
	public LuckyMoney(final double total,final int number){
		this.total = total;
		this.number = number;
		this.rest = this.total;
		this.random = new Random();
	}
	
	public double snatch(){
		//来晚啦，红包抢光啦
		if(rest == 0 || number == 0)
			return -1;
		double snatchedMoney = 0;
		synchronized (this) {
			if(number > 0 && rest > 0){
				if(number == 1){
					number = 0;
					return rest;	//只剩一个红包，不再分
				}
				snatchedMoney = random.nextDouble() * rest;
				rest -= snatchedMoney;
				number -= 1;
			}
		}
		return snatchedMoney;
	}
	
	public double getTotal(){
		return this.total;
	}
	public double getRest(){
		return this.rest;
	}
}
