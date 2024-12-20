package iterators;

import entities.Friendship;

public class FriendshipIterator implements Iterator{
    private final Friendship[] friendships;
    private int position = 0;

    public FriendshipIterator(Friendship[] friendships) {
        this.friendships = friendships;
    }

    
    @Override
    public boolean hasMore() {
        return position < friendships.length && friendships[position] != null;
    }

    @Override
    public Friendship getNext() {
        Friendship friendship = friendships[position];
        position++;
        return friendship;
    }
    
    
}
