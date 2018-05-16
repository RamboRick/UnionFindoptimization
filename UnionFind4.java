package unionfind;

public class UnionFind4 implements UF {

    private int[] parent;
    private int[] rank; // sz[i] 表示以i为根的集合中元素的个数

    public UnionFind4(int size){
        parent = new int[size];

        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    private int find(int p){
        if( p<0 && p >= parent.length){
            throw new IllegalArgumentException("p is out of bound.");
        }
        while(p != parent[p]){
            p = parent[p];
        }
        return p;
    }

    @Override
    // o(h) h 为树的高度
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    //o(h) h 为树的高度
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot == qRoot){
            return;
        }
        if(rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[pRoot] > rank[qRoot]){
            parent[qRoot] = pRoot;
        }
        else{
            parent[qRoot] = pRoot;
            rank[pRoot]+= 1;
        }
    }
}


