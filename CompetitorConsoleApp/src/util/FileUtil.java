/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import beans.User;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Hp
 */
public class FileUtil {
    
//   public static void writeUsingNIO(Object object,String filename) throws Exception{
//       Path path=Paths.get(filename);
//       String data=object.toString();
//       Files.write(path,data.getBytes());
//       
//    }
    
    public static void writeObjectToFile(Object object,String filename) {
        FileOutputStream fout=null;
        ObjectOutputStream oos=null;
        try{
            fout=new FileOutputStream(filename);
            oos=new ObjectOutputStream(fout);
            oos.writeObject(object);
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if(fout!=null){
              try{
                  fout.close();
              }catch(Exception ex){
                  ex.printStackTrace();
              }  
            }
        }
    }
   
    public static Object readObjectFromFile(String filename) {
        Object obj=null;
        try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(filename)) ){
         obj=ois.readObject();
      
       }catch(Exception ex){
           ex.printStackTrace();
       }finally{
        return obj;
        }
    }
}
