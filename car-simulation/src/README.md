# Author: Sarateanu Andrei-Cristian

----

# Topic: *SOLID PRINCIPLES*
## Objectives:


&ensp; &ensp; __1. Study and understand the SOLID Principles.__

&ensp; &ensp; __2. Choose a domain, define its main classes/models/entities and choose the appropriate instantiation mechanisms.__

&ensp; &ensp;__3. Create a sample project that respects SOLID Principles.__

## Implementation

* Introduction

I have an interesting game on my phone and I decided to implement it's functionality in my program. 
I have company that have different departments at a fuel station, that departments give different services to their clients.
There are 3 types of car that are earlier named clients, they have different statuses. 

* Snippets from your files.

* S -> Single Responsibility:
```java
public class DesignDepartment extends Departments{
    public DesignDepartment(int price) {
        super(price);
    }

    @Override
    public void displayDepartmentName() {
        System.out.println("Design");
    }
}
```
* O -> Open Close:

I have added CompanyStaff, SecondaryCompany and SecondaryShow and interacted them with other classes.

* L -> Liskov Substitution:
```java
Departments foodMarket = new FoodMarket(12);
Departments gasStation = new GasStation(20);
```
* I -> Interface Segregation:
```java
public interface SecondaryCompany {
    void displaySecondaryCompanyName(String name);
}

public interface CompanyStaffCount {
    void countStaff();
}

public interface Company {
    void displayDepartmentName();
}
```

* D -> Dependency Inversion:
```java
public interface SecondaryCompany {
    void displaySecondaryCompanyName(String name);
}
public class SecondaryCompanyShow implements SecondaryCompany {
    private String companyName;
    
    @Override
    public void displaySecondaryCompanyName(String name) {
        System.out.println(name);
    }
}

public abstract class Departments implements Company, CompanyStaffCount{
    private SecondaryCompany secondaryCompany;
}
```

## Conclusion
To sum up, I have created a simulation of passing months ans the statistics of cars mood and the income of station and it's departments.
In my code I managed to implement somehow all SOLID principles and I learned all tactics used in the SOLID design principles.

##

----

# Topic: *Creational Design Patterns*
## Objectives:
&ensp; &ensp; __1. Study and understand the Creational Design Patterns.__

&ensp; &ensp; __2. Choose a domain, define its main classes/models/entities and choose the appropriate instantiation mechanisms.__

&ensp; &ensp; __3. Use some creational design patterns for object instantiation in a sample project.__

## Some Theory:
&ensp; &ensp; Creational design patterns are a category of design patterns that focus on the process of object creation. They provide a way to create objects in a flexible and controlled manner, while decoupling the client code from the specifics of object creation. Creational design patterns address common problems encountered in object creation, such as how to create objects with different initialization parameters, how to create objects based on certain conditions, or how to ensure that only a single instance of an object is created. There are several creational design patterns that have their own strengths and weaknesses. Each of it is best suited for solving specific problems related to object creation. By using creational design patterns, developers can improve the flexibility, maintainability, and scalability of their code.

&ensp; &ensp; Some examples of this kind of design patterns are:

* Singleton
* Builder
* Prototype
* Object Pooling
* Factory Method
* Abstract Factory

## Implementation

* Introduction

I decided to implement Singleton, Builder, Prototype and Factory design principles. The most of them I interact every day.
I created a java program where there is a Company and it is shown its department, that has employee. Also, employee has their own list of Obligations.

* Snippets from your files.

* Singleton Principle:

```java
public class CompanyDepartment {
    private static CompanyDepartment companyDepartment;
    private String name;

    private CompanyDepartment() {
    }

    public static CompanyDepartment getCompanyDepartment() {
        if (companyDepartment == null) {
            companyDepartment = new CompanyDepartment();
        }
        return companyDepartment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

* Prototype Principle:

```java
public class Employee implements Cloneable {
    private List<String> obligations;
    private String fullName;
    private int salary;
    private CompanyDepartment department;

    public Employee(EmployeeBuilder builder) {
        this.obligations = builder.obligations;
        this.fullName = builder.fullName;
        this.salary = builder.salary;
        this.department = builder.department;
    }

