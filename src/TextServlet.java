import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/text")
public class TextServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String words = request.getParameter("Ilość słów");
        String characters = request.getParameter("Ilość znaków");
        String charactersWithout = request.getParameter("Ilość znaków (bez spacji)");

        String result = "";
        if(words != null) {
            result += "Ilość słów: " + Calculator.wordcount1;
        } else {
             result += "Tekst nie zawiera słów" ;
        }

        if(characters != null) {
            result += "Ilość znaków: " + Calculator.wordcount2();
        } else {
              result += "Tekst nie zawiera znaków";
        }

        if(charactersWithout != null) {
            result += "Ilość znaków (bez spacji): " + Calculator.wordcount3();
        } else {
             result += "Tekst nie zawiera znaków (bez spacji)";
        }

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        response.getWriter().println(result);

    }
}
