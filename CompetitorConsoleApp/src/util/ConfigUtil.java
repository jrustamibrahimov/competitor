/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import beans.User;
import config.Config;
import static config.Config.config;

/**
 *
 * @author Hp
 */
public class ConfigUtil {
    
    public static Config initializeConfig(User user){
        config=new Config();
        
    try{
        Object configObj=FileUtil.readObjectFromFile("ibrahim.txt");
        if(configObj!=null){
          config=(Config)configObj;
        }else{
            config.setUser(user);
        }
    }catch(Exception ex){
     //ignore  
    }
    return config;
    }
    public static void refreshConfig(Config config){
        FileUtil.writeObjectToFile(config,"ibrahim.txt");
    }
    
}
