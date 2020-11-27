package 算法;

public class 合并有序链表 {

     public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listadd=new ListNode();
        //比较两个链表的元素大小，将小的元素放到链表的前面
        while(l1.next==null&&l2.next==null){
            if(l1.val<= l2.val){
                listadd.val=l1.val;
                l1=l1.next;
                listadd=listadd.next;
            }else{
                listadd.val=l2.val;
                l2=l2.next;
                listadd=listadd.next;
            }
            if(l1.next==null){
                listadd.val= l2.val;
                listadd=listadd.next;
                l2=l2.next;
            }
            if(l2.next==null){
                listadd.val= l1.val;
                listadd=listadd.next;
                l1=l1.next;
            }
        }
        return listadd;
    }
}
