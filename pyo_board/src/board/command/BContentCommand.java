package board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BDao;
import board.dto.BDto;


public class BContentCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String bId = request.getParameter("bId");

		BDao dao = new BDao();

		BDto dto = dao.contentView(bId);

		request.setAttribute("content_view", dto);
	}

}
