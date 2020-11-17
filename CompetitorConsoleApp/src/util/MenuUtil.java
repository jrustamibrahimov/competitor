/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import beans.Competitor;
import config.Config;
import java.util.Scanner;

/**
 *
 * @author Hp
 */
public class MenuUtil {
    public static int showMenu(){
        System.out.println("Please select menu:");
        String menuStr="1-Yarishmachilari daxil edin\n"+
                       "2-Yarismaya basla\n"+
                       "3-Xalini oyren\n"+
                       "4-Istirakchilarin sayini artir\n"+
                       "5-Yarismachilara bax\n"+
                       "6-Logout\n";
        System.out.println(menuStr);
        System.out.println("Enter the menu number");
        Scanner sc=new Scanner(System.in);
        int selectedMenu=sc.nextInt();
        if(selectedMenu>0&&selectedMenu<7){
        return selectedMenu;
        }else{
            System.out.println("Invalid menu selected");
            return -1;
        }
    }
    public static int showMenuInfinite(){
       while(true){
       int selectedMenu=showMenu();
        if(selectedMenu==1){
          CompetitionUtil.registerCompetitorsAndShowInfo();
      }else if(selectedMenu==2){
          CompetitionUtil.startCompetition();
      }else if(selectedMenu==3){
          CompetitionUtil.showPoint();
      }else if(selectedMenu==4){
         CompetitionUtil.increaseCompetitors();
      }else if(selectedMenu==5){
         CompetitionUtil.printCompetitors();
      }else if(selectedMenu==6){
          
          UserUtil.requireInputsAndLogin(3, true);
      }
      }  
    }
    
}
