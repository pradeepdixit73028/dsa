class Node{
public:
    string val;
    Node* next;
    Node* prev;
    Node(string val){
        this->val=val;
        next=NULL;
        prev=NULL;
    }
};
class BrowserHistory {
public:
    Node* head;
    BrowserHistory(string homepage) {
        head = new Node(homepage);    
    }
    
    void visit(string url) {
        head->next=new Node(url);
        head->next->prev=head;
        head=head->next;  
    }
    
    string back(int steps) {
        while(head->prev && steps--){
            head=head->prev;
        }
        return head->val;
    }
    
    string forward(int steps) {
        while(head->next && steps--){
            head=head->next;
    }
    return head->val;
    }
};

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory* obj = new BrowserHistory(homepage);
 * obj->visit(url);
 * string param_2 = obj->back(steps);
 * string param_3 = obj->forward(steps);
 */