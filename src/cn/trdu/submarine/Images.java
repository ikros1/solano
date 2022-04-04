package cn.trdu.submarine;
import javax.swing.ImageIcon;
public class Images {
     //加载各个部分的图片类
     public static ImageIcon backgroundimg;//背景
     public static ImageIcon artmisimg;//导弹
     public static ImageIcon domokiimg;//智树
     public static ImageIcon kasaneimg;//风音日和
     public static ImageIcon panciimg;//胖次
     public static ImageIcon weiyan;//尾焰
     public static ImageIcon yika;//伊卡
     public static ImageIcon bao;//爆炸
     static {
          //初始化赋值
          backgroundimg = new ImageIcon("img/background.png");
          artmisimg = new ImageIcon("img/artmis.png");
          domokiimg = new ImageIcon("img/domoki.png");
          kasaneimg = new ImageIcon("img/kasane.png");
          panciimg = new ImageIcon("img/panci.png");
          weiyan = new ImageIcon("img/weiyan.png");
          yika = new ImageIcon("img/yika.png");
          bao =new ImageIcon("img/bao.png");

     }
}
