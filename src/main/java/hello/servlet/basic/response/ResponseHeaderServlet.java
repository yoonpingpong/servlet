package hello.servlet.basic.response;

import hello.servlet.basic.HelloServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HelloServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setStatus(HttpServletResponse.SC_OK);

        response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setHeader("my-header", "test");

        // cookie(response);
        redirect(response);

        response.getWriter().write("ok");
    }

    private void cookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600);

        response.addCookie(cookie);
    }

    private void redirect(HttpServletResponse response) throws IOException {
        // response.setStatus(HttpServletResponse.SC_FOUND);
        // response.setHeader("location", "/basic/hello-form.html");
        response.sendRedirect("/basic/hello-form.html");
    }
}
