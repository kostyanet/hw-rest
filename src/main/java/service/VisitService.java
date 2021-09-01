package service;

import pojo.Statistic;
import pojo.Visit;

import java.util.ArrayList;
import java.util.List;

public class VisitService {
    private static final int MAX_SIZE = 3;
    private static VisitService instance = null;
    private static int requestsCounter = 0;
    private final static List<Visit> visits = new ArrayList<>();

    private VisitService() {
    }

    public static VisitService getInstance() {
        if (instance == null) {
            instance = new VisitService();
        }
        return instance;
    }

    private void incrementCounter() {
        requestsCounter++;
    }

    public List<Visit> getVisits() {
        incrementCounter();
        return visits;
    }

    public void addVisit(Visit visit) {
        incrementCounter();
        visits.add(visit);

        if (visits.size() > MAX_SIZE) {
            visits.remove(0);
        }
    }

    public Statistic getStats() {
        incrementCounter();
        return new Statistic(requestsCounter);
    }
}
