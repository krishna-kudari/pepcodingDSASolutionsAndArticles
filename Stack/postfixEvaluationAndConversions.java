Postfix Evaluation And Conversions
Easy

1. You are given a postfix expression.
2. You are required to evaluate it and print it value.
3. You are required to convert it to infix and print it.
4. You are required to convert it to prefix and print it.

Note -> Use brackets in infix expression for indicating precedence. Check sample input output for more details.

Constraints
1. Expression is a valid postfix expression
2. The only operators used are +, -, *, /
3. All operands are single digit numbers.

Format
Input
Input is managed for you

Output
value, a number
infix
prefix

Example
Sample Input

264*8/+3-

Sample Output
2
((2+((6*4)/8))-3)
-+2/*6483       */

import java.io.*;

import java.util.*;

public class Main {


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
    Stack< Integer> vs = new Stack< >();      //1
    Stack< String> is = new Stack< >();
    Stack< String> ps = new Stack< >();

    for (int i = 0; i < exp.length(); i++) {
      char ch = exp.charAt(i);   //2

      if (ch == '+' || ch == '-' || ch == '*' || ch == '/') { //3
        int v2 = vs.pop();
        int v1 = vs.pop();
        int val = operation(v1, v2, ch);
        vs.push(val);

        String iv2 = is.pop();     //4
        String iv1 = is.pop();
        String ival = "(" + iv1 + ch + iv2 + ")";
        is.push(ival);

        String pv2 = ps.pop(); //5
        String pv1 = ps.pop();
        String pval = ch + pv1 + pv2;
        ps.push(pval);
      } else {
        vs.push(ch - '0'); //6
        is.push(ch + "");
        ps.push(ch + "");
      }
    }
    System.out.println(vs.pop());    //7
    System.out.println(is.pop());
    System.out.println(ps.pop());
  }
  public static int operation (int v1, int v2, char op) {  //8


    if (op == '+') {
      return v1 + v2;
    } else if (op == '-') {
      return v1 - v2;
    } else if (op == '*') {
      return v1 * v2;
    } else {
      return v1 / v2;
    }

  }
}
