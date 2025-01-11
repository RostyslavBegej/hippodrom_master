# Hippodrome

## Overview

__Hippodrome__ is a Java-based project designed to simulate and manage virtual horse races. This project aims to provide an engaging and interactive platform where users can observe and track horse races, view statistics, and simulate race outcomes. The main goal is to offer a fun and dynamic way to explore the mechanics of horse racing while demonstrating programming concepts like object-oriented design, threading, and event-driven programming.

## Features

- Horse Management: Create and manage horses with specific names, speeds, and distances.
- Race Simulation: Simulate races where horses move based on their speed and a random factor.
- Winner Determination: Identify the winning horse based on the greatest distance covered.
- Logging: Comprehensive logging of race events and errors.
- Testing: Extensive unit tests to ensure the correctness of the simulation.

## Getting Started

### Prerequisites

Before you begin, ensure you have the following installed:

- Java Development Kit (JDK) 8 or higher
- Apache Maven 3.6.0 or higher

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/RostyslavBegej/hippodrom_master.git
   
2. Navigate to the project directory:

   ```bash
   cd hippodrome

3. Build the project using Maven:

   ```bash
   mvn clean install

### Running the Simulation

After building the project, you can run the simulation using the following command:

  ```bash
  java -jar target/hippodrom_master.jar
  ```


### Project Structure

The project follows a standard Maven structure:

  ```bash
  hippodrom_master/
  ├── src/
  │   ├── main/
  │   │   └── java/
  │   │       └── com/
  │   │           └── example/
  │   │               └── hippodrome/
  │   │                   ├── App.java
  │   │                   ├── Horse.java
  │   │                   └── Race.java
  │   └── test/
  │       └── java/
  │           └── com/
  │               └── example/
  │                   └── hippodrome/
  │                       └── AppTest.java
  ├── pom.xml
  └── README.md
  ```

- **`App.java`**: The main entry point of the application.
- **`Horse.java`**: Class representing a horse with attributes like name, speed, and distance.
- **`Race.java`**: Class responsible for managing the race logic.
- **`AppTest.java`**: Contains unit tests for the application.
- **`pom.xml`**: Maven configuration file.


### Usage

1. __Add Horses:__ Define the horses participating in the race by specifying their names and speeds.
2. __Start Race:__ Initiate the race simulation.
3. __View Results:__ After the simulation completes, view the results to see which horse covered the greatest distance.
