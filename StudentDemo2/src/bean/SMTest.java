package bean;

import service.StudentManager;
import javax.annotation.Resource;
import javax.xml.ws.WebServiceContext;
import java.util.ArrayList;
import java.util.List;

public class SMTest {
    @Resource
    private static WebServiceContext webServiceContext;
    public static void main(String[] args) throws Exception {
        Student student=new Student();//����һ���µ�student�࣬������ֵ
        student.setName("a");
        student.setId("2016012078");
        student.setPsw("123123");
        student.setGender("Ů") ;
        student.setBirDate("1997-04-25"); ;
        StudentManager studentManager=new StudentManager(); //����StudentManagerʵ����
        //�������ӷ���
        boolean addS=studentManager.addUser(student);
        if(addS) {
            System.out.println("add student success");
        }else{
            System.out.println("add student fail");
        }
         //����ɾ������
        boolean deleteS=studentManager.delUser("2016012054");
        if(deleteS) {
            System.out.println("delete student success");
        }else{
            System.out.println("delete student fail");
        }
        //���Ը��·���
        boolean updateS=studentManager.updateUser(student);
        if(updateS) {
            System.out.println("update student success");
        }else{
            System.out.println(" update student fail");
        }
        //���Բ�ѯ����
        List<Student> students=new ArrayList<>();
        students=studentManager.query();
        for(int i=0;i<students.size();i++) {
            System.out.print(students.get(i).getId()+" ");
            System.out.print(students.get(i).getPsw()+" ");
            System.out.print(students.get(i).getName()+" ");
            System.out.print(students.get(i).getName()+" ");
            System.out.print(students.get(i).getBirDate()+" ");
            System.out.println("");
        }
    }


}

