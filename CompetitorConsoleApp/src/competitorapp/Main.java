/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package competitorapp;

import beans.Competitor;
import beans.User;
import config.Config;
import java.util.Scanner;
import util.CompetitionUtil;
import util.ConfigUtil;
import util.MenuUtil;
import util.UserUtil;

/**
 *
 * @author Hp
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static Config config=null ;
    
    public static void main(String[] args) {
        // TODO code application logic here
        User user=UserUtil.requireInputsAndLogin(3, true);
        
        ConfigUtil.initializeConfig(user);
        System.out.println("Hello mister, "+user.getUsername());
        MenuUtil.showMenuInfinite();
        
      
       
        
    }
    
}
