import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Calculator", urlPatterns = "/")
public class CalculatorServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Double firstOperand  = Double.parseDouble(req.getParameter("first"));
		String operand       = req.getParameter("operand");
		Double secondOperand = Double.parseDouble(req.getParameter("second"));

		Double result;

		switch (operand) {
			case "+":
				result = firstOperand + secondOperand ;
				break;

			case "-":
				result = firstOperand - secondOperand ;
				break;

			case "*":
				result = firstOperand * secondOperand ;
				break;

			case "/":
				result = firstOperand / secondOperand ;
				break;
			default:
				view(req, resp, "WEB-INF/error.jsp");
				return;
		}

		req.setAttribute("result", result);
		view(req, resp, "WEB-INF/result.jsp");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		view(req, resp, "WEB-INF/index.jsp");
	}

	protected void view(HttpServletRequest req, HttpServletResponse resp, String view) throws ServletException, IOException {
		resp.setContentType("text/html");
		RequestDispatcher requestDispatcher = req.getRequestDispatcher(view);
		requestDispatcher.include(req, resp);
	}
}
