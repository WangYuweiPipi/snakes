package snakes;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 控制类，操作snake动态效果
 */
public class GameControl implements Runnable, KeyListener {

    private Grid grid;

    private GameDraw gameDraw;

    private boolean running = true;

    public GameControl(Grid grid, GameDraw gameDraw) {
        this.grid = grid;
        this.gameDraw = gameDraw;
    }

    /**
     * 让蛇不断的处于移动的状态
     */
    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(Constant.MOVE_INTERVAL);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            /* 进入游戏下一步 */
            // 如果结束，则退出游戏
            if (!grid.nextRound()) {
//                gameDraw.over();
                running = false;
            }
            // 否则继续，绘制新的页面
            gameDraw.draw();
        }
    }



    /**
     * 键盘操作
     */
    @Override
    public void keyPressed(KeyEvent e) {

        // 获取键盘键值
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_UP){
            grid.changeDirection(Direction.DOWN);
        }else if (keyCode == KeyEvent.VK_LEFT){
            grid.changeDirection(Direction.LEFT);
        }else if (keyCode == KeyEvent.VK_RIGHT){
            grid.changeDirection(Direction.RIGHT);
        }else if (keyCode == KeyEvent.VK_DOWN){
            grid.changeDirection(Direction.UP);
        }

        if (grid.nextRound()) {
            // 绘制新的页面
            gameDraw.draw();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
