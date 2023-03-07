import java.util.Scanner;

public abstract class BattleLoc extends Location {
	Scanner scan=new Scanner(System.in);
	protected Obstacle obstacle;

	BattleLoc(Player player,String name,Obstacle obstacle) {
		super(player);
		this.obstacle=obstacle;
		this.name=name;
		
	}
	
	public boolean getLocation() {
		
		Scanner scanner=new Scanner(System.in);
		int obsCount=obstacle.count();
		System.out.println("Şuan buradasınız " + this.getName());
		System.out.println("Dikkatli olun ! "+ obsCount + "tane "+ obstacle.getName()+ "yaşıyor..");
		System.out.println("<S>avaş yada <K>aç ");
		String selCase = scanner.nextLine();
		selCase = selCase.toUpperCase();
		if(selCase.equals("S")) {
			
			if (combat(obsCount)) {
				
				System.out.println(this.getName()+ " bölgesindeki tüm düşmanları temizlediniz ..");
				return true;
				
			}
			
			else {System.out.println("Öldünüz ! "); return false;}
			
		}
		
		return true;
		}

	public boolean combat(int obsCount) {
		
		for(int i=0; i<obsCount; i++ ) {
			
			playerStats();
			enemyStats();
			
			while(player.getHealthy()> 0 && obstacle.getHealth()>0) {
				
				System.out.println("(V)ur veya (K)aç : ");
				
				String selCase=scan.next();
				selCase=selCase.toUpperCase();
				if(selCase.equals("V")) {
					System.out.println("Siz vurdunuz ! ");
					obstacle.setHealth(obstacle.getHealth()-player.getTotalDamage());
					
					afterHit();
					if(obstacle.getHealth()<=0) {
						
						System.out.println();
						System.out.println("Canavar size vurdu ! ");
						System.out.println(player.getHealthy()-(obstacle.getDamage()-player.getInv().getArmor()));
						
						afterHit();
					}

					
					
														
				}
				
				else {break;}
				
			}
			if(obstacle.getHealth()<= 0 && player.getHealthy()>0) {
				
				System.out.println("Tüm düşmanları yendiniz ");
				player.setMoney(player.getMoney()+obstacle.getAward());
				System.out.println("Güncel paranız : "+player.getMoney());
				
				
			}
		}
		
		
		return true;
		
	}
	
	public void afterHit() {
		
		System.out.println("Oyuncu canı : "+player.getHealthy());
		System.out.println(obstacle.getName()+" canı " + obstacle.getHealth());
	}
	
	public void playerStats() {
		
		System.out.println("Oyuncu Değerleri \n-------------------------");
		System.out.println("Can: "+player.getHealthy());
		System.out.println("Hasar: "+player.getTotalDamage());
		System.out.println("Para: "+player.getMoney());
		if(player.getInv().getDamage()>0) {
			System.out.println("Silah "+player.getInv().getwName()); }
			
			if(player.getInv().getArmor()>0) {
				System.out.println("Zırh "+player.getInv().getaName());
		}
	}
	
	public void enemyStats() {
		
		System.out.println(obstacle.getName()+ " Değerleri \n-------------------------");
		System.out.println("Can: " + obstacle.getHealth());
		System.out.println("Hasar: " + obstacle.getDamage());
		System.out.println("Ödül: "+ obstacle.getAward());
	}
	
	
}
