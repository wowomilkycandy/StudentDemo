
package bean;

import service.StudentManager;

import java.util.List;


public class test {
    public static void main(String[] args) {


        Page page = new Page();


        StudentManager userDao = new StudentManager();
        Page page1 = new Page();


        List list = (List) userDao.query(page, "1111");
        List list1 = userDao.query();

        System.out.println(list.size());
        System.out.println(page.getList());
        System.out.println(page.getCount());


    }
}
