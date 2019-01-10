package nodes;


import java.util.NoSuchElementException;

public class SingleLinked<E> {

    int size = 0;

    // 链表的头节点
    transient Node<E> first;

    // 链表的尾节点
    transient Node<E> last;

    public SingleLinked() {
    }

    public SingleLinked(Node<E> first, Node<E> last) {
        this.first = first;
        this.last = last;
    }

    private static class Node<E> {
        // 节点的数据
        E item;
        // 该节点指向下一个节点的指针
        Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }

    public void addFirst(E e) {
        Node<E> f = first;
        Node<E> newNode = new Node<>(e, f);
        first = newNode;
        if (f == null) {
            last = newNode;
        } else {
            f.next = null;
        }
        size ++;
    }

    public void addLast(E e) {

        Node<E> f = last;  // 记录原尾部节点
        Node<E> newNode = new Node<>(e, f); // 以原尾部节点为新节点的前置节点
        last = newNode; // 更新尾部节点
        if (f == null) {
            first = newNode; // 若链表为空，需建立一个头节点
        } else {
            f.next = newNode; // 否则更新原尾部节点的后置节点为此新节点
        }
        size ++; // 修改size
    }

    // 增加
    public void add(E e) {
        Node<E> f = last;
        Node<E> newNode = new Node<>(e, f); // 以原尾部节点为新节点的前置节点
        if (f == null) {
            first = newNode; // 若链表为空，需建立一个头节点
        } else {
            last = newNode;
        }
    }

    public void removeLast(E e) {
        Node<E> l = last;
        if (l == null)
            throw new NoSuchElementException();
    }

    public void prints(int size) {
        Node<E> data= first;
        while (size > 0 && data != null) {
            System.out.print(data.item + " ");
            data = data.next;
            size --;
        }
    }

    public static void main(String[] args) {

        /* 新增 */
        SingleLinked<String> singleLinked = new SingleLinked<>();
        singleLinked.addLast("a");
        singleLinked.addLast("b");
        singleLinked.addLast("c");
        singleLinked.addLast("d");
        singleLinked.prints(singleLinked.size);

        /* 删除 */


    }
}
