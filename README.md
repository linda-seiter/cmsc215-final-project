# CMSC 215 Final Project – Meal System (Incremental Build)

You will build a meal management system in **6 versions**. Each version adds new features. Every version must compile and run before moving on.

---

# Core Design Requirements (All Versions)

## Common Fields

All meals must include:

* `name` (String)
* `calories` (int)

---

## Superclass Requirement

Create an abstract superclass:

### Meal

* Fields must be **private**
* Must include public getters and setters:

    * `getName()`, `setName(String name)`
    * `getCalories()`, `setCalories(int calories)`
* Constructor initializes all fields
* Must declare:

```java
public abstract double getPrice();
```

* Must implement:

    * `toString()` that prints:

        * name
        * calories
        * price (via `getPrice()`)

---

## Subclass Rules (Very Important)

All subclasses must:

### 1. Override `getPrice()`

* Must calculate price from fields
* Must NOT store price in a variable

### 2. Override `toString()`

* Must call:

```java
super.toString()
```

* Then append subclass-specific information

### Required behavior:

* `toString()` = superclass output + extra fields

---

# Pricing Rules

## KidsMeal

* Base price: **6.00**
* If `toy == true`: **7.50**

## DeluxeMeal

* Base price: **15.00**
* If `name` contains "lobster" (case-insensitive): **+10.00**
* If `dessert` contains "cake" (case-insensitive): **+5.00**

---

# Version 1: KidsMeal (Single Class + Console Input)

## Goal

Build a simple program using one class.

## Requirements

Create class `KidsMeal`:

* Fields:

    * `name`
    * `calories`
    * `toy` (boolean)

## Methods

* `getPrice()`:

    * return 7.50 if toy is true
    * otherwise return 6.00

* `toString()`:

    * display name, calories, toy, and price

## Main Program

* Use `Scanner`
* Prompt user for:

    * name
    * calories
    * toy (true/false)
* Create object
* Print result

---

# Version 2: Add DeluxeMeal

## Goal

Introduce a second meal type.

## Requirements

Create class `DeluxeMeal`:

* Fields:

    * `name`
    * `calories`
    * `dessert` (String)

## Methods

* `getPrice()`:

    * start at 15.00
    * +10 if name contains “lobster”
    * +5 if dessert contains “cake”

* `toString()`:

    * include all fields + price

## Main Program Update

* Ask user:

    * KidsMeal or DeluxeMeal
* Prompt for appropriate input
* Create and print object

---

# Version 3: Add Inheritance (Meal Superclass)

## Goal

Refactor using inheritance and encapsulation.

## Requirements

### Create abstract class `Meal`

* Private fields:

    * `name`
    * `calories`

* Public getters and setters

* Constructor initializes fields

* Abstract method:

```java
public abstract double getPrice();
```

* `toString()`:

    * includes:

        * name
        * calories
        * price (via `getPrice()`)

---

## Update Subclasses

### KidsMeal extends Meal

* Add field:

    * `toy` (boolean)

### DeluxeMeal extends Meal

* Add field:

    * `dessert` (String)

---

## Override Rules (STRICT)

### In BOTH subclasses:

#### getPrice()

* Must compute price using rules
* Must NOT store price in a variable

#### toString()

Must follow this structure:

```java
super.toString() + additional fields
```

Examples:

* KidsMeal adds toy info
* DeluxeMeal adds dessert info

---

# Version 4: Store Meals in a List

## Goal

Use polymorphism and collections.

## Requirements

* Create:

```java
ArrayList<Meal>
```

* Loop:

    * Ask user to create meals repeatedly
    * Add each to list
    * Stop when user chooses

* After loop:

    * Print all meals

---

# Version 5: File Input

## Goal

Read meals from a file and build objects.

---

## File Format

```
K,Happy Meal,600,true
D,Steak Dinner,2200,Chocolate Cake
K,Mini Burger,450,false
D,Lobster Feast,1800,Apple Pie
D,Hamburger Dinner,1500,Oatmeal cookie
K,Bad Calories,-200,true
X,Unknown Meal,800,true
```

---

## Field Meaning

###
