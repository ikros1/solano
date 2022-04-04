package cn.trdu.submarine;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
public class Artemis extends Person {
    //导弹类  继承person类

    double speedx;//捣蛋的x轴速度
    double speedy;
    double engine;//捣蛋的加速度合力
    double ax;//导弹加速度分力
    double ay;
    double tergatx;//导弹瞄准的目标x坐标
    double tergaty;
    int mubiao;//目标状态位0代表目标丢失导弹销毁
    double degree;//捣蛋的仰角
    BufferedImage  img2;//导弹的图片类

    {
        try {
            img2 = ImageIO.read(new File("img/artmis.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Random ran = new Random();


    Artemis(int x,int y){
        super(24,70);
        this.x=x+174;
        this.y=y+112;
        engine=0.5;
        mubiao=1;
        speedx=(ran.nextDouble()-0.5)*40;
        speedy=(ran.nextDouble()-0.5)*5;;
        ax=0;
        ay=0;
        degree=0;
        tergatx=this.x+120;
        tergaty=this.y+20;
        //System.out.println("导弹初始化 角度"+this.degree+"引擎"+this.engine+"初始坐标 x:"+this.x+" y:"+this.y+"初始加速度 x:"+this.ax+" y:"+this.ay+"初始速度 x:"+this.speedx+" y:"+this.speedy);

    }

    public void step(){
        //移动导弹
        System.out.println("永久追尾空对空导弹移动");
        this.x+=this.speedx;
        this.y+=this.speedy;
        System.out.println("artmisinfo:ax:"+ax+"  ay:"+ay+"  speedx:"+speedx+" speedy:"+speedy+" point x:"+x+" y:"+y);



    }

    public ImageIcon getImage(){
        return Images.artmisimg;
    }



}
