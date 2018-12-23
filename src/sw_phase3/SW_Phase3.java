
package sw_phase3;

import java.util.Scanner;


public class SW_Phase3 {

    
    public static void main(String[] args) {
        
        DataBase db = new DataBase();
        String CurrUsername = "";
        String name = "" ;
        String username = "" ;
        String password = "";
        boolean loggin = false;
        
        System.out.println("Welcome :");
        System.out.println("1) Sign Up");
        System.out.println("2) Log In");
        System.out.println("3) Add Post");
        System.out.println("4) Search lost Item");
        System.out.println("5) log out");
        
        Scanner menu = new Scanner(System.in);
        Scanner info = new Scanner(System.in);
        int choice =-1;
        
        while(choice != 6 ){
            
            choice = menu.nextInt();

            switch(choice){
                case 1 :
                    /*
                    Sign up
                    */
                    name = info.nextLine();
                    username = info.nextLine();
                    password = info.nextLine();
                    User curr = new User(username , name , password);
                    db.v1.add(curr);
                    CurrUsername = username;
                    break;

                case 2 :
                    /*
                    Sign in
                    */        
                    if(!loggin){
                        System.out.println("logged in");
                        break;
                    }
                    
                    username = info.nextLine();
                    password = info.nextLine();
                    for(int i=0 ; i<db.v1.size(); i++){
                        if( ((User)db.v1.get(i)).Username == username){
                            if( ((User)db.v1.get(i)).Password == password){
                                System.out.println("Welcome .");
                                CurrUsername = username;
                                loggin = true;
                                break;
                            }
                        } 
                    }        
                    if(!loggin){
                        System.out.println("Wrong Username or password .");
                    }
                    break;

                case 3 :
                    /*
                    Add Post
                    */
                    
                    String description ="" , lostId= "";
                    Boolean stat = false;
                    int id = -1;

                    for(int i=0;i<db.v1.size();i++){
                        if( ((User)db.v1.get(i)).Username == CurrUsername ){
                            id = ((User)db.v1.get(i)).id; 
                        }
                    }

                    Post newPost = new Post(id , description , lostId , stat);
                    db.v2.add(newPost);

                    break;

                case 4 :
                    /*
                    Search lost item
                    */

                    String lost_ID = "";

                    for(int i=0 ; i < db.v2.size() ; i++){
                        if( ((Post)db.v2.get(i)).lost_id == lost_ID ){
                            System.out.println("Description :" +((Post)db.v2.get(i)).Desc);
                            System.out.println("Lost ID :" +((Post)db.v2.get(i)).lost_id);
                            System.out.println("Status :" +((Post)db.v2.get(i)).status);
                        }
                    }
                    break;

                case 5 :
                    /*
                    log out
                    */        
                    CurrUsername = "";
                    break;               

            }
        }
        
        
        
        
        
        
        
        
        
    
    }
    
}
