/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.awt.Component;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class Utility {
    public static void showMsg(Component c,String msg,char ch)  //c is container which contain references like this
    {
       switch(ch)
       {
           case 'w':
           {
               JOptionPane.showMessageDialog(c,msg,"Message",JOptionPane.WARNING_MESSAGE);  //JOptionPane show popup window
               break;
           }
           case 'i':
           {
              JOptionPane.showMessageDialog(c,msg,"Message",JOptionPane.INFORMATION_MESSAGE);//message is heading
               break;
           }
           case 'e':
           {
               JOptionPane.showMessageDialog(c,msg,"Message",JOptionPane.ERROR_MESSAGE);  //msg is message on popup window
               break;
           }
       }
    }
    
    public static void saveImage(String uploadpath,String savepath)
    {
        FileInputStream fis=null;
		FileOutputStream fos=null;
		try
		{
			fis=new FileInputStream(uploadpath);
			fos=new FileOutputStream(savepath);
			byte b[]=new byte[2048];            // act as a bucket
			int c;
			while((c=fis.read(b))!=-1)
			{
				fos.write(b,0,c);  //writes c bytes from the specified byte array b stating at offset 0 to this fos
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in save image : "+e);
		}
		finally
		{
			try
			{
				fos.close();
				fis.close();
				
			}
			catch(Exception e)
			{
				System.out.println("Exception in save image : "+e);
			}
		}
    }
    
    public static void showImage(String imagepath,JLabel lblImg)
    {
        ImageIcon icon=new ImageIcon(imagepath);
       // lblImg.setIcon(new ImageIcon(icon.getImage().getScaledInstance(lblImg.getWidth(),lblImg.getHeight(),Image.SCALE_SMOOTH)));
    //to fix the size of image icon
    //smooth is for pixels
    lblImg.setIcon(new ImageIcon(icon.getImage().getScaledInstance(120,120,Image.SCALE_SMOOTH)));//dimensions of image
    }
}
