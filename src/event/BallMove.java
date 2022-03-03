package event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 事件处理机制了解小球如何通过键盘操纵进行上下左右移动
 */
public class BallMove extends JFrame {
    private MyPanel panel;

    public static void main(String[] args) {
        new BallMove();
    }

    public BallMove() {
        panel = new MyPanel();
        this.add(panel);
        this.addKeyListener(panel);
        this.setSize(200, 200);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

//画小球
class MyPanel extends JPanel implements KeyListener {
    int x = 10;
    int y = 10;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 20, 20);
    }

    @Override
    //按下键盘字符输出时触发
    public void keyTyped(KeyEvent e) {

    }

    @Override
    //按下键盘时触发
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            y--;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            y++;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            x--;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x++;
        }
        this.repaint();
    }

    @Override
    //键盘松开时触发
    public void keyReleased(KeyEvent e) {

    }
}