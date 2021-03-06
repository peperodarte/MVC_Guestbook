
package JavaServletCode;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ControllerDelete extends HttpServlet
{
    
     protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
       
        String uname = req.getParameter("uname");
      
        UserBean ub = new UserBean();
        ub.setUname(uname);
        
        req.setAttribute("ub", ub);
        DeleteDao ob=new DeleteDao();
        int k=ob.delete(ub);
        
       if(k>0)
        {
            RequestDispatcher rd = req.getRequestDispatcher("success.jsp");
            rd.forward(req, res);
        }
        else{
            RequestDispatcher rd = req.getRequestDispatcher("error.jsp");
            rd.include(req, res);
            
        }
        

    }
    @Override  
    protected void doGet(HttpServletRequest req, HttpServletResponse res)  
            throws ServletException, IOException {  
        doPost(req, res);  
    }  
    


}
