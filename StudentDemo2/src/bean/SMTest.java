package bean;

import service.StudentManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.util.Scanner;

import static javafx.scene.input.KeyCode.H;

public class SMTest {

    public static void main(String[] args) throws ServletException, IOException {
        HttpServletResponse response=null;
        HttpServletRequest request = null;
        int i;
        Scanner input =new Scanner(System.in);
        i=input.nextInt();
        StudentManager s=new StudentManager();
        s.app(i,request,response);

    }


}

