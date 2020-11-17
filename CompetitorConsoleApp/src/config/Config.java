/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import beans.Competitor;
import beans.User;
import java.io.Serializable;
import util.ConfigUtil;
import util.FileUtil;

/**
 *
 * @author Hp
 */
public class Config implements Serializable {
    public static Config config=null;
    
    private User user=null;
    private Competitor [] competitors=null;
    
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        ConfigUtil.refreshConfig(config);
    }

    public Competitor [] getCompetitors() {
        return competitors;
    }

    public void  setCompetitors(Competitor [] competitors) {
        this.competitors = competitors;
        ConfigUtil.refreshConfig(config);
    }
    
    
    
    
}
