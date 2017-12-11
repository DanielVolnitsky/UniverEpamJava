package tasks.task08_28_11_2017.entities;

import java.util.ArrayList;
import java.util.List;

public class CandyStock {
    private List<Candy> candies;

    {
        candies = new ArrayList<>();
    }

    public CandyStock() {

    }

    public List<Candy> getCandies() {
        return candies;
    }

    public void setCandies(List<Candy> candies) {
        this.candies = candies;
    }

    public void addCandyList(List<Candy> newCandies) {
        if (newCandies != null && newCandies.size() > 0) {
            for (Candy candy : newCandies) {
                addCandy(candy);
            }
        }

    }

    public void addCandy(Candy candy) {
        if (candy != null)
            this.candies.add(candy);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Candy candy : candies) {
            sb.append(candy.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
