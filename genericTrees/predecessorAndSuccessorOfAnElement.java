Predecessor And Successor Of An Element
Easy

1. You are given a partially written GenericTree class.
2. You are required to find the preorder predecessor and successor of a given element. Use the "travel and change" strategy explained in the earlier video. The static properties have been declared for you. You can declare more if you want.
3. Input and Output is managed for you.

Constraints
None

Format
Input
Input is managed for you

Output
Output is managed for you

Example
Sample Input

24
10 20 -50 -1 60 -1 -1 30 70 -1 -80 110 -1 -120 -1 -1 90 -1 -1 40 -100 -1 -1 -1
-120

Sample Output
Predecessor = 110
Successor = 90


#include<bits/stdc++.h>
using namespace std;



struct Node{
    int data;
    vector<Node*>children;
};

Node *newNode(int key){
	Node *temp=new Node;
	temp->data=key;
	return temp;

}

Node *construct(int arr[],int n ){
    Node *root=NULL;
    stack<Node*>st;
    for(int i=0;i<n;i++){
        if(arr[i]==-1){
            st.pop();
        }else{
            Node *t=newNode(arr[i]);
                        
            if(st.size()>0){
                st.top()->children.push_back(t);
            }else{
                root=t;
            }
            st.push(t);
        }
    }
    return root;
}

Node *pre ;
Node *suc ;
int state=0 ;


void prnsc(Node *node, int data){
    if(state==0){
        if(node->data==data){
            state=1;
        }else{
            pre=node;
            
        }
        
    }else{
        if(state==1){
            suc=node;
            state++;
        }
    }
    for (Node* child : node->children) {

        prnsc(child,data);  

    }
    
}

int main(){
    
    int n;
    cin>>n;
    
    int arr[n];
    for(int i=0;i<n;i++){
        cin>>arr[i];
    }
    int val;
    cin>>val;
    Node *root=construct(arr,n);
    prnsc(root,val);
    if(pre==NULL){
      cout<<"Predecessor = Not found"<<endl;
    } else {
      cout<<"Predecessor = "<< pre->data<<endl;
    }

    if(suc==NULL){
      cout<<"Successor = Not found";
    } else {
      cout<<"Successor = " << suc->data;
    }
}