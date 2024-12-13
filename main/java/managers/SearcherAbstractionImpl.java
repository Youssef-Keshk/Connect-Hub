package managers;

// Using bridge pattern for run-time binding of the implementation

import java.util.ArrayList;


public class SearcherAbstractionImpl<T> implements SearcherAbstraction<T>{
    private final SearchGeneratorImplementor sgi;

    public SearcherAbstractionImpl(SearchGeneratorImplementor sgi) {
        super();
        this.sgi = sgi;
    }
            
    @Override
    public ArrayList<T> search(String searchKey) {
        return sgi.search(searchKey);
    }
    
}
