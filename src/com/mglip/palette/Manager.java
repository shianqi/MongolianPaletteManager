package com.mglip.palette;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;

/**
 * @author shianqi@imudges.com
 * Created by shianqi on 2016/12/4
 */
public class Manager{

    public static void main(String arg[]){
        String str = HttpRequest.sendGet("http://localhost:3000","");
        System.out.println(str);

        Gson gson = new Gson();
        Type type = new TypeToken<JsonBean>() {}.getType();
        JsonBean jsonBean = gson.fromJson(str, type);
        System.out.println("results size: "+jsonBean.results.size());

        BufferedImage image=new BufferedImage(1080, 1980, BufferedImage.TYPE_INT_BGR);
        Graphics2D graphics=image.createGraphics();


        for(int i=0;i<jsonBean.results.size();i++){
            graphics.setStroke(new BasicStroke(5.5f));
            graphics.setColor(Color.white);
            graphics.fillRect(0,0,1080,1980);
            graphics.setColor(Color.black);

            String [] str1 = jsonBean.results.get(i).word.split("#");
            for(int j=0;j<str1.length;j++){
                String [] str2 = str1[j].split(";");

                int x_old = 0;
                int y_old = 0;

                for(int x= 0;x<str2.length;x++){
                    int cx = Integer.parseInt(str2[x].split(",")[0]);
                    int cy = Integer.parseInt(str2[x].split(",")[1]);
                    if(x==0){
                        x_old = cx;
                        y_old = cy;
                    }else{
                        graphics.drawLine(x_old,y_old,cx,cy);
                        x_old = cx;
                        y_old = cy;
                    }
                    //画完一个点
                }
                //画完一条线
            }
            //画完一张图



            File file =new File("D:/img/"+jsonBean.results.get(i).str+"_"+jsonBean.results.get(i)._id+".png");
            try {
                ImageIO.write(image, "png", file);
                System.out.println("成功");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                System.out.println("失败");
            }
        }
    }
}