    public void saveObligation(Obligation obligation) {
        obligations.add(obligation.employeeObligation());
    }

    public void deleteObligation(Obligation obligation) {
        obligations.remove(obligation.employeeObligation());
    }

    public List<String> getObligations() {
        return obligations;
    }

    public String getFullName() {
        return fullName;
    }

    public CompanyDepartment getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Object clone = super.clone();
        List<String> tempOblig = new ArrayList<String>(this.getObligations());
        String tempFullName = this.getFullName();
        int tempSalary = this.getSalary();
        CompanyDepartment tempDepartment = this.getDepartment();
        return new EmployeeBuilder()
                .setSalary(tempSalary)
                .setDepartment(tempDepartment)
                .setObligations(tempOblig)
                .setFullName(tempFullName)
                .build();
    }
}
```

* Builder Principle:

```java
public static class EmployeeBuilder {
    private List<String> obligations;
    private String fullName;
    private int salary;
    private CompanyDepartment department;

    public EmployeeBuilder setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public EmployeeBuilder setSalary(int salary) {
        this.salary = salary;
        return this;
    }

    public EmployeeBuilder setObligations(List<String> obligations) {
        this.obligations = obligations;
        return this;
    }

    public EmployeeBuilder setDepartment(CompanyDepartment department) {
        this.department = department;
        return this;
    }

    public Employee build() {
        return new Employee(this);
    }
}
```

* Factory Principle:

```java
public interface Obligation {
    String employeeObligation();
}

public class BackObligation implements Obligation {

    @Override
    public String employeeObligation() {
        return "BackEnd";
    }
}

public class ObligationFactory {
    public Obligation createObligation(String obligation)
    {
        if (obligation == null || obligation.isEmpty())
            return null;
        return switch (obligation) {
            case "B" -> new BackObligation();
            case "D" -> new DesignObligation();
            case "F" -> new FrontObligation();
            default -> throw new IllegalArgumentException("Unknown obligation " + obligation);
        };
    }
}
```

Finally, I just show how they work in the Main class:

```java
 public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        CompanyDepartment department = CompanyDepartment.getCompanyDepartment();
        department.setName("Engine");
        CompanyDepartment department1 = CompanyDepartment.getCompanyDepartment();
        System.out.println("Department name is " + department1.getName());
        Employee emp1 = new Employee.EmployeeBuilder()
                .setObligations(new ArrayList<>())
                .setSalary(1200)
                .setDepartment(department)
                .setFullName("Vasea")
                .build();

        ObligationFactory obligationFactory = new ObligationFactory();
        Obligation back = obligationFactory.createObligation("B");
        Obligation front = obligationFactory.createObligation("F");
        Obligation design = obligationFactory.createObligation("D");
        emp1.saveObligation(back);
        emp1.saveObligation(front);

        Employee emp2 = (Employee) emp1.clone();
        Employee emp3 = (Employee) emp1.clone();
        emp3.saveObligation(design);
        Employee emp4 = (Employee) emp1.clone();
        emp4.deleteObligation(back);

        System.out.println(emp2.getObligations());
        System.out.println(emp3.getObligations());
        System.out.println(emp4.getObligations());
    }
}
```
## Conclusion
To sum up, I have created a simple code that implement the 4 design patterns that I choosed.
In my code I managed to implement somehow 4 creational design patterns. Moreover, I managed not only to copy and use them,
but also to connect 2 patterns in one class. That's why I think I have understand the creational design patterns main purpose.

----
# Topic: *Structural Design Patterns*
## Objectives:
&ensp; &ensp; __1. Study and understand the Structural Design Patterns.__

&ensp; &ensp; __2. As a continuation of the previous laboratory work, think about the functionalities that your system will need to provide to the user.__

&ensp; &ensp; __3. Implement some additional functionalities, or create a new project using structural design patterns.__

## Theoretical background:
&ensp; &ensp; Structural design patterns are a category of design patterns that focus on the composition of classes and objects to form larger structures and systems. They provide a way to organize objects and classes in a way that is both flexible and efficient, while allowing for the reuse and modification of existing code. Structural design patterns address common problems encountered in the composition of classes and objects, such as how to create new objects that inherit functionality from existing objects, how to create objects that share functionality without duplicating code, or how to define relationships between objects in a flexible and extensible way.

&ensp; &ensp; Some examples of from this category of design patterns are:

* Adapter
* Bridge
* Composite
* Decorator
* Facade
* Flyweight
* Proxy

## Implementation

* Introduction

I decided to implement Adapter, Bridge, Composite and Decorator design patterns.
I created a java program where there is are Cars and Tractors and they have stickers and accessories, then we adapt car to tractor.

* Snippets from your files.

* Adapter:

```java
public class CarAdapter implements TractorFunctionality {
    Car car;
    public CarAdapter(Car car) {
        this.car = car;
    }

