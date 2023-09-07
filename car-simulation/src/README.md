# Solid Principles


## Author: Sarateanu Andrei-Cristian

----

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

## Conclusions / Screenshots / Results
To sum up, I have created a simulation of passing months ans the statistics of cars mood and the income of station and it's departments.
In my code I managed to implement somehow all SOLID principles and I learned all tactics used in the SOLID design principles.
