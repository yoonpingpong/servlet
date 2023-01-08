package hello.servlet.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;
import hello.servlet.basic.HelloServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name="requestBodyJsonServlet", urlPatterns = "/request-body-json")
public class RequestBodyJsonServlet extends HelloServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream();
        String jsonString = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        System.out.println("jsonString = " + jsonString);

        HelloData helloData = objectMapper.readValue(jsonString, HelloData.class);
        String username = helloData.getUsername();
        System.out.println("username : " + username);

        int age = helloData.getAge();
        System.out.println("age : " + age);

        response.getWriter().write("ok");
    }
}
