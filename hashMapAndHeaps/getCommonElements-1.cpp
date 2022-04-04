#include<bits/stdc++.h>
using namespace std;
int main(){
    int n1;
    cin>>n1;
    int a1[n1];
    map<int, int> m1;
    for (int i = 0; i < n1; i++)
    {
        cin>>a1[i];
        m1.insert({a1[i], 1});
    }
    
    int n2;
    cin>>n2;
    int  a2[n2];
    for (int  i = 0; i < n2; i++)
    {
        cin>>a2[i];
        if(m1.find(a2[i]) == m1.end()){
            
        }else{
            cout<<a2[i]<<endl;
            m1.erase(a2[i]);
        }
    }
    
    
}