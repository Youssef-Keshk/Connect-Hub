package friendmanagement.backend;


public class Friendship {
    private String senderID;
    private String receiverID;
    private String status;
    
    public Friendship(){}

    public Friendship(String senderID, String receiverId, String status) {
        this.senderID = senderID;
        this.receiverID = receiverId;
        this.status = status;
    }

    public String getSenderId() {
        return senderID;
    }

    public String getReceiverId() {
        return receiverID;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    

    @Override
    public String toString() {
        return "Friendship{" + "senderID=" + senderID + ", receiverID=" + receiverID + ", status=" + status + '}';
    }
    
    
    
}
