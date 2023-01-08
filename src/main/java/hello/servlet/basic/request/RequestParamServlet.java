package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

@WebServlet(name="requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[전체 파라미터 조회] Start");
        request.getParameterNames().asIterator()
                .forEachRemaining(parameterName -> System.out.println(parameterName + " : " + request.getParameter(parameterName)));
        System.out.println("[전체 파라미터 조회] End");
        System.out.println();

        System.out.println("[단일 파라미터 조회] Start");
        String username = request.getParameter("username");
        System.out.println("username : " + username);

        int age = Integer.parseInt(request.getParameter("age"));
        System.out.println("age : " + age);
        System.out.println("[단일 파라미터 조회] End");
        System.out.println();

        System.out.println("[이름이 같은 복수 파라미터 조회] Start");
        String[] usernames = request.getParameterValues("username");
        Arrays.stream(usernames).iterator()
                .forEachRemaining(name -> System.out.println("name : " + name));
        
        System.out.println("[이름이 같은 복수 파라미터 조회] End");

        response.getWriter().write("ok");
    }
}
