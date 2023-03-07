import java.util.Scanner;

public class Game {
	
Player player;
Location location;
Scanner scan = new Scanner(System.in);

public void login() {
	
	Scanner scan = new Scanner(System.in);
	System.out.println("MACERA OYUNUNA HOŞGELDİNİZ !");
	System.out.print("Oyuna Başlamadan Önce Adınızı Giriniz ");
	String playerName = scan.nextLine();
	player = new Player(playerName);
	player.selectCha();
	start();
}
public void start() {
	
	while(true) {
	
	System.out.println();
	System.out.println("=============================");
	System.out.println();
	System.out.println("Lütfen bir yer seçin : ");
	System.out.println("1-Güvenli Ev ----> size ait güvenli mekan (Düşman yok) ");
	System.out.println("2-Mağara     ----> karşınıza zombi çıkabilir!");
	System.out.println("3-Orman      ----> karşınıza vampir çıkabilir!");
	System.out.println("4-Nehir      ----> karşınıza ayı çıkabilir!");
	System.out.println("5-Mağaza     ----> silah ve zırh alabilirsiniz ");
	System.out.println("Gitmek istediğiniz yer ? ");
	
	int selLoc=scan.nextInt();
	while (selLoc < 0 || selLoc > 5) {
		
		System.out.println("lütfen geçerli bir değer giriniz..");
		selLoc=scan.nextInt();
	}
	
	switch(selLoc) {
	
	case 1 :
		location=new SafeHouse(player);
		break;
	case 2 :
		location=new Cave(player);
		break;
		
	case 5 :
		location=new ToolStore(player);
		break;
		
		default :
			location=new SafeHouse(player);
			
	}
	
	location.getLocation();
}
}


}
