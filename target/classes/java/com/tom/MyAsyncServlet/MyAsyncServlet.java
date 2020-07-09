package com.tom.MyAsyncServlet;







import org.springframework.stereotype.Component;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
@WebServlet(name = "asyncservlet", asyncSupported = true, urlPatterns = "/async")
@Component
public class MyAsyncServlet extends HttpServlet {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:ss:mm");

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        doGet(request, response);
    }
    public void doTest() {
        System.out.println("wansuisui");
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write("one"+sdf.format(new Date()));
        out.write("<br>");
        out.flush();
        AsyncContext context = request.startAsync(request, response);
        new Thread(new RunNew(context)).start();
        out.write("second" + sdf.format(new Date()));
        out.write("<br>");



    }



    class RunNew implements Runnable {
        AsyncContext context = null;
        public RunNew(AsyncContext context) {
            this.context = context;
        }

        public void run() {
            try {
                Thread.sleep(20000);
                System.out.println("xxxxxxxxxxxxx");

                HttpServletResponse response =(HttpServletResponse) context.getResponse();
                PrintWriter out = response.getWriter();
                out.write("three"+sdf.format(new Date()));
                out.write("<br>");
                context.complete();
            } catch (Exception exception) {

            }

        }
    }

    public static void main(String[] args) {

    }
}
