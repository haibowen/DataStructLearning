package com.example.datastructlearning.data;


/**
 * 排序相关的知识点
 * <p>
 * <p>
 * 合并排序
 * <p>
 * 快速排序
 */
public class SortDemo {
    /**
     * 合并排序
     * <p>
     * 合并排序 的 复杂度    时间复杂度 O（NlgN） 空间复杂度 O(N)
     */
    private void mSort(int[] a, int b, int e, int t[]) {
        //空区间 只有一个 元素
        //为了防止 b+1 溢出，这里用 b>=e先判断一下
        if (b >= e || b + 1 >= e) {
            return;
        }
        //分成两半 二叉树可以自动获得 root.left root.right
        //这里我们需要通过计算来得到左右子数组
        final int m = b + ((e - b) >> 1);
        //类比二叉树分别遍历 左子树右子树
        mSort(a, b, m, t);
        mSort(a, m, e, t);
        //i 指向左子树组的开头，j指向右子数组的开头
        //to 指向要临时数组t与区间【b,e】对应的位置
        int i = b;
        int j = m;
        int to = b;
        //将两个 子数组进行合并  注意下面是一个很重要的模板
        //这里的额判断条件是  只要两个子数组 中还有元素
        while (i < m || j < e) {
            //如果有子数组没有元素 或 左子数组开头的元素 小于 右 子数组开头的元素
            //那么取走左子数组的 开头的元素
            //考点：a[i]<=a[j]这样可以保证合并排序是稳定的
            if (j >= e || i < m && a[i] <= a[j]) {
                t[to++] = a[i++];
            } else {
                //否则就 取右子数组开头的元素
                t[to++] = a[j++];
            }
        }
        //把合并的结果拷回原来的数组  a【】
        for (i = b; i < e; i++) {
            a[i] = t[i];
        }
    }

    public void mergeSort(int[] nus) {
        //如果传进来 的数组为空
        if (nus == null || nus.length == 0) {
            return;
        }
        //t 是一个临时中转的数组
        int[] t = new int[nus.length];
        mSort(nus, 0, nus.length, t);
    }


    /***************************************************************8/
     * 快速排序   的 相关实现
     */

    void quickSort(int[] nms) {
        if (nms == null) {
            return;
        }
        qSort(nms,0,nms.length);
    }

    /**
     * 交互数组中的两个元素的值
     */
    void swap(int[] A, int i, int j) {
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }
    /**
     * 将数组 【b,e)范围的元素进行排序
     */
    void qSort(int [] A,int b,int e){
        //像二叉树 一样 如果空树/只有一个节点 那么 不需要再递归 了
        //如果 给定区间为空 或者只有一个 结点
        if (b>=e||b+1>=e){
            return;
        }
        //取数组中间的的元素作为x
        final int m=b+((e-b)>>1);
        final int x=A[m];
        //三路 切分  这部分的代码
        int l=b,i=b,r=e-i;
        while (i<=r){
            if (A[i]<x){
                swap(A,l++,i++);
            }else if (A[i]==x){
                i++;
            }else {
                swap(A,r--,i);
            }
        }
        //像二叉树的前序遍历一样，分别遍历左子树右子树
        qSort(A,b,l);
        qSort(A,i,e);
    }
/************************************************************/

}
