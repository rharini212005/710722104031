package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("username");
        String pass = request.getParameter("password");
        boolean isValidUser = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "root", "");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM newtable WHERE username='" + uname + "' AND password='" + pass + "'");
            if (rs.next()) {
                isValidUser = true;
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (isValidUser) {
            response.sendRedirect("pages/welcome.jsp");
        } else {
            request.setAttribute("errorMessage", "Invalid username or password!");
            RequestDispatcher rd = request.getRequestDispatcher("pages/LoginView.jsp");
            rd.forward(request, response);
        }
    }
}