    public void workOnField()
    {
        car.drive();
    }

    @Override
    public int displayFinalPrice() {
        return car.finalPrice();
    }
}
```

* Bridge:

```java
public abstract class TractorAccessoryBridge {
    protected TractorAccessory tractorAccessory;

    public TractorAccessoryBridge(TractorAccessory tractorAccessory){
        this.tractorAccessory = tractorAccessory;
    }

    abstract public int additionPrice();
}
```

* Composite:

```java
public class StickerInstaller implements CarSticker {
    private int price;

    public StickerInstaller(int price) {
        this.price = price;
    }

    private List<CarSticker> carStickers = new ArrayList<>();

    @Override
    public void install(String fillColor) {
        for(CarSticker sh : carStickers)
        {
            sh.install(fillColor);
        }
    }

    public void add(CarSticker s){
        this.carStickers.add(s);
    }

    //removing shape from drawing
    public void remove(CarSticker s){
        carStickers.remove(s);
    }

    public int getPrice() {
        return price * carStickers.size();
    }

    public void setPrice(int price) {
        this.price = price;
    }

    //removing all the shapes
    public void clear(){
        System.out.println("Uninstalling all stickers from car");
        this.carStickers.clear();
    }
}
```

* Decorator:

```java
public class CarDecorator implements Car {
    protected Car car;

    public CarDecorator(Car c) {
        this.car = c;
    }

    @Override
    public void drive() {
        System.out.println("Drive on road");
    }

    @Override
    public int finalPrice() {
        return this.car.finalPrice();
    }

}
```

Finally, I just show how they work in the Main class:

```java
 public class Main {
    public static void main(String[] args) {
        //Bridge
        TractorAccessoryBridge sweeper = new Sweeper(new TitanTractorAccessory(), 100);
        sweeper.additionPrice();

        TractorAccessoryBridge aerator = new Aerator(new SteelTractorAccessory(), 200);
        aerator.additionPrice();

        //Composite
        CarSticker square1 = new GirlSticker();
        CarSticker square2 = new GirlSticker();
        CarSticker cir = new MonsterSticker();

        StickerInstaller stickerInstaller = new StickerInstaller(100);
        stickerInstaller.add(square2);
        stickerInstaller.add(square2);
        stickerInstaller.add(cir);

        stickerInstaller.install("Red");

        stickerInstaller.clear();

        stickerInstaller.add(square1);
        stickerInstaller.add(cir);
        stickerInstaller.install("Green");


//        Decorator
        Car sportsCar = new SportsCar(new BasicCar("Scoda", 10000, stickerInstaller), 1000);
        System.out.println(sportsCar.finalPrice());

        Car sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar("Mercedes", 40000, stickerInstaller), 10000), 10000);
        System.out.println(sportsLuxuryCar.finalPrice());


//        Adapter
        TractorFunctionality tractorFunctionality = new Tractor(aerator, 1200000);
        TractorFunctionality carAdapter = new CarAdapter(sportsCar);
        System.out.println(tractorFunctionality.displayFinalPrice());
        carAdapter.workOnField();
    }
}
```
## Conclusion
To sum up, I have created a simple code that implement the 4 design patterns that I have chosen.
In my code I managed to implement somehow 4 structural design patterns. Moreover, I managed not only to copy and use them,
but also to interconnect them. That's why I think I have understood the structural design patterns main purpose.
