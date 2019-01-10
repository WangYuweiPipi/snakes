package snakes;

import java.util.LinkedList;

/**
 * 蛇
 */
public class Snake {

    private LinkedList<Node> body = new LinkedList<>();


    /**
     * 蛇吃食物，增加一个节点
     */
    public Node eat(Node food) {
        // 如果food与头部相连，则将food这个Node加入body中，返回food
        //否则不做任何的操作，返回null
        return null;
    }

    /**
     * 蛇移动
     * way：头部增加一个节点，尾部删除一个节点
     */
    public Node move(Direction direction) {
        Node newNode;
        Node tail = getLast();
        Node head = getHead();
        // 根据方向更新贪吃蛇的 body
        switch (direction) {
            case LEFT:
                newNode = new Node(head.getX() - 1, head.getY());
                body.addFirst(newNode);
                body.removeLast();
                break;
            case UP:
                newNode = new Node(head.getX(),head.getY() - 1);
                body.addFirst(newNode);
                body.removeLast();
                break;
            case DOWN:
                newNode = new Node(head.getX(),head.getY() + 1);
                body.addFirst(newNode);
                body.removeLast();
                break;
            case RIGHT:
                newNode = new Node(head.getX() + 1,head.getY());
                body.addFirst(newNode);
                body.removeLast();
                break;
        }

        // 返回移动之前的尾部 node
        return tail;
    }

    /**
     * 加蛇尾巴
     */
    public Node addTail(Node area) {
        getBody().addLast(area);
        return area;
    }

    /**
     * 获取头部
     */
    public Node getHead() {
        return getBody().getFirst();
    }

    /**
     * 获取尾部
     */
    public Node getLast() {
        return getBody().getLast();
    }

    /**
     * 获取整个身子
     */
    public LinkedList<Node> getBody() {
        return body;
    }
}
