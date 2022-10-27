<<<<<<< HEAD
Infix Evaluation
Easy

1. You are given an infix expression.
2. You are required to evaluate and print it's value.

Constraints
1. Expression is balanced
2. The only operators used are +, -, *, /
3. Opening and closing brackets - () - are used to impact precedence of operations
4. + and - have equal precedence which is less than * and /. * and / also have equal precedence.
5. In two operators of equal precedence give preference to the one on left.
6. All operands are single digit numbers.

Format
Input
Input is managed for you

Output
Value of infix expression

Example
Sample Input

2 + 6 * 4 / 8 - 3

Sample Output
2

class Solution {
    public static int precedence(char op){
        if(op == '+' || op == '-')return 1;
        else if(op == '*' || op == '/')return 2;
        else return 2;
    }
    public static int operation(int val1 , int val2 , char op){
        if(op == '+'){
            return val1+val2;
        }else if(op == '-'){
            return val1 - val2;
        }else if(op == '*'){
            return val1*val2;
        }else if(op == '/'){
            return val1/val2;
        }
        return 0;
    }
    public int calculate(String s) {
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();
        int num = 0;
        for(int i = 0 ; i < s.length() ;i++){
            char ch = s.charAt(i);
            if(ch == '('){
                num = 0;
                operators.push(ch);
            }else if(Character.isDigit(ch)){
                if(num != 0){
                    operands.pop();
                }
                num = num*10+(ch-'0');
                operands.push(num);
            }else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                while(operators.size() > 0 && operators.peek() != '(' && precedence(ch) <= precedence(operators.peek())){
                    int val2 = operands.pop();
                    int val1 = operands.pop();
                    char op = operators.pop();
                    
                    int opval = operation(val1 , val2 , op);
                    operands.push(opval);
                }
                operators.push(ch);
                num = 0;
            }else if(ch == ')') {
                while(operators.size() > 0 && operators.peek() != '('){
                    int val2 = operands.pop();
                    int val1 = operands.pop();
                    char op = operators.pop();
                    
                    int opval = operation(val1 , val2 , op);
                    operands.push(opval);
                }
                operators.pop();
                num = 0;
            }
        }
        
        while(operators.size() > 0){
            int val2 = operands.pop();
            int val1 = operands.pop();
            char op = operators.pop();
            
            int opval = operation(val1 , val2 , op);
            operands.push(opval);
        }
        int val = operands.pop();
        return val;
    }
}

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        int number = 0;
        int sign = 1;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                number = 10 * number + (int)(c - '0');
            }else if(c == '+'){
                result += sign * number;
                number = 0;
                sign = 1;
            }else if(c == '-'){
                result += sign * number;
                number = 0;
                sign = -1;
            }else if(c == '('){
                //we push the result first, then sign;
                stack.push(result);
                stack.push(sign);
                //reset the sign and result for the value in the parenthesis
                sign = 1;   
                result = 0;
            }else if(c == ')'){
                result += sign * number;  
                number = 0;
                result *= stack.pop();    //stack.pop() is the sign before the parenthesis
                result += stack.pop();   //stack.pop() now is the result calculated before the parenthesis

            }
        }
        if(number != 0) result += sign * number;
        return result;
    }
=======
Infix Evaluation
Easy

1. You are given an infix expression.
2. You are required to evaluate and print it's value.

Constraints
1. Expression is balanced
2. The only operators used are +, -, *, /
3. Opening and closing brackets - () - are used to impact precedence of operations
4. + and - have equal precedence which is less than * and /. * and / also have equal precedence.
5. In two operators of equal precedence give preference to the one on left.
6. All operands are single digit numbers.

Format
Input
Input is managed for you

Output
Value of infix expression

Example
Sample Input

2 + 6 * 4 / 8 - 3

Sample Output
2

class Solution {
    public static int precedence(char op){
        if(op == '+' || op == '-')return 1;
        else if(op == '*' || op == '/')return 2;
        else return 2;
    }
    public static int operation(int val1 , int val2 , char op){
        if(op == '+'){
            return val1+val2;
        }else if(op == '-'){
            return val1 - val2;
        }else if(op == '*'){
            return val1*val2;
        }else if(op == '/'){
            return val1/val2;
        }
        return 0;
    }
    public int calculate(String s) {
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();
        int num = 0;
        for(int i = 0 ; i < s.length() ;i++){
            char ch = s.charAt(i);
            if(ch == '('){
                num = 0;
                operators.push(ch);
            }else if(Character.isDigit(ch)){
                if(num != 0){
                    operands.pop();
                }
                num = num*10+(ch-'0');
                operands.push(num);
            }else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                while(operators.size() > 0 && operators.peek() != '(' && precedence(ch) <= precedence(operators.peek())){
                    int val2 = operands.pop();
                    int val1 = operands.pop();
                    char op = operators.pop();
                    
                    int opval = operation(val1 , val2 , op);
                    operands.push(opval);
                }
                operators.push(ch);
                num = 0;
            }else if(ch == ')') {
                while(operators.size() > 0 && operators.peek() != '('){
                    int val2 = operands.pop();
                    int val1 = operands.pop();
                    char op = operators.pop();
                    
                    int opval = operation(val1 , val2 , op);
                    operands.push(opval);
                }
                operators.pop();
                num = 0;
            }
        }
        
        while(operators.size() > 0){
            int val2 = operands.pop();
            int val1 = operands.pop();
            char op = operators.pop();
            
            int opval = operation(val1 , val2 , op);
            operands.push(opval);
        }
        int val = operands.pop();
        return val;
    }
}

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        int number = 0;
        int sign = 1;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                number = 10 * number + (int)(c - '0');
            }else if(c == '+'){
                result += sign * number;
                number = 0;
                sign = 1;
            }else if(c == '-'){
                result += sign * number;
                number = 0;
                sign = -1;
            }else if(c == '('){
                //we push the result first, then sign;
                stack.push(result);
                stack.push(sign);
                //reset the sign and result for the value in the parenthesis
                sign = 1;   
                result = 0;
            }else if(c == ')'){
                result += sign * number;  
                number = 0;
                result *= stack.pop();    //stack.pop() is the sign before the parenthesis
                result += stack.pop();   //stack.pop() now is the result calculated before the parenthesis

            }
        }
        if(number != 0) result += sign * number;
        return result;
    }
>>>>>>> a413ffa7abff2a67ed538cec1c267806909b2453
}