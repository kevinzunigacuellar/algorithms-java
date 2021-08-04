import java.util.Arrays;

public class QuickFind {
    private int[] id;

    public QuickFind(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) id[i]=i;
    }
    public boolean connected(int p, int q){
        return id[p] == id[q];
    }
    public void union(int p, int q){
        int idp = id[p];
        int idq = id[q];
        for (int i = 0; i < id.length; i++){
            if (id[i] == idp) id[i]=idq;
        }
    }

    public static void main(String[] args){
        QuickFind example = new QuickFind(10);
        System.out.println(Arrays.toString(example.id));
    }
}

