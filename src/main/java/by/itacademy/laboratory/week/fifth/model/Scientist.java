package by.itacademy.laboratory.week.fifth.model;

import java.util.*;

public class Scientist {

    private Map<RobotDetail, Integer> robotDetails = new EnumMap<>(RobotDetail.class);
    private String name;

    public Scientist(String name) {
        this.name = name;
    }

    public void addRobotDetails(List<RobotDetail> list) {
        list.forEach(detail -> robotDetails.merge(detail, 1, Integer::sum));
    }

    public List<Robot> buildRobots() {
        List<Robot> robots = new ArrayList<>();
        Optional<Integer> robotsCount = robotDetails.values().stream().min(Integer::compareTo);
        robotsCount.ifPresent(value -> {
            for (int i = 0; i < value; i++) {
                robotDetails.forEach((k, v) -> robotDetails.merge(k, -1, Integer::sum));
                robots.add(new Robot());
            }
        });

        return robots;
    }

    public String getName() {
        return name;
    }
}
