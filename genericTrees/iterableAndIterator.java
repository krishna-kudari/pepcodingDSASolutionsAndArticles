OBJECT OF INTERFACE:

We cannot make an object of the Interface using "new". I obj=new I ( ); is NOT the correct way of making an object for an Interface I. Hence, in the reference/object of Interface we catch the instance of the class implementing it. Then we can call the required function for our object.




2. ITERABLE :
In Java an Interface called "Iterable" is present. We implement this interface when we want to use a loop like the one we want for our generic tree. It has only a function declared in its body which returns an object of type Iterator and the name of the function is "iterator()". It doesn't take any parameters. Hence, the class of Generic Tree implements this Iterable interface. We also define this iterator function in our class.


public static class GenericTree implements Iterable< Integer> {
  Node root;

  GenericTree(Node root) {
    this.root = root
  }
  public Iterator< Integer> iterator() {
    Iterator< Integer> obj = new GTPreorderIterator();
    return obj;
  }
}
3. ITERATOR :
Iterator interface contains 2 important functions:


1• hasNext()- It returns a Boolean value which tells us whether the next value is present or not. 2• next()- It returns the next value.


Let's see how we can write a code in the main function which is equivalent to figure 1 using Iterator.




This means that we check if the Iterator "gti" has a next value and if it does then we print that next value of "gti". The above code is equivalent to the code given below.




We now define the hasNext() and next() functions for the class "GTPreorderIterator" which implements the Iterator interface.




//**********************hasNext() function************************
public boolean hasNext()
{
  if (nval == null)
  {
    return false;

  } else
  {
    return false;
  }
}

//**********************next() function************************
public Integer next() {
  Integer fr = nval;
  // moves nval forward, if not possible sets it to null
  nval = null;
  while (st.size() > 0) {
    Pair top = st.peek();
    if (top.state == -1) {
      nval = top.node.data;
      top.state++;
      break;
    }
    else if (top.state >= 0 && top.state < top.node.children.size()) {
      Pair cp = new Pair(top.node.children.get(top.state), -1);
      st.push(cp);
      top.state++;

    }
    else {
      st.pop();
    }
  }
  return fr;
}
}

//**********************CLASS PAIR************************
private static class Pair {
  Node node;
  int state;
  Pair(Node node, int state) {
    this.node = node;
    this.state = state;
  }
}
We highly suggest you watch the solution video of the previous question, "Iterative Preorder and Postorder" and the video of "Iterable and Iterator" to understand the above code in detail. Iterative Pre-order and Post-order- Solution video Iterable and Iterator- Solution video