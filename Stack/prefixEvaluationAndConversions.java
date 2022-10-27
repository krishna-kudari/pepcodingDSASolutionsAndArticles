Prefix Evaluation And Conversions
Easy

1. You are given a prefix expression.
2. You are required to evaluate it and print its value.
3. You are required to convert it to infix and print it.
4. You are required to convert it to postfix and print it.

Note -> Use brackets in infix expression for indicating precedence. Check sample input output for more details.

Constraints
1. Expression is a valid prefix expression
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

-+2/*6483    */

Sample Output
2
((2+((6*4)/8))-3)
264*8/+3-

import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    Stack<String>infx= new Stack<>();
    Stack<String>pstfx= new Stack<>();
    Stack<Integer>value= new Stack<>();
    for(int i=exp.length()-1;i>=0;i--){
        char ch=exp.charAt(i);
        if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
            processinfx(infx,ch);
            processpostfx(pstfx,ch);
            processvalue(value,ch);
        }else{
            infx.push(""+ch);
            pstfx.push(""+ch);
            value.push(ch-'0');
        }
    }
    System.out.println(value.peek());
    System.out.println(infx.peek());
    System.out.println(pstfx.peek());
 }

 public static void processinfx(Stack<String>infx,char op){
     String op1=infx.pop();
     String op2=infx.pop();
     String eval='('+op1+op+op2+')';
     infx.push(eval);
 }

 public static void processpostfx(Stack<String>pstfx,char op){
     String op1=pstfx.pop();
     String op2=pstfx.pop();
     String eval=op1+op2+op;
     pstfx.push(eval);
 }

 public static void processvalue(Stack<Integer>val,char op) {
     int op1=val.pop();
     int op2=val.pop();
     switch(op) {
         case '+':
         val.push(op1+op2);
         break;
         case '-':
         val.push(op1-op2);
         break;
         case '*':
         val.push(op1*op2);
         break;
         case '/':
         val.push(op1/op2);
         break;

     }

 }
}