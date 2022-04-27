/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mvc.controller;


import java.util.Date;
import mvc.model.DBConnection;
import mvc.view.DateTimeView;
/**
 *
 * @author sabrinamatteoli
 */

/********************************* MODIFICATION LOG *************************************
*
*
*****************************************************************************************/
public class DateTimeCntl
{
    private DateTimeView datetimeUI;
    private DBConnection dbConnection; 
    
    public DateTimeCntl(){
        this.dbConnection = new DBConnection();
        this.datetimeUI = new DateTimeView(this);
        showDateTimeCntl(true);
    }//DateTimeCntl
    
    public void showDateTimeCntl(boolean bool){
        datetimeUI.setVisible(bool);
        if (bool == false){
            datetimeUI.dispose();        }
    }//showDateTimeCntl   
    
    public void addDateTime(Date finalDateTime){
        dbConnection.insertDate(finalDateTime);
    }//addDateTime
    
}//class DateTimeCntl
