package com.example.datastructlearning.data;
/**
 * 实现单链表的一些相关操作
 * <p>
 * 链表 操作的三个重要点   假头   新链接  双指针
 */
public class LinkedListStruct {
    /**
     * 链表节点的定义
     */
    class ListNode {
        //val 用来 存放链表中的数据
        public int val = 0;
        //next 指向向下一个节点
        public ListNode next = null;

        //节点的构造函数
        public ListNode() {
        }

        public ListNode(int x) {
            val = x;
        }
    }
/*************************第一个重点  假头 ********************************************/

    /**
     * 初始定义的结点 参数
     * 以及链表的长度
     * <p>
     * 带假头的链表一共 有6中基本操作  分别是【初始化】【 追加结点 】【 头部插入结点】  【查找结点】【插入指定位置】  【删除指定节点】
     */
    private ListNode dumpy = new ListNode();
    private ListNode tail = dumpy;
    private int length = 0;

    /**
     * 初始化链表  【这是第一个操作】
     */
    public LinkedListStruct() {

    }

    /**
     * 【这是第二个操作】将值为val的结点添加到链表尾部
     *
     * @param val
     */
    public void addAtTail(int val) {
        // 尾部插入新的结点
        //尾部添加一个新结点
        tail.next = new ListNode(val);
        //移动tail指针
        tail = tail.next;
        //链表长度+1
        length++;
    }

    /**
     * 【插入值 为 val的新结点。使得其成为链表的第一个结点】
     */
    public void addAtHead(int val) {
        ListNode p = new ListNode(val);
        p.next = dumpy.next;
        dumpy.next = p;
        if (tail == dumpy) {
            tail = p;
        }
        length++;
    }

    /**
     * [获取链表中第 index个结点的值，索引无效，返回 -1]
     */
    public int get(int index) {
        //边界值判断
        if (index < 0 || index >= length) {
            return -1;
        }
        //因为getPrevNode总是返回有效的结点，所以可以直接取值
        return getPreNode(index).next.val;
    }

    /**
     * 获取get之前需要借助 getPreNode
     */
    private ListNode getPreNode(int index) {
        //初始化 front 与back，一前一后
        ListNode front = dumpy.next;
        ListNode back = dumpy;
        //在查找的时候 front 与back总是一起走
        for (int i = 0; i < index && front != null; i++) {
            back = front;
            front = front.next;
        }
        //把back作为 prev并且返回
        return back;
    }

    /**
     * 在链表中第index个结点之前添加值为val的结点
     */
    public void addAtIndex(int index, int val) {
        //插入到指定位置之前有 4个判断
        if (index > length) {
            //index 大于链表的长度
            return;
        } else if (index == length) {
            //如果index 等于链表的长度，则改结点将附加到链表的末尾
            addAtTail(val);
        } else if (index < 0) {
            //若果index小于0，则在头部插入结点
            addAtHead(val);
        } else {
            //得到index之前的节点pre
            ListNode pre = getPreNode(index);
            ListNode p = new ListNode(val);
            p.next = pre.next;
            pre.next = p;
            //注意修改长度
            length++;
        }
    }

    /**
     * 如果索引index有效，则删除链表中的第index个结点
     */
    public void deleteAtIndex(int index) {
        //有两种情况需要 判断
        if (index < 0 || index >= length) {
            return;
        }
        ListNode pre = getPreNode(index);
        if (tail == pre.next) {
            tail = pre;
        }
        pre.next = pre.next.next;
        length--;

    }
    /**********************************第二个  新链表*****************************************************/

    /**
     * 链表 的反转
     */
    public ListNode reverseList(ListNode head) {
        //建立一个新的带假头的新链表
        ListNode dumpy = new ListNode();
        //遍历旧表
        while (head != null) {
            ListNode tmp = head.next;
            //把旧链表中 的结点取出来，采用头部插入的方法添加到新链表中
            head.next = dumpy.next;
            dumpy.next = head;
            head = tmp;
        }
        //返回新链表的头，注意 不能返回dummy！！
        return dumpy.next;
    }

    /**
     * 删除结点
     */
    public ListNode removeElements(ListNode head, int val) {
        //生成一个新链表
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        //依次取出旧链表中的每个节点
        ListNode p = head;
        while (p != null) {
            ListNode back = p.next;
            //如果结点值需要保留,采用尾部追加的方法
            //追加到新的链表中
            if (p.val != val) {
                tail.next = p;
                tail = p;
            }
            p = back;
        }
        //注意设置尾巴的next为空
        tail.next = null;
        //注意返回的是 dumpy.next
        return dummy.next;
    }

    /***************************第三个    双指针**************************************************/
    /**
     * 双指针 操作相关
     * <p>
     * <p>
     * 间隔指针 ： 前面的指针 先走 一步，后面的指针再一起走，前面的指针先走K步，后面的指针 再一起走
     * 快慢指针：  两个指针的速度一快一慢前进，比如一个每次走 一步，一个每次走两步
     * <p>
     * <p>
     * 判断链表是否 有环的操作
     */
    public boolean hasCycle(ListNode head) {
        //空链表和只有一个节点的链表的实现
        if (head == null || head.next == null) {
            return false;
        }
        //分别设置两个快慢 指针 他们都从head出发
        //s1 表示慢指针 一次只走一步
        //s2 表示快指针   一次走两步
        ListNode s1 = head;
        ListNode s2 = head;
        //开始走动两个指针
        //当相遇 的时候就停下来
        while (s2!=null&&s2.next!=null){
            s2=s2.next.next;
            s1=s1.next;
            if (s1==s2){
                break;
            }
        }
        //判断 是否有环，如果 有环  两个指针必定 相遇
        return s1==s2;
    }
}
