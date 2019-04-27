package bean;

import service.StudentManager;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static javafx.scene.input.KeyCode.H;

public class SMTest {
    @Resource
    private static WebServiceContext webServiceContext;
    public static void main(String[] args) throws Exception {


        Student student=new Student();
        student.setName("a");
        student.setId("2016012078");
        student.setPsw("123123");
        student.setGender("女") ;
        student.setBirDate("1997-04-25"); ;
        StudentManager studentManager=new StudentManager();

        //增加
        boolean addS=studentManager.addUser(student);
        if(addS)
        {
            System.out.println("add student success");
        }else{
            System.out.println("add student fail");
        }
         //删除
        boolean deleteS=studentManager.delUser("2016012054");
        if(deleteS)
        {
            System.out.println("delete student success");
        }else{
            System.out.println("delete student fail");
        }
        //更新
        boolean updateS=studentManager.updateUser(student);
        if(updateS)
        {
            System.out.println("update student success");
        }else{
            System.out.println(" update student fail");
        }
        //查询
        List<Student> students=new ArrayList<>();
        students=studentManager.query();
        for(int i=0;i<students.size();i++)
        {
            System.out.print(students.get(i).getId()+" ");
            System.out.print(students.get(i).getPsw()+" ");
            System.out.print(students.get(i).getName()+" ");
            System.out.print(students.get(i).getName()+" ");
            System.out.print(students.get(i).getBirDate()+" ");
            System.out.println("");
        }
    }


}

