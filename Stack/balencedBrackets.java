Balanced Brackets
Easy

1. You are given a string exp representing an expression.
2. You are required to check if the expression is balanced i.e. closing brackets and opening brackets match up well.

e.g.
[(a + b) + {(c + d) * (e / f)}] -> true
[(a + b) + {(c + d) * (e / f)]} -> false
[(a + b) + {(c + d) * (e / f)} -> false
([(a + b) + {(c + d) * (e / f)}] -> false

Constraints
0 <= str.length <= 100

Format
Input
A string str

Output
true or false

Example
Sample Input

[(a + b) + {(c + d) * (e / f)}]

Sample Output
true

Question Video

Play Video


#include <bits/stdc++.h>
using namespace std;
int main()
{ 
   //write your code
   string exp;
   getline(cin,exp);
   stack<char>st;
   for(int i=0;i<exp.length();i++){
       if(exp[i]=='+' or exp[i]=='-' or exp[i]=='*' or exp[i]=='/'){
           st.push(exp[i]);
       }else if(exp[i]=='(' or exp[i]=='[' or exp[i]=='{'){
           st.push(exp[i]);
       }else if( exp[i]==')'){
           if(st.size()==0){
               cout<<"false"<<endl;
               return 0;
           }
           while(st.size()>=0 and st.top()!='('){
               if(st.top()=='[' or st.top()=='{'){
                   cout<<"false"<<endl;
                   return 0;
               }
               st.pop();
            }
           st.pop();
       }
       else if( exp[i]==']'){
           if(st.size()==0){
               cout<<"false"<<endl;
               return 0;
           }
           while(st.size()>=0 and st.top()!='['){
               if(st.top()=='(' or st.top()=='{'){
                   cout<<"false"<<endl;
                   return 0;
               }
               st.pop();

           }
           st.pop();
       }
       else if( exp[i]=='}'){
           if(st.size()==0){
               cout<<"false"<<endl;
               return 0;
           }
           while(st.size()>=0 and st.top()!='{'){
               if(st.top()=='[' or st.top()=='('){
                   cout<<"false"<<endl;
                   return 0;
               }
               st.pop();

           }
           st.pop();
       }
   }
   if(st.size()>0){
       cout<<"false"<<endl;
   }else{
       cout<<"true"<<endl;
   }
   
   return 0;
}