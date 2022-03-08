#include <bits/stdc++.h>
using namespace std;
void display(vector<int> a)
{
    for (int i = 0; i < a.size(); i++)
    {
        cout << a[i] << endl;
    }
}vector<int> soolve(vector<int> arr){
    vector<int> nge(arr.size(),-1);
    stack<int>st;
    for(int i=0;i<arr.size();i++){
        while(st.size()>0 and arr[st.top()]<arr[i]){
            nge[st.top()]=arr[i];
            st.pop();
        }
        st.push(i);

    }
    return nge;

}

vector<int> solve(vector<int> arr)
{
    // write your code here
    // for (int i = 0; i < arr.size(); i++)
    // {
    //     cout << arr[i] << endl;
    // }
    vector<int> nge(arr.size());
    stack<int> st;
    nge[arr.size() - 1] = -1;
    st.push(arr[arr.size() - 1]);
    for (int i = arr.size() - 2; i >= 0; i--)
    {
        if (arr[i] < st.top())
        {
            nge[i] = st.top();
            // cout<<nge[i]<<endl;
            st.push(arr[i]);
        }
        else
        {
            while (st.size() > 0 and st.top() <= arr[i])
            {
                st.pop();
            }
            if (st.size() == 0)
            {
                nge[i] = -1;
            }
            else
            {
                nge[i] = st.top();
            }
            st.push(arr[i]);
        }
    }
    // for (int i = 0; i < arr.size(); i++)
    // {
    //     // cout<<"k"<<endl;
    //     cout << nge[i] << endl;
    // }
    return nge;
}
int main(int argc, char **argv)
{
    int n;
    cin >> n;
    vector<int> arr(n, 0);
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }
    vector<int> nge(n, 0);
    nge = solve(arr);
    display(nge);
    return 0;
}