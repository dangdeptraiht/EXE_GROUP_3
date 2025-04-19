package model;

public class RequestList {
    private int requestID;
    private int userID;
    private String userName;
    private String title;
    private String description;
    private String typeName;
    private String createAt;
    private String resStatus;

    public RequestList(int userID, String userName, String title, String description, String typeName, String createAt, String resStatus) {
        this.userID = userID;
        this.userName = userName;
        this.title = title;
        this.description = description;
        this.typeName = typeName;
        this.createAt = createAt;
        this.resStatus = resStatus;
    }

    public RequestList(int requestID, int userID, String userName, String title, String description, String typeName, String createAt, String resStatus) {
        this.requestID = requestID;
        this.userID = userID;
        this.userName = userName;
        this.title = title;
        this.description = description;
        this.typeName = typeName;
        this.createAt = createAt;
        this.resStatus = resStatus;
    }

    
    
    public RequestList(String userName, String title, String description, String typeName, String createAt, String resStatus) {
        this.userName = userName;
        this.title = title;
        this.description = description;
        this.typeName = typeName;
        this.createAt = createAt;
        this.resStatus = resStatus;
    }
    
    public int getRequestID() {
        return requestID;
    }

    // Getters and Setters
    public void setRequestID(int requestID) {    
        this.requestID = requestID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getResStatus() {
        return resStatus;
    }

    public void setResStatus(String resStatus) {
        this.resStatus = resStatus;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    

    @Override
    public String toString() {
        return "SimpleRequest{" +
                "userName='" + userName + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", typeName='" + typeName + '\'' +
                ", createAt='" + createAt + '\'' +
                ", resStatus='" + resStatus + '\'' +
                '}';
    }
}
