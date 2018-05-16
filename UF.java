package unionfind;

public interface UF {
    int getSize();
    boolean isConnected(int p, int q); // id为p id为q
    void unionElements(int p, int q);
}
