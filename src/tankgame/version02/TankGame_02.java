package tankgame.version02;

import javax.swing.*;

public class TankGame_02 extends JFrame {
    private MyPanel myPanel;

    public static void main(String[] args) {
        new TankGame_02();
    }

    public TankGame_02() {
        myPanel = new MyPanel();
        this.add(myPanel);//放入画板
        this.addKeyListener(myPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口就关闭程序
        this.setVisible(true);//可视化
        this.setSize(1000, 750);//定义框架大小
    }
}
