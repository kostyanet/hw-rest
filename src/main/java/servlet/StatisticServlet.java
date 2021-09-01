package servlet;

import com.google.gson.Gson;
import service.VisitService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * - GET /statistics – получает данные об общем количестве запросов и текущую дату.
 */
public class StatisticServlet extends HttpServlet {
    private final static VisitService visitService = VisitService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter responseBody = resp.getWriter();
        resp.setContentType("application/json");
        resp.setStatus(200);

        var body = new Gson().toJson(visitService.getStats());
        responseBody.println(body);
    }
}
