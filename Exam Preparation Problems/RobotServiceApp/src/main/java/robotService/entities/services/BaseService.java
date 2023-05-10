package robotService.entities.services;

import robotService.common.ConstantMessages;
import robotService.common.ExceptionMessages;
import robotService.entities.robot.Robot;
import robotService.entities.supplements.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class BaseService implements Service{
    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Robot> robots;

    public BaseService(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.supplements = new ArrayList<>();
        this.robots = new ArrayList<>();
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.SERVICE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<Robot> getRobots() {
        return this.robots;
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return this.supplements;
    }

    @Override
    public void addRobot(Robot robot) {
        if (this.robots.size() < this.capacity ){
            this.robots.add(robot);
        }
        else {
            throw  new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_ROBOT);
        }
    }

    @Override
    public void removeRobot(Robot robot) {
        this.robots.remove(robot);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        this.supplements.add(supplement);
    }

    @Override
    public void feeding() {
        for (Robot robot : this.robots){
            robot.eating();
        }
    }

    @Override
    public int sumHardness() {
        int sum = 0;
        for (Supplement supplement : this.supplements){
            sum += supplement.getHardness();
        }
        return sum;
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" ").append(this.getClass().getSimpleName()).append(System.lineSeparator());
        sb.append("Robots: ");
        if (this.robots.size() == 0){
            sb.append("none").append(System.lineSeparator());
        }
        else {
            List<Robot> robotList = (List<Robot>) this.robots;
            for (int i = 0; i < this.robots.size(); i++) {
                Robot robot = robotList.get(i);
                if (i == this.robots.size() - 1){
                    sb.append(robot.getName()).append(System.lineSeparator());
                }
                else {
                    sb.append(robot.getName()).append(" ");
                }
            }
        }
        sb.append("Supplements: ").append(this.supplements.size())
                .append(" Hardness: ").append(this.sumHardness()).append(System.lineSeparator());
        return sb.toString();
    }
}
