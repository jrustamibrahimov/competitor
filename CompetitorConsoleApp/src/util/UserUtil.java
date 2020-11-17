/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import beans.User;
import config.Config;
import java.util.Scanner;

/**
 *
 * @author Hp
 */
public class UserUtil {
    public static User login(String name,String password){
        if ("Rustam".equals(name)&& "123".equals(password)){
            User user=new User(name, password);
            return user ;
        }
        throw new IllegalArgumentException("Username or password is incorect");
    }
    public static User requireInputsAndLogin(){
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Please type your username:");
        String name=sc.nextLine();
        
        System.out.println("Please type your password:");
        String password=sc.nextLine();
        
        User user=UserUtil.login(name,password);

        return user;
    }
    public static User requireInputsAndLogin(int tryCount,boolean throwException){
     for(int i=0;i<tryCount;i++){
         try{
          User user= requireInputsAndLogin();  
          return user;
         }catch(IllegalArgumentException ex){
             System.out.println(ex.getMessage()); 
             if(i!=tryCount-1){
             System.out.println("Try again");
             }else{
              System.out.println("You failed");
             }
          }
     }
     if(throwException){
         throw new IllegalArgumentException("You have banned");
     }else 
         return null;
    }  
    
}

