package draw;

import javax.swing.*;
import java.awt.*;

public class DrawCircle extends JFrame {

    public static void main(String[] args) {
        new MyFrame();
    }
}

class MyPanel extends JPanel {
    @Override
    //监听机制：paint方法会在第一次显示窗口、最小化、最大化、执行repaint方法、调整窗口大小的时候被系统自动调用
    public void paint(Graphics g) {
        super.paint(g);
        //画板上画一个圆形，宽和高不同就是椭圆
        g.drawOval(0, 0, 100, 100);//x,y表示圆的左上角坐标（圆的左边切线和右边切线交点）
        //画直线
//        g.drawLine(0,0,10,10);//直线起点(x1,y1)终点(x2,y2)
        //画矩形边框
//        g.drawRect(0,0,100,200);
        //画填充矩形，填充为红色
//        g.setColor(Color.RED);
//        g.fillRect(0,0,100,200);
        //画填充椭圆
//        g.setColor(Color.RED);
//        g.fillOval(0,0,100,150);
        //画一个图片，图片要放在项目class文件的根目录下（此处是out/production/Study下）
//        Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/皮卡丘.jpg"));
//        g.drawImage(image,0,0,200,200,this);//x,y表示图片起始左上角坐标，宽高像素，this表示当前位置
        //画颜色，即写字，设置字体颜色和大小
//        g.setColor(Color.BLACK);
//        g.setFont(new Font("隶书",Font.BOLD,50));//定义字体属性：隶书、粗体、大小50
//        g.drawString("北京欢迎你！",100,100);//x,y表示字符串左下角坐标

    }
}

class MyFrame extends JFrame {
    private MyPanel p;

    //定义框架，放入画板
    public MyFrame() {
        p = new MyPanel();
        this.add(p);
        this.setSize(400, 300);
        this.setVisible(true);//可视化
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//窗口点击×关闭时程序也停止，否则程序还在运行
    }
}
