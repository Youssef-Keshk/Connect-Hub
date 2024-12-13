package managers;

import java.util.ArrayList;


public interface SearcherAbstraction<T> {
    public ArrayList<T> search(String searchKey);
}
