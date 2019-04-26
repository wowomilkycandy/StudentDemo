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
import java.util.Scanner;

import static javafx.scene.input.KeyCode.H;

public class SMTest {
    @Resource
    private static WebServiceContext webServiceContext;
    public static void main(String[] args) throws ServletException, IOException {

        MessageContext mc = webServiceContext.getMessageContext();
        HttpServletRequest request = (HttpServletRequest) (mc.get(MessageContext.SERVLET_REQUEST));
        HttpServletResponse response = (HttpServletResponse) (mc.get(MessageContext.SERVLET_REQUEST));
        int i;
        Scanner input =new Scanner(System.in);
        i=input.nextInt();
        StudentManager s=new StudentManager();
        s.app(i,request,response);

    }


}

