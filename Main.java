import java.util.Scanner;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;

public class Main
{
   public static String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
   public static String[] menu = {"SOLAR","PREMIUM","PERTALITE","PERTAMAX","PERTAMAX TURBO"};
   public static double[] priceMinyak = {4500,6500,7500,8500,9500};
   
   public static boolean next(){
   	Scanner go = new Scanner(System.in);
   	String str = go.nextLine();
   	System.out.print("\033[H\033[2J"); 
      System.out.flush();
   	while(!str.equals("N") && !str.equals("n")){
         if (str.equals("Y") || str.equals("y") || str.isEmpty()){
            return true;
         }
         str = go.next();
   	}
   	System.out.print("\033[H\033[2J"); System.out.flush();
      return false;
	}
	
	
	
	public static void main(String[] args) {
	   System.out.println("Team Assignment ke-3 ");
	   System.out.println("Date:"+timeStamp);
      
      Scanner options = new Scanner(System.in);
      do{
         System.out.println("----------------------------[Menu]");
         for(int i=0;i<menu.length;i++){
            System.out.println(i+1+". "+menu[i]);
            System.out.println(" (Rp. "+priceMinyak[i]+"/L)");
         }
         System.out.println("----------------------------");
         System.out.println("a. Pengaturan");
         System.out.println("b. About");
         System.out.println("c. Exit");
         System.out.print("---------------- Select : ");
         char select = options.next().charAt(0);
         switch(select){
            case '1':beli(0);break;
            case '2':beli(1);break;
            case '3':beli(2);break;
            case '4':beli(3);break;
            case '5':beli(4);break;
            case 'a':pengaturan();break;
            case 'b':about();break;
            default:System.out.print("Back Programs? (Y/N)?");break;
         }
      }while(next());
	}
	
	
	static void beli(int bbm){
	   Scanner buy = new Scanner(System.in);
	   System.out.println("[Y] Langsung Pengisian");
	   System.out.println("[N] Tentukan Liter");
	   System.out.print("(Y/N)?");
	   if(next()){
	      System.out.println("Input pengisian BBM dalam nominal Rupiah");
	      System.out.println(menu[bbm]+ ": Rp."+priceMinyak[bbm]+"/L");
	      System.out.print("Bayar Rp.");
	      int cash=buy.nextInt();
	      double oil=cash/(priceMinyak[bbm]/1000);
	      pengisian(oil,bbm);
	   }else{
	      System.out.println("Input pengisian BBM dalam satuan Liter");
	      System.out.println(menu[bbm]+ ": Rp."+priceMinyak[bbm]+"/L");
	      System.out.print("BBM Liter:");
	      double oil=buy.nextInt();
         pengisian(oil*1000,bbm);
	   }
	}
	
	static void pengisian(double oil,int bbm){
   	for (int i = 0; i < oil; i++) {
   	   System.out.print("\033[H\033[2J"); System.out.flush();
      	System.out.println("______________________________[Pengisian]");
      	System.out.print(i+" ml | ");
      	System.out.print("Rp. "+i*(priceMinyak[bbm]/1000));
            try {
            Thread.sleep(4);
            } catch (InterruptedException ie) {
               ie.printStackTrace();
      	}
      }
      System.out.print("\033[H\033[2J"); System.out.flush();
      System.out.println("______________________________[Full]");
      System.out.print(oil+" ml | ");
      System.out.println("Rp. "+oil*(priceMinyak[bbm]/1000));
      System.out.println("______________________________");
      System.out.print("Terimakasih");
	}
	
	static void pengaturan(){
	   System.out.print("\033[H\033[2J"); System.out.flush();
	   System.out.println("----------------------------[Pengaturan]");
	   System.out.println("Update nominal harga BBM per Liter");
	   Scanner price = new Scanner(System.in);
      for(int i=0;i<menu.length;i++){
            System.out.print(i+1+". ("+menu[i]+") Harga baru Rp. ");
            priceMinyak[i] = price.nextInt();
      }
      System.out.print("Simpan? (Y/N)?");
	}
	
	static void about(){
	   System.out.print("\033[H\033[2J"); System.out.flush();
	   System.out.println("Sistem Aplikai BBM Versi 0.1");
	   System.out.println("Programmer:");
	   System.out.println("\n-NADIA FITRIANINGSIH\n-TRI WISNU WARDHANI(2401974831)\n-YUSRI YUNUS\n-DYAS NURLITASARI PERMATA\n");
	   System.out.println("Copyright 2021 Team 6 Member");
	   
	}
	
}
