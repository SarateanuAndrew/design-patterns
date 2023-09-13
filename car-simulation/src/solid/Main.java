package solid;

import solid.cars.GoodCar;
import solid.cars.StandardCar;
import solid.cars.VipCar;
import solid.company.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Department foodMarket = new FoodMarket(12);
        Department gasStation = new GasStation(20);
        Department mechanicalDepartment = new MechanicalDepartment(100);
        Department washing = new Washing(20);
        Department designDepartment = new DesignDepartment(40);
        List<StandardCar> cars = new ArrayList<>(List.of(new StandardCar(), new GoodCar(), new VipCar()));
        boolean cycle = true;
        Scanner scanner = new Scanner(System.in);
        Map<Department, Integer> map = new HashMap<>();
        map.put(foodMarket, 600);
        map.put(gasStation, 800);
        map.put(mechanicalDepartment, 100);
        map.put(washing, 600);
        map.put(designDepartment, 200);
        int findCar;
        int gasQuantity, foodQuantity, piecesQuantity, showerQuantity, paintQuantity;
        int foodUse = 0, gasUse = 0, mechanicUse = 0, washUse = 0, paintUse = 0;
        int foodIncome = 0, gasIncome = 0, mechanicIncome = 0, washIncome = 0, paintIncome = 0;
        int isHappy = 0, isGood = 0, isNormal = 0, isMoody = 0, isSad = 0;
        int isHappy2 = 0, isGood2 = 0, isNormal2 = 0, isMoody2 = 0, isSad2 = 0;
        String stop;
        double totalSum = 0;
        double monthSum = 0;
        int daySum;
        int clients = 15;
        //Cycle Star
        for (int i = 1; cycle; i++) {
            daySum = 0;
            if (clients <= 0) {
                System.out.println("We have less clients than normal you lost");
                break;
            }
            findCar = random.nextInt(10, clients);
            System.out.println("_____________");
            System.out.println(i + ". Day ");
            for (int j = 1; j <= findCar; j++) {

                //Car declaring

                StandardCar car = cars.get(random.nextInt(cars.size()));
                car.setClean(random.nextInt(0, 2));
                car.setFood(random.nextInt(0, 2));
                car.setFuel(random.nextInt(0, 2));
                foodQuantity = random.nextInt(2, 5);
                gasQuantity = random.nextInt(10, 15);
                piecesQuantity = random.nextInt(1, 4);
                showerQuantity = random.nextInt(3, 6);
                paintQuantity = random.nextInt(2, 5);
                if (car.getFood() == 0 || car.getFuel() == 0 || car.getRepair() == 0 || car.getClean() == 0) {
                    if (car.getClass().equals(VipCar.class)) {
                        ((VipCar) car).setTuning(random.nextInt(0, 2));
                        car.setMoney(random.nextInt(300, 500));
                        System.out.println(j + ". Vip Car ");
                    } else if (car.getClass().equals(StandardCar.class)) {
                        System.out.println(j + ". Standard Car");
                        car.setMoney(random.nextInt(100, 300));
                    } else {
                        System.out.println(j + ". Good Car");
                        car.setMoney(random.nextInt(200, 400));
                    }

                    //Start doing car requirements

                    if (car.getFood() == 0 && map.get(foodMarket) > 0 && car.getMoney() >= (foodQuantity * foodMarket.getPrice())) {
                        map.replace(foodMarket, map.get(foodMarket) - foodQuantity);
                        car.setFood(1);
                        car.setMoney(car.getMoney() - foodQuantity * foodMarket.getPrice());
                        System.out.println("    Buy food: " + foodQuantity);
                        foodUse += 1;
                        daySum += foodQuantity * foodMarket.getPrice();
                        foodIncome += foodQuantity * foodMarket.getPrice();
                    }
                    if (car.getFuel() == 0 && map.get(gasStation) > 0 && car.getMoney() >= (gasQuantity * gasStation.getPrice())) {
                        map.replace(gasStation, map.get(gasStation) - gasQuantity);
                        car.setFuel(1);
                        car.setMoney(car.getMoney() - gasQuantity * gasStation.getPrice());
                        daySum += gasQuantity * gasStation.getPrice();
                        System.out.println("    Buy fuel: " + gasQuantity);
                        gasUse += 1;
                        gasIncome += gasQuantity * gasStation.getPrice();
                    }
                    if (car.getRepair() == 0 && map.get(mechanicalDepartment) > 0 && car.getMoney() >= (piecesQuantity * mechanicalDepartment.getPrice())) {
                        map.replace(mechanicalDepartment, map.get(mechanicalDepartment) - piecesQuantity);
                        car.setRepair(1);
                        car.setMoney(car.getMoney() - piecesQuantity * mechanicalDepartment.getPrice());
                        daySum += piecesQuantity * mechanicalDepartment.getPrice();
                        System.out.println("    Need repair using: " + piecesQuantity);
                        mechanicUse += 1;
                        mechanicIncome += piecesQuantity * mechanicalDepartment.getPrice();
                    }
                    if (car.getClean() == 0 && map.get(washing) > 0 && car.getMoney() >= (showerQuantity * washing.getPrice())) {
                        map.replace(washing, map.get(washing) - showerQuantity);
                        car.setClean(1);
                        car.setMoney(car.getMoney() - showerQuantity * washing.getPrice());
                        daySum += showerQuantity * washing.getPrice();
                        System.out.println("    Need washing with: " + showerQuantity);
                        washUse += 1;
                        washIncome += showerQuantity * washing.getPrice();
                    }
                    if (car.getClass().equals(VipCar.class) && ((VipCar) car).getTuning() == 0 && map.get(designDepartment) > 0 && car.getMoney() >= (paintQuantity * designDepartment.getPrice())) {
                        map.replace(designDepartment, map.get(designDepartment) - paintQuantity);
                        ((VipCar) car).setTuning(1);
                        car.setMoney(car.getMoney() - paintQuantity * designDepartment.getPrice());
                        daySum += paintQuantity * designDepartment.getPrice();
                        System.out.println("    Need coloured: " + paintQuantity);
                        paintUse += 1;
                        paintIncome += paintQuantity * designDepartment.getPrice();
                    }
                    String service = car.service();
                    System.out.println("@" + service);
                    if (service.equals("Is Happy")) {
                        isHappy += 1;
                    }
                    if (service.equals("Is good")) {
                        isGood += 1;
                    }
                    if (service.equals("Is normal")) {
                        isNormal += 1;
                    }
                    if (service.equals("Is moody")) {
                        isMoody += 1;
                    }
                    if (service.equals("Is sad")) {
                        isSad += 1;
                    }
                }
            }
            monthSum += daySum;
            System.out.println("_____________");

            if (i % 30 == 0) {
                System.out.println("******************************");
                System.out.println(i / 30 + ". Month");
                System.out.println("The month income: " + monthSum);
                System.out.println("The month medium income: " + monthSum / 30);
                totalSum += monthSum;
                System.out.println("Clients Status");
                System.out.println("Happy: " + isHappy);
                System.out.println("Good: " + isGood);
                System.out.println("Normal: " + isNormal);
                System.out.println("Moody: " + isMoody);
                System.out.println("Sad: " + isSad);
                if (isHappy > 100) {
                    System.out.println("We had a productive month may be next month we will have more clients");
                    clients += 2;
                } else if ((isSad >= 3) || (isMoody >= 5)) {
                    System.out.println("We had a less productive month may be next month we will have less clients");
                    clients -= 2;
                }
                if (clients > 20) {
                    System.out.println("We have  more with 25% of clients your business is successful ");
                }

                monthSum = 0;
                isHappy2 += isHappy;
                isGood2 += isGood;
                isNormal2 += isNormal;
                isMoody2 += isMoody;
                isSad2 += isSad;
                isHappy = 0;
                isGood = 0;
                isNormal = 0;
                isMoody = 0;
                isSad = 0;

                map.put(foodMarket, 600);
                map.put(gasStation, 800);
                map.put(mechanicalDepartment, 100);
                map.put(washing, 600);
                map.put(designDepartment, 200);
                System.out.println("******************************");

                //Stop & Final Function
                System.out.print("Tap \"Stop\" to finish: ");
                stop = scanner.next();
                if (stop.equals("Stop")) {
                    System.out.println("####################################################################");

                    System.out.println("The total income: " + totalSum);
                    System.out.println("The medium income: " + totalSum / (i / 30));
                    System.out.println("The number of cars that need food " + foodUse + " with income of " + foodIncome);
                    System.out.println("The number of cars that need fuel " + gasUse + " with income of " + gasIncome);
                    System.out.println("The number of cars that need mechanic " + mechanicUse + " with income of " + mechanicIncome);
                    System.out.println("The number of cars that need washing " + washUse + " with income of " + washIncome);
                    System.out.println("The number of cars that need painting " + paintUse + " with income of " + paintIncome);
                    List<Integer> integers1 = new ArrayList<>(List.of(foodUse, gasUse, mechanicUse, washUse, paintUse));
                    List<Integer> integers2 = new ArrayList<>(List.of(foodIncome, gasIncome, mechanicIncome, washIncome, paintIncome));

                    System.out.println("The least used is: " + integers1.stream().min(Integer::compareTo).orElseThrow());
                    System.out.println("The smallest income is: " + integers2.stream().min(Integer::compareTo).orElseThrow());

                    System.out.println("The most used is: " + integers1.stream().max(Integer::compareTo).orElseThrow());
                    System.out.println("The biggest income is: " + integers2.stream().max(Integer::compareTo).orElseThrow());
                    System.out.println("Clients Final Status");
                    System.out.println("Happy: " + isHappy2);
                    System.out.println("Good: " + isGood2);
                    System.out.println("Normal: " + isNormal2);
                    System.out.println("Moody: " + isMoody2);
                    System.out.println("Sad: " + isSad2);

                    System.out.println("####################################################################");
                    cycle = false;
                }
            }
        }

    }
}