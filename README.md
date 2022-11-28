<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#improvements">Improvements</a></li>
  </ol>
</details>




<!-- ABOUT THE PROJECT -->
## About The Project

In this project, one will be able to add, update, delete plots by entering all the required information. Also this project allows configuring irrigation timings to those plots. This project exposes following APIs:

* Plots APIs
* Irrigation Timings APIs
* Sensor List API

More ever, projects please follow the project request flow diagram below:

[Product Flow Diagram][flow-diagram]

<p align="right">(<a href="#readme-top">back to top</a>)</p>



### Built With

This section should list any major frameworks/libraries used to bootstrap your project. Leave any add-ons/plugins for the acknowledgements section. Here are a few examples.

* Offcourse Java :smile:
* Spring Boot
* My SQL DB
* Lombok Jar
* Hibernate JPA Model Generation
* Swagger Open API 3.0

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

Read carefully and follow below instructions in order to setup this project locally.

### Prerequisites

Following softwares had to be installed in order to setup this project locally. Please find the respective commands as well to check for installation:
* java
  ```sh
  java -version
  ```
* My SQL
  ```sh
  mysql -v
  ```
* Apache MAVEN
  ```sh
  mvn -v
  ```

### Installation

_Below is an example of how you can instruct your audience on installing and setting up your app. This template doesn't rely on any external dependencies or services._

1. Clone the repo
   ```sh
   git clone https://github.com/chanchal-detani/automatic_irrigation_system.git
   ```
3. Run following command in order to generate binaries:
   ```sh
   mvn clean install
   ```
4. Run Following command in order to start application locally:
   ```sh
   mvn spring-boot:run
   ```
5. You can verify whether the application started successfully or not by vising following url:
   ```sh
   http://localhost:8080/swagger-ui/index.html
   ```
<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ROADMAP -->
## Roadmap

- [x] Add some Sensors
- [x] Add some plots against the sensors
- [ ] Configure some irrigation timings against the plots
- [ ] Update the existing configured timings or add more irrigation timings
- [ ] Get following list of data
    - [ ] Plots
    - [ ] Sensors

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- OTHER DETAILS -->
## Other Details

Kindly requesting you guys to go through the [@Swagger](http://localhost:8080/swagger-ui/index.html) to test the APIs developed and then proceed to code review.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Chanchal Detwani- [@LinkedIn](https://www.linkedin.com/in/chanchal-detwani) - chanchaldetani@gmail.com

Project Link: [https://github.com/chanchal-detani/automatic_irrigation_system](https://github.com/chanchal-detani/automatic_irrigation_system)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- IMPROVEMENTS -->
## Improvements

Due to the time constaints, I am not able to add more functionalities to this Automatic Irrigation System, but yeah I have tried listing those below!

* Enabling Spring Security
* Enabling distributed tracking
* Enabling CDR for request auditing
* Enabling Rate Limiting
* Code Optimations by introducing indexing & other enhancements
* Unit test-cases to increase code coverage

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- MARKDOWN LINKS & IMAGES -->
[flow-diagram]: images/flow-diagram.png