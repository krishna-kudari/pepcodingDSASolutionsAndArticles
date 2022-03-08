#include<bits/stdc++.h>
using namespace std;
int main(){
    string exp;
    getline(cin,exp);
    stack<char>st;
    for(int i=0;i<exp.length();i++){
        if(exp[i]=='+' or exp[i]=='-' or exp[i]=='*' or exp[i]=='/'){
            st.push(exp[i]);
        }
        else if(exp[i]=='(' or exp[i]=='[' or exp[i]=='{'){
            st.push(exp[i]);
        }else if(exp[i]==')'){
            if(st.top()=='('){
                cout<<"true"<<endl;
                return 0;
            }else{
                while(st.size()>0 and st.top()!='('){
                    st.pop();
                }st.pop();
            }
        }
    }
    cout<<"false"<<endl;
    return 0;
}