Duplicate Brackets
Easy

1. You are given a string exp representing an expression. 2. Assume that the expression is balanced i.e. the opening and closing brackets match with each other. 3. But, some of the pair of brackets maybe extra/needless. 4. You are required to print true if you detect extra brackets and false otherwise. e.g.' ((a + b) + (c + d)) -> false (a + b) + ((c + d)) -> true


Constraints
0 <= str.length <= 100


Format
Input
A string str


Output
true or false


Example
Sample Input

(a + b) + ((c + d))

Sample Output
true

#include <bits/stdc++.h>

using namespace std;

int main()
{ 
   //write your code
   string exp;
   getline(cin,exp);
   // cout<<exp<<endl;
   stack<char>st;
   for(int i=0;i<exp.length();i++){
      if(exp[i]=='+' or exp[i]=='-' or exp[i]=='*'  or exp[i]=='/' or exp[i]=='%'){
         st.push(exp[i]);
         // cout<<st.top()<<endl;
      }else if(exp[i]=='(' or exp[i]=='[' or exp [i]=='{'){
         st.push(exp[i]);
         
         // cout<<st.top()<<endl;

      }else if(exp[i]==')'){
         if(st.top()=='('){
            cout<<"true"<<endl;
            // cout<<"k"<<endl;

            return 0;
         }else{
            while(st.size()>0 and st.top()!='('){
               st.pop();
            }st.pop();
            // cout<<st.top()<<endl;

         }
      }
      // cout<<st.top()<<endl;

      
      // return false;
   }
   cout<<"false"<<endl;
   return 0;
}

