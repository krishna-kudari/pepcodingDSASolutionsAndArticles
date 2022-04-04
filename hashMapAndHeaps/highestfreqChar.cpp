#include<bits/stdc++.h>
using namespace std;
int main(){
    string que;
    cin>>que;
    map<char,int> map;
    char hfc;
    int hf=1;
    for(int i=0; i<que.length();i++){
        char c= que[i];
        if(map.find(c)==map.end()){
            map.insert({c,1});
        }else{
            int of = map[c];
            if(of+1>hf){
                hf = of+1;
                hfc = c;
            }
            map[c]++;
        }
    }
    
    cout<<hfc;
    
}