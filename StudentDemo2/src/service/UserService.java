package service;

import bean.MD5;
import bean.Student;



public class UserService {

    public boolean checkLogin(String name, String psw) {
        StudentManager ud = new StudentManager();

        if (name.equals("") || name == null) {
            return false;
        } else {
            System.out.println("wojinglail ");
            Student user = ud.query(name);
            if (user==null||user.equals(null)) {
                System.out.println(user);
                System.out.println("wocuollalalalala");

                return false;
            } else {
                String passw = user.getPsw();
                System.out.println("这是密码啦啦啦啦111");
                String mPassWord = MD5.MD5Encode(psw);
                if (passw.equals(mPassWord))
                    return true;
                else
                    return false;
            }
        }
    }

    public Student getUserInfo(String loginName) {
        Student user = new Student();
        user.setName(loginName);

        return user;

    }
    /*public ModelAndView authUser(UserDto userDto){
        int i=0;
        //对用户登录传过来的哈希密码先进行加密
        String s=userDto.getUser_psw();
        String smi=convertMD5(s);
        //加密后，与数据库存储的密码进行比对
        userDto.setUser_psw(smi);
        try {
            i=userDao.login(userDto);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(i==1){
            System.out.println("用户登录成功");
        }else{
            System.out.println("用户登录失败");
        }
        return new ModelAndView("NewFile.jsp");
    }*/

}

