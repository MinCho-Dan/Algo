import java.util.*;

class Solution {
    class Node {
        int x, idx;
        Node l, r;
        Node(int x, int idx){
            this.x = x;
            this.idx = idx;
        }
    }

    int preIdx, postIdx;
    int[][] ans;

    public int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;
        ans = new int[2][n];

        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{nodeinfo[i][0], nodeinfo[i][1], i + 1};
        }

        Arrays.sort(arr, (a,b) ->
            a[1]==b[1] ? a[0]-b[0] : b[1]-a[1]);

        Node root = new Node(arr[0][0], arr[0][2]);

        for (int i = 1; i < n; i++)
            insert(root, arr[i][0], arr[i][2]);

        pre(root);
        post(root);

        return ans;
    }

    void insert(Node cur, int x, int idx){
        if(x < cur.x){
            if(cur.l == null) cur.l = new Node(x, idx);
            else insert(cur.l, x, idx);
        }else{
            if(cur.r == null) cur.r = new Node(x, idx);
            else insert(cur.r, x, idx);
        }
    }

    void pre(Node n){
        if(n==null) return;
        ans[0][preIdx++] = n.idx;
        pre(n.l);
        pre(n.r);
    }

    void post(Node n){
        if(n==null) return;
        post(n.l);
        post(n.r);
        ans[1][postIdx++] = n.idx;
    }
}