package basics;

public class Indian_traffic implements Central_Traffic , Europe_Traffic{
	
	
	
	
	public static void main(String[] args) {
		
		Central_Traffic a = new Indian_traffic();
		a.Red_Stop();
		a.green_go();
		a.yellow_wait();
		
		Europe_Traffic b = new Indian_traffic();
		b.zebracrossing();
		
		Indian_traffic c = new Indian_traffic();
		c.symbols();
	}

	@Override
	public void Red_Stop() {
		
		System.out.println("you have to stop when u see the red light");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void green_go() {
		System.out.println("you have to go when u see the green light");
		
	}

	@Override
	public void yellow_wait() {
		System.out.println("you have to wait when u see the yellow light");
		
	}

	@Override
	public void zebracrossing() {
		System.out.println("people can use this while crossing the road");
	}

	public void symbols() {
		System.out.println("follow them accordingly");
	}
}
