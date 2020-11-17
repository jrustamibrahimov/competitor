/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import config.Config;
import java.io.Serializable;
import util.ConfigUtil;

/**
 *
 * @author Hp
 */
public class User implements Serializable {
    private String username;
    private String password;
    private int point;
    
    public User(){
        
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, int point) {
        this.username = username;
        this.password = password;
        this.point = point;
    }
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPoint() {
        return point;
    }

    public  void setPoint(int point) {
        this.point = point;
        ConfigUtil.refreshConfig(Config.config);
    }
    
    
    
}
