package cn.trdu.submarine;

import javax.swing.*;
import java.util.Random;

public class DoMoKi extends Person{
    //移动的智树类
    int locked;//智树的生存标记位，标记位为1时被锁定销毁
    DoMoKi(){
        super(84,144);
        locked=0;
        x=-width;
        Random rand = new Random();
        y=rand.nextInt(1080-height-247)+247;//赋予初始速度
        speed=rand.nextInt(10)+1;
        //System.out.println("长："+height+"宽："+width+"出生点："+x+","+y+"速度"+speed);
    }
    public PanCi shootPanci(){
        //智树发射胖次的函数
        if(this instanceof DoMoKi){
            //如果对象为domoki
            return new PanCi(this.x,this.y);
        }else {
            //如果对象不是domoki
            return new PanCi(this.x,this.y);
        }
    }
    public void info(){
        System.out.println("长："+height+"宽："+width+"出生点："+x+","+y+"速度"+speed);
    }
    public void step(){
        //智树移动函数
        x+=speed;
        //System.out.println("智树移动,现在位置"+x);
    }
    public ImageIcon getImage(){
        return Images.domokiimg;
    }
}
