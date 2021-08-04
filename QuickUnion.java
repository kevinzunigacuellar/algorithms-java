public class QuickUnion {
  private int[] id;
  private int[] size;

  public QuickUnion(int N){
    id = new int[N];
    size = new int[N];
    for (int i = 0; i < id.length; i++) {
      id[i] = i;
      size[i] = 1;
    }
  }
  private int root(int i){
    while (id[i] != i) i = id[i];
    return i;
  }
  public boolean connected(int p, int q) {
    return root(p) == root(q);
  }
  public void union(int p, int q){
    int rootP = root(p);
    int rootQ = root(q);
    if (rootP == rootQ) return;
    if (size[rootP] > size[rootQ]){
      id[rootQ] = rootP; 
      size[rootP] += size[rootQ];
    }
    else {
      id[rootP] = rootQ;
      size[rootQ] += size[rootP];
    }
    
  }
  public static void main(String[] args) {
    QuickUnion example = new QuickUnion(5);
    example.union(1,2);
    example.connected(0,2);

    
  }
}
