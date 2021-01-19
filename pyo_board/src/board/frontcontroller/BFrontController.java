package board.frontcontroller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.command.BCommand;
import board.command.BContentCommand;
import board.command.BDeleteCommand;
import board.command.BListCommand;
import board.command.BModifyCommand;
import board.command.BReplyCommand;
import board.command.BReplyViewCommand;
import board.command.BWriteCommand;

/**
 * Servlet implementation class BFrontController
 */
@WebServlet("*.do")
public class BFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet");
		actionDo(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      System.out.println("actionDo");
	      
	      request.setCharacterEncoding("EUC-KR");
	      
	      String viewPage = null;
	      BCommand command = null;
	      
	      String uri = request.getRequestURI();
	      String conPath = request.getContextPath();
	      String com = uri.substring(conPath.length());
	      
	      System.out.println(uri);
	      System.out.println(conPath);
	      System.out.println(com);
	      
	      if(com.equals("/list.do")){	//±Û¸ñ·Ï
	         command = new BListCommand();
	         command.execute(request, response);
	         viewPage = "list.jsp";
	      } else if(com.equals("/content_view.do")){	//±Û³»¿ë
	    	  command = new BContentCommand();
		      command.execute(request, response);
		      viewPage = "content_view.jsp";
		  } else if(com.equals("/write_view.do")){	//ÀÛ¼ºÆû
		      viewPage = "write_view.jsp";
		  } else if(com.equals("/write.do")){	//ÀÛ¼ºÆû
			  command = new BWriteCommand();
		      command.execute(request, response);
		      viewPage = "list.do";
		  }  else if(com.equals("/delete.do")){	//ÀÛ¼ºÆû
			  command = new BDeleteCommand();
		      command.execute(request, response);
		      viewPage = "list.do";
		  } else if(com.equals("/modify.do")){	//ÀÛ¼ºÆû
			  command = new BModifyCommand();
		      command.execute(request, response);
		      viewPage = "list.do";
		  } else if(com.equals("/reply_view.do")){	//ÀÛ¼ºÆû
			  command = new BReplyViewCommand();
		      command.execute(request, response);
		      viewPage = "reply_view.jsp";
		  } else if(com.equals("/reply.do")){	//ÀÛ¼ºÆû
			  command = new BReplyCommand();
		      command.execute(request, response);
		      viewPage = "list.do";
		  } 
	         
	      RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);	//Servlet¿¡¼­ forwarding
	      dispatcher.forward(request, response);
	      
	      
	   }

}
