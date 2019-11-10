package app.android.frisco.bdapp.clases.Usuarios;

import com.orm.SugarRecord;

import java.util.List;

public class UserRepository{

    public static List<User> list(){
        List<User> users= SugarRecord.listAll(User.class);
        return users;
    }

    public static User read(long id){
        User user=SugarRecord.findById(User.class,id);
        return user;
    }

    public static void create(String usuario, String fullname, String email, String password){
        User user= new User(usuario, fullname, email, password);
        SugarRecord.save(user);
    }

    public static void update(String usuario, String fullname, String email, String password, long id){
        User user= SugarRecord.findById(User.class, id);
        user.setUsuario(usuario);
        user.setFullname(fullname);
        user.setEmail(email);
        user.setPassword(password);
        SugarRecord.save(user);
    }

    public static void delete(long id){
        User user=SugarRecord.findById(User.class,id);
        SugarRecord.delete(user);
    }

    public static User findByUsername(String username){
        for (int i=0 ; i< list().size(); i++) {
            String fullname=UserRepository.read(i).getFullname();
            if(fullname.equalsIgnoreCase(username)) {
                return UserRepository.read(i);
            }
        }
        return null;
    }
}
