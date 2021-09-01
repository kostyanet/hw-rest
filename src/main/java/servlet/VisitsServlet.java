package servlet;

import com.google.gson.Gson;
import pojo.Visit;
import service.VisitService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

/**
 * - GET /visits – получить все визиты в порядке добавления
 * - POST /visits – добавить новый визит (передать 3 параметра: имя, дата, город)
 */
public class VisitsServlet extends HttpServlet {
    private final static VisitService visitService = VisitService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter responseBody = resp.getWriter();
        resp.setContentType("application/json");
        resp.setStatus(200);

        var body = new Gson().toJson(visitService.getVisits());
        responseBody.println(body);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Visit visit = null;
        String body = parseRequestBody(req);

        visit = new Gson().fromJson(body, Visit.class);
        visit.setId(UUID.randomUUID());
        visitService.addVisit(visit);
        resp.setStatus(204);
    }

    private String parseRequestBody(HttpServletRequest req) throws IOException {
        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = req.getReader();
        String line;

        while ((line = reader.readLine()) != null) {
            buffer.append(line);
            buffer.append(System.lineSeparator());
        }
        return buffer.toString();
    }
}
