package snakes;

import java.util.LinkedList;
import java.util.Random;

/**
 * 蛇的场地
 * 1. 需要随机生成食物
 * 2. 场地的 Node 是否被蛇覆盖
 * 3. 蛇移动的方向
 */
public class Grid {

    private final int height; // 高度

    private final int width; // 宽度

    private Snake snake; // 蛇

    private Node food; // 食物

//    private boolean cover[][]; // 表示蛇覆盖区域，如果覆盖，值为true；否则为false

    private Direction direction = Direction.LEFT; // 初始化方向为左


    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Node getFood() {
        return food;
    }

    public void setFood(Node food) {
        this.food = food;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * 初始化
     */
    public Grid(int height, int width) {
        this.height = height;
        this.width = width;

        this.snake = initSnake();
        createFood();
    }

    /**
     * 初始化蛇
     */
    public Snake initSnake() {
        Snake snake = new Snake();
        // 设置蛇的body
        int x = (int) Math.ceil(width/2);
        int y = (int) Math.ceil(height /2);
        for (int i = 0; i < 4; i++) {
            x += 1;
            Node node = new Node(x, y);
            snake.addTail(node);
        }
        return snake;
    }

    /**
     * 随机创建食物，范围在棋盘内
     */
    public Node createFood() {
        // 随机创建x的点
        Random widthRandom = new Random();
        int x = widthRandom.nextInt(width - 2) + 1;
        Random heightRandom = new Random();
        int y= heightRandom.nextInt(height - 2) + 1;
        food = new Node(x, y);
        System.out.println(food.toString());
        return food;
    }

    /**
     * 每次移动的状态函数
     */
    public boolean nextRound() {

        // 按当前方向移动蛇
        Node snakeHead = snake.getHead();
        /*
        * 判断头部位置是否有效
        * 1. 头部不在边界外
        * 2. 头部是否碰到自身
        */
        if (checkBorder() && checkSnake()){
            // 移动
            Node tail = snake.move(direction);

            // 判断头部是否是食物
            if (food.equals(snakeHead)) {
                snake.addTail(tail);
                // 创建一个新的食物
                this.food = createFood();
            }
            // 更新棋盘状态

            return true;
        }
        return false;
    }



    /**
     * 改变方向
     */
    public void changeDirection(Direction newDirection) {
        if (direction.equals(newDirection)) {
            return;
        }
        // 不可往相反的方向移动
        switch (direction) {
            case UP:
                if (newDirection.equals(Direction.DOWN))
                    return;
                break;
            case DOWN:
                if (newDirection.equals(Direction.UP))
                    return;
                break;
            case RIGHT:
                if (newDirection.equals(Direction.LEFT))
                    return;
                break;
            case LEFT:
                if (newDirection.equals(Direction.RIGHT))
                    return;
                break;

        }
        direction = newDirection;
    }

    /**
     * 蛇头部是否与自身重合判断
     */
    public boolean checkSnake() {
        Node snakeHead = snake.getHead();
        LinkedList<Node> tempSnake = new LinkedList<>(snake.getBody());
        tempSnake.removeFirst();
        return !tempSnake.contains(snakeHead);
    }

    /**
     * 边界判断
     */
    public boolean checkBorder() {
        Node snakeHead = snake.getHead();
        int x = snakeHead.getX();
        int y = snakeHead.getY();
        return x != 0 && x != width && y != 0 && y != height;
    }



}
