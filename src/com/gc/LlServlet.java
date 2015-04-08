package com.gc;

import static com.gc.Engine.OUR_ENGINE;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

@WebServlet("/LlServlet")
public class LlServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Holder ourHolder = new Holder();
		
		String url = "/index.html";
		//
		String userUrl = request.getParameter("userUrl");
		Document doc = Jsoup.connect(userUrl).get();
		String htmlBody = doc.select("body").html();
		//
		//String body = request.getParameter("body");
		String language[] = request.getParameterValues("language");
		
		ourHolder.setBody(htmlBody);
		ourHolder.setLanguage(language[0]);
		
		ourHolder = OUR_ENGINE.ourEngine(ourHolder);
		
		//
		String newBody = ourHolder.getBody();
		doc.select("body").empty();
		doc.select("body").html(newBody);
		String newHtml = doc.toString();
		ourHolder.setBody(newHtml.toString());
		//
		
		request.setAttribute("ourHolder", ourHolder);
		response.setContentType("text/html");
		
		url = "/result.jsp";
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
