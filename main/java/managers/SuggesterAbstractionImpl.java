package managers;

import java.util.ArrayList;

// Using bridge pattern for run-time binding of the implementation

public class SuggesterAbstractionImpl implements SuggesterAbstraction{
    private final SuggestionsGeneratorImplementor sgi;

    public SuggesterAbstractionImpl(SuggestionsGeneratorImplementor sgi) {
        super();
        this.sgi = sgi;
    }
        
    @Override
    public ArrayList<String> suggest(String userID) {
        return sgi.suggest(userID);
    }
    
}
