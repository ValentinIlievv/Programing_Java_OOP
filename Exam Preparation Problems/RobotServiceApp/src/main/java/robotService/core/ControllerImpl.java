package robotService.core;

import robotService.common.ConstantMessages;
import robotService.common.ExceptionMessages;
import robotService.entities.robot.FemaleRobot;
import robotService.entities.robot.MaleRobot;
import robotService.entities.robot.Robot;
import robotService.entities.services.MainService;
import robotService.entities.services.SecondaryService;
import robotService.entities.services.Service;
import robotService.entities.supplements.MetalArmor;
import robotService.entities.supplements.PlasticArmor;
import robotService.entities.supplements.Supplement;
import robotService.repositories.SupplementRepository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller{
    private SupplementRepository supplements;
    private Collection<Service> services;


    public ControllerImpl() {
        this.supplements = new SupplementRepository();
        this.services = new ArrayList<>();
    }

    @Override
    public String addService(String type, String name) {
        Service service = null;
        if (type.equals("MainService")){
            service = new MainService(name);
        }
        else if (type.equals("SecondaryService")){
            service = new SecondaryService(name);
        }
        else {
            throw new NullPointerException(ExceptionMessages.INVALID_SERVICE_TYPE);
        }
        this.services.add(service);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SERVICE_TYPE, type);
    }

    @Override
    public String addSupplement(String type) {
        Supplement supplement = null;
        if (type.equals("MetalArmor")){
            supplement = new MetalArmor();
        }
        else if (type.equals("PlasticArmor")){
            supplement = new PlasticArmor();
        }
        else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_SUPPLEMENT_TYPE);
        }
        this.supplements.addSupplement(supplement);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForService(String serviceName, String supplementType) {
        Supplement supplement = this.supplements.findFirst(supplementType);
        Service service = this.services.stream().filter(service1 -> service1.getName().equals(serviceName))
                .findFirst().orElse(null);
        if (supplement == null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_SUPPLEMENT_FOUND,supplementType));
        }
            service.addSupplement(supplement);
            this.supplements.removeSupplement(supplement);


        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_IN_SERVICE, supplementType, serviceName);
    }

    @Override
    public String addRobot(String serviceName, String robotType, String robotName, String robotKind, double price) {
        Robot robot = null;
        String suitableService = null;
        if (robotType.equals("FemaleRobot")){
            robot = new FemaleRobot(robotName, robotKind, price);
            suitableService = "SecondaryService";
        }
        else if (robotType.equals("MaleRobot")){
            robot = new MaleRobot(robotName, robotKind, price);
            suitableService = "MainService";
        }
        else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_ROBOT_TYPE);
        }
        Service service = this.services.stream().filter(service1 -> service1.getName().equals(serviceName))
                .findFirst().orElse(null);
        if (service.getClass().getSimpleName().equals(suitableService)){
            service.addRobot(robot);
        }
        else {
            return ConstantMessages.UNSUITABLE_SERVICE;
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_ROBOT_IN_SERVICE, robotType, serviceName);
    }

    @Override
    public String feedingRobot(String serviceName) {
        Service service = this.services.stream().filter(service1 -> service1.getName().equals(serviceName))
                .findFirst().orElse(null);

            service.feeding();

        return String.format(ConstantMessages.FEEDING_ROBOT, service.getRobots().size());
    }

    @Override
    public String sumOfAll(String serviceName) {
        Service service = this.services.stream().filter(service1 -> service1.getName().equals(serviceName))
                .findFirst().orElse(null);
        double sum = 0;
        for (Robot robot : service.getRobots()){
            sum += robot.getPrice();
        }
        for (Supplement supplement : service.getSupplements()){
            sum += supplement.getPrice();
        }
        return String.format(ConstantMessages.VALUE_SERVICE,serviceName, sum);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Service service : this.services){
            sb.append(service.getStatistics());
        }
        return sb.toString();
    }
}
