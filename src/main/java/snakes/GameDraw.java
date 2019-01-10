package snakes;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

/**
 * 画图
 * 1. 画场地
 * 2. 画蛇
 * 3. 画食物
 */
public class GameDraw extends JPanel{

    private Grid grid;
    private JPanel jPanel;

    private int size = Constant.NODE_SIZE;

    public GameDraw(Grid grid) {
        this.grid = grid;
    }

    /**
     * 将 Graphics 放进 JFrame 容器里
     */
    public void init() {
        jPanel = new JPanel() {
            @Override
            public void paintComponent(Graphics graphics) {
                drawGrid(graphics);
                drawSnake(graphics, grid.getSnake());
                drawFood(graphics, grid.getFood());
            }
        };
    }

    /**
     * 重新绘制
     */
    public void draw() {
        jPanel.repaint();
    }

    /**
     * 画场地
     */
    public void drawGrid(Graphics graphics) {
        graphics.setColor(Color.GRAY);
        graphics.fillRect(0,0, grid.getWidth() * size, grid.getHeight() * size);
    }

    /**
     * 画蛇
     */
    public void drawSnake(Graphics graphics, Snake snake) {
        LinkedList<Node> list =  snake.getBody();
        for (Node node : list) {
            drawSquare(graphics, node, Color.ORANGE);
        }
    }

    /**
     * 画食物
     */
    public void drawFood(Graphics graphics, Node food) {
        // 随机的一个点
        drawCircle(graphics, food,Color.PINK);
    }


    /**
     * 画矩形
     */
    private void drawSquare(Graphics graphics, Node squareArea, Color color) {
        graphics.setColor(color);
        graphics.fillRect(squareArea.getX() * size, squareArea.getY() * size, size - 1, size - 1);
    }

    /**
     * 画圆形
     */
    private void drawCircle(Graphics graphics, Node squareArea, Color color) {
        graphics.setColor(color);
        graphics.fillOval(squareArea.getX() * size, squareArea.getY() * size, size, size);
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public JPanel getjPanel() {
        return jPanel;
    }


    public void setjPanel(JPanel jPanel) {
        this.jPanel = jPanel;
    }



}
