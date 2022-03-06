package tankgame.version03;

import javax.swing.*;

public class TankGame_03 extends JFrame {
    private MyPanel myPanel;

    public static void main(String[] args) {
        new TankGame_03();
    }

    public TankGame_03() {
        myPanel = new MyPanel();
        new Thread(myPanel).start();
        this.add(myPanel);//放入画板
        this.addKeyListener(myPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口就关闭程序
        this.setVisible(true);//可视化
        this.setSize(1000, 750);//定义框架大小
    }
}
