/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import beans.Competitor;
import beans.User;
import config.Config;
import java.awt.BorderLayout;
import java.util.Scanner;

/**
 *
 * @author Hp
 */
public class CompetitionUtil {
 
    public static Competitor [] registrCompetitors(){
     Scanner sc=new Scanner(System.in);
     System.out.println("How many competitors will be in competition");
     int competitorCount=sc.nextInt();
     Competitor [] competitors=new Competitor[competitorCount];
     for(int i=0;i<competitorCount;i++){
         Competitor competitor=registrCompetitor();
         competitors[i]=competitor;
     }
      Config.config.setCompetitors(competitors);
        System.out.println("All competitors successfully registered");
     return competitors;
    }
    public static Competitor registrCompetitor(){
      Scanner sc=new Scanner(System.in);
      System.out.println("Competitor name:");  
      String name=sc.nextLine();
      System.out.println("Competitor surname:");  
      String surname=sc.nextLine();
      System.out.println("Competitor age:");  
      int age=sc.nextInt();
      Competitor competitor=new Competitor(name,surname,age);
      return competitor;
    }
    public static  void printCompetitors(Competitor []competitors){
       if(competitors==null||competitors.length==0){
           System.out.println("Yarismachi daxil edilmeyib,menu duymesine qayidin");
           return;
       }
       for(int i=0;i<competitors.length;i++){
           System.out.println(competitors[i]);
       }
    }
    public static  void printCompetitors(){
        printCompetitors(Config.config.getCompetitors());
    }
    public static Competitor [] registerCompetitorsAndShowInfo(){
        Competitor []competitors=registrCompetitors();
        CompetitionUtil.printCompetitors(competitors);
        return competitors;
    }
    public static boolean startCompetition(){
        Competitor []competitors=Config.config.getCompetitors();
        if(competitors==null){
            System.out.println("Siz yarismachilari daxil etmemisiniz.");
            CompetitionUtil.registerCompetitorsAndShowInfo();
        }
        int winner=2;
        System.out.println("Guess winner?");
        Scanner sc=new Scanner(System.in);
        int guessedWinner=sc.nextByte();
        if(winner==guessedWinner){
            increasePoint();
            System.out.println("You won!Your point increase to "+Config.config.getUser().getPoint());
            return true;
        }else{
            System.out.println("You failed!");
            return false;
        }
    }
    public static void increasePoint(){
         User user=Config.config.getUser();
         user.setPoint(user.getPoint()+10);
        
    }
     public static void showPoint(){
         System.out.println("Your point "+Config.config.getUser().getPoint());
     }
     public static Competitor[] increaseCompetitors(){
         Competitor[]competitors=Config.config.getCompetitors();
         if(competitors.length==0){
             System.out.println("Hec bir yarismachi yoxdur,siz evvelce yarismachilari elave edin."); 
             registerCompetitorsAndShowInfo();
        //Burda ne edim ki, proses davam etmesin yeniden menu-ya atsin
         }
         Competitor[]competitorsOld=Config.config.getCompetitors();
         Scanner sc=new Scanner(System.in);
         System.out.println("How many competitors participate will append");
         int increaseCount=sc.nextInt();
         Competitor[]competitorsNew=new Competitor[competitorsOld.length+increaseCount]; 
         for(int i=0;i<competitorsOld.length;i++){
            competitorsNew[i]=competitorsOld[i]; 
         }
         for(int i=competitorsOld.length;i<competitorsNew.length;i++){
             competitorsNew[i]=registrCompetitor();
             
         }
         Config.config.setCompetitors(competitorsNew);
         return competitorsNew;
     }
}
