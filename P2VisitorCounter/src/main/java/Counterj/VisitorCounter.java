package Counterj;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import counterDao.MysqlDao;
import counterDao.TxtDao;
import counterDao.ExcelDao;

@WebServlet("/Counterj/visitor.do")
public class VisitorCounter extends HttpServlet{
	Scanner kb = new Scanner(System.in);
	public MysqlDao cd = new MysqlDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("name");
		String tel = req.getParameter("tel");
		String ment = req.getParameter("ment");
        System.out.println(name + " "+ tel + " "+ ment +  "\n"); // 데이터를 파일에 쓰기

        TxtDao td = new TxtDao();
        td.txt(name, tel, ment);
        
    //true를 붙이면 데이터가 누적해서 쌓임
        try {
            HttpSession session = req.getSession();
            if(session.getAttribute("num") != null) {
            	int num = (Integer)session.getAttribute("num");
            	num++;
                session.setAttribute("num", num);           	
            }
            else {
            	int num =1;
            	session.setAttribute("num", num);
            }
            int score = (Integer)session.getAttribute("num");
            cd.insertVisitor(name, tel, ment, score);
//        	ExcelDao ed = new ExcelDao();
//            ed.excelDaocreate();
        }
        catch (Exception e) {
            System.out.println("An error occurred.");

            e.printStackTrace();
        }

        
        req.getRequestDispatcher("../Counter/Login.jsp").forward(req, resp);
    }

		
	
}
