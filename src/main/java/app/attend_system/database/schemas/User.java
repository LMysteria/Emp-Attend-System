package app.attend_system.database.schemas;

public class User{
    private String username;
    private String password;

    public User(String username, String password){
        this.username=username;
        this.password=password;
    }

    public String getusername(){
        return this.username;
    }
    public String getpassword(){
        return this.password;
    }
}
