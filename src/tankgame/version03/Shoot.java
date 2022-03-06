package tankgame.version03;

public class Shoot implements Runnable{
    int x;
    int y;
    int direction;
    int speed = 2;
    boolean isLive = true;

    public Shoot(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    public void run() {//子弹射击
        while(true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //根据方向改变子弹的x,y坐标
            switch (direction) {
                case 0 :
                    y -= speed;
                    break;
                case 1:
                    x += speed;
                    break;
                case 2:
                    y += speed;
                    break;
                case 3:
                    x -= speed;
                    break;
            }
            System.out.println(x+","+y);
            //当子弹移动到面板的边界时，就销毁
            if(!(x>=0 && x<=1000 && y>=0 && y<=750)) {
                isLive = false;
                break;
            }
        }
    }
}
