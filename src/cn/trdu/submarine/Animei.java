package cn.trdu.submarine;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
//升级人物大招的动画
public class Animei {
    public static ImageIcon[] yika={};
    static {
        //初始化赋值
        //按顺序加载大招的动画图片png
        for(int i=1;i<34;i++){
            yika= Arrays.copyOf(yika,yika.length+1);
            String string="img/ani/("+i+").png";
            yika[yika.length-1]=new ImageIcon(string);
        }

    }
    public void paintImage(Graphics g,int i){
        //调用画笔绘制大招动画帧

        yika[i].paintIcon(null,g,0,0);



    }

}
