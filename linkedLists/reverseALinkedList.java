public void reverseDI() {
    // write your code here
    int fi=0;
    int li=size-1;
    while(fi<li){
      int temp=getAt(fi);
      
      addAt(fi,getAt(li));
      removeAt(fi+1);
      addAt(li,temp);removeAt(li+1);
      li--;
      fi++;
    }
  }

  public void reverseDI() {
    // write your code here
    int fi=0;
    int li=size-1;
    Node tempi=head;
    for (int i = 0; i < size/2; i++) {
      Node tempj=tempi;
      for( int j = i ; j < size-1-i   ;j++  ) {
        tempj=tempj.next;
      }
      int temp=tempi.data;
      tempi.data=tempj.data;
      tempj.data=temp;
      tempi=tempi.next;
    }
  }


  public void reversePI(){
    // write your code here
    Node ot=getNodeAt(size-1);
    Node oh=getNodeAt(0);
    for(int i=size-2;i>=0;i--){
      
      Node temp=getNodeAt(i);//System.out.println(temp.data);
      // if(i==size-2){
      //   head=temp.next;
      // }
      temp.next.next=temp;//System.out.println(temp.next.next.data);
      if(i==0){
        temp.next=null;
        // tail=temp;
      }
    }

    // head.next=null;
    
    head=ot;
    tail=oh;
    // Node nd=getNodeAt(0);
    // tail=nd;

  }


  public void reversePI(){
    // write your code here
    Node prev = null;
    Node curr = head;
    while(curr != null){
      Node next = curr.next;

      curr.next = prev;

      prev = curr;
      curr = next;
    }
    tail = head;
    head = prev;
  }