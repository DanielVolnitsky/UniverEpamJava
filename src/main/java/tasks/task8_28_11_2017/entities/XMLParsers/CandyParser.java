package tasks.task8_28_11_2017.entities.XMLParsers;

import tasks.task8_28_11_2017.entities.Candy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class CandyParser {
    protected String xmlPath;
    protected List<Candy> resultantCandies;

    {
        resultantCandies = new ArrayList<>();
    }

    public List<Candy> getResultantCandies() {
        return resultantCandies;
    }

    public abstract void parse() throws IOException;
}
