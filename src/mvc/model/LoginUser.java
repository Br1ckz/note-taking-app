/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package mvc.model;

/**
 *
 * @author Kaitlin
 */
public class LoginUser {
    private String FName;
    private String LName;
    
    
    public void setFName(String FN) {
        this.FName = FN;
    }
    
    public String getFName(){
        return FName;
    }
    
    public void setLName(String LN) {
        this.LName = LN;
    }
    
    public String getLName(){
        return LName;
    }
}