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