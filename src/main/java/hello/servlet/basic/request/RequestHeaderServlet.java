package hello.servlet.basic.request;

import hello.servlet.basic.HelloServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name="requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HelloServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        printStartLine(request);
        printHeaders(request);
    }

    private void printStartLine(HttpServletRequest request) {
        System.out.println("---Request-Line - Start---");

        String method = request.getMethod();
        System.out.println("method = " + method);

        String protocol = request.getProtocol();
        System.out.println("protocol = " + protocol);

        String scheme = request.getScheme();
        System.out.println("scheme = " + scheme);

        StringBuffer requestURL = request.getRequestURL();
        System.out.println("requestURL = " + requestURL);

        String requestURI = request.getRequestURI();
        System.out.println("requestURI = " + requestURI);

        String queryString = request.getQueryString();
        System.out.println("queryString = " + queryString);

        boolean secure = request.isSecure();
        System.out.println("secure = " + secure);

        System.out.println("---Request-Line - End---");
    }

    private void printHeaders(HttpServletRequest request) {
        System.out.println("---Headers - Start---");


//        Enumeration<String> headerNames = request.getHeaderNames();
//        while(headerNames.hasMoreElements()){
//            String headerName = headerNames.nextElement();
//            System.out.println(headerName + " : " + headerNames);
//        }

        request.getHeaderNames().asIterator()
               .forEachRemaining(headerName -> System.out.println(headerName + " : " + request.getHeader(headerName)));

        System.out.println("---Headers - End---");
    }
}
