package snakes;

import javax.swing.*;
import java.awt.*;

/**
 * 窗体应用，用户和游戏的交互界面
 */
public class SnakeApp extends JFrame {

    private GameDraw gameDraw;


    public static void main(String[] args) {
        SnakeApp snakeApp = new SnakeApp();

        snakeApp.init();
    }


    public void init() {

        try {

            //初始化场地
            Grid grid = new Grid(Constant.GRID_HEIGHT, Constant.GRID_WIDTH);

            // 创建游戏窗体
            JFrame window = new JFrame("Gluttonous Snake");
            // 设置窗口大小
//        window.setPreferredSize(new Dimension(200, 200));
            Container container = window.getContentPane();

            /*画场地和蛇*/
            gameDraw = new GameDraw(grid);
            gameDraw.init();
            // 设置gameView中JPanel的大小
            gameDraw.getjPanel().setPreferredSize(new Dimension(grid.getWidth() * Constant.NODE_SIZE, grid.getHeight() * Constant.NODE_SIZE));
            // 将gameView中JPanel加入到窗口中
            container.add(gameDraw.getjPanel(), BorderLayout.CENTER);

            // 渲染和显示窗口
            window.pack();
            // 设置窗口为大小不可变化
            window.setResizable(false);
            // 窗口关闭的行为
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setVisible(true);

            // 开线程
            GameControl gameControl = new GameControl(grid, gameDraw);
            window.addKeyListener(gameControl);
            new Thread(gameControl).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
