#include<bits/stdc++.h>
using namespace std;

    vector<int> data;

    int _size() {
        //write your code here
        return data.size();
       
    }

  

    
    void add(int val) {
       // write your code here
       int i=0,j=data.size()-1;
      while(i<j){
        int m =(i+j)/2;
        if(data[(m)]<val){
          i=m+1;
        }else{
          j=m-1;
        }
      }
      if(data.size()==0){
        data.push_back(val);
        return;
      }
      if(data[(i)]>val){data.insert(data.begin()+i , val);}
      else{data.insert(data.begin()+i+1 ,val);} 
    }

   


    int _remove() {
     //write your code here
     if(data.size()==0){ cout<<("Underflow")<<endl; return -1;}
     int m = data[0];
     data.erase(data.begin()+0);
      return m;
    }

    

    int peek() {
     //write your code here
        if(data.size()==0){ cout<<("Underflow")<<endl; return -1;}
      return data[(0)];
      
    }

    



int main(){
   

  while(1){
      string str;
        getline(cin,str);
      if(str[0]=='a'){
          string num=str.substr(4,str.length());
          int val=stoi(num);
          add(val);
      }else if(str[0]=='r'){
          int val=_remove();
          if(val!=-1){
              cout<<val<<endl;
          }
      }else if(str[0]=='p'){
          int val=peek();
          if(val!=-1){
              cout<<val<<endl;
          }
      }else break;
  }


   
}