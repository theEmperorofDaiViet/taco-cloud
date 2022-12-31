<a name="readme-top"></a>
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
    <li><a href="#key-features">Key Features</li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>

<p align="center">
    <img src="https://github.com/theEmperorofDaiViet/taco-cloud/blob/master/src/main/resources/static/images/TacoCloud.png">
</p>

# About The Project
The Taco Cloud project from the famous book - "Spring in Action".

## Built With
* [![Java][Java-shield]][Java-url]
* [![Spring][Spring-shield]][Spring-url]
* [![Apache Maven][Apache Maven-shield]][Apache Maven-url]
* [![Apache Tomcat][Apache Tomcat-shield]][Apache Tomcat-url]
* [![HTML5][HTML5-shield]][HTML5-url]
* [![CSS3][CSS3-shield]][CSS3-url]
* [![Thymeleaf][Thymeleaf-shield]][Thymeleaf-url]
* [![Microsoft SQL Server][MicrosoftSQLServer-shield]][MicrosoftSQLServer-url]

<p align="right">(<a href="#readme-top">back to top</a>)</p>

# Getting Started

## Prerequisites
Before cloning and using this application, you'll need to install these things on your computer:
* [Java SE Development Kit 17](https://www.oracle.com/java/technologies/downloads/#java17): Of course you need to have Java installed to run a Java application. I used Java 17, but I think it works fine with the widely-used Java 8 (JDK 1.8), as well.
* [Spring Tool Suite 4](https://spring.io/tools): an Eclipse-based IDE to develop Spring applications. 
It provides a ready-to-use environment to implement, run, deploy, and debug the application. 
It validates your application and provides quick fixes for the applications.
* [Microsoft SQL Server 2019](https://www.microsoft.com/en-us/sql-server/sql-server-2019): a relational database management system developed by Microsoft.
As a database server, it is a software product with the primary function of storing and retrieving data as requested by other software applications - 
which may run either on the same computer or on another computer across a network (including the Internet).

## Installation
You can install this application by cloning this repository into your current working directory:
```sh
git clone https://github.com/theEmperorofDaiViet/taco-cloud.git
```
After cloning the repository, you can open the project by Spring Tool Suite.

Open the application.properties file in [/src/main/resources](/src/main/resources) to change the information about the datasource to fit your own settings.

Open SQL Server and create a database according to the script in SQLServer.sql file in [/src/main/resources](/src/main/resources).

Finally, back to Spring Tool Suite and run the application.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

# Key Features
<i>This project covers the features from chapter 1 to 5 of "Spring in Action":</i>

- <b>Traditional multipage application (MPA) with Spring MVC</b>
    - Design custom tacos by selecting ingredients
    - Place an order for the tacos you designed
    - Validate form input and display validation errors
    - See your order history


+ <b>Spring Data</b>: store information about ingredients, tacos, orders in Microsoft SQL Server database with:
    + JDBC (in previous version)
    + JPA

- <b>Spring Security</b>:
    - Custom user storage:
        - In-memory user store (in previous version)
        - JDBC-based user store (in previous version)
        - LDAP-backed user store (in previous version)
        - Custom user details service
    - Log in/ Log out
    - Register new account
    - Secure against CSRF attacks

<p align="right">(<a href="#readme-top">back to top</a>)</p>

# Usage
<i>Here is an example to illustrate the features of this application</i>

<p align="center">
    <img src="/src/main/resources/static/images/Usage.gif">
</p>

* First, I log in to an existing account. I design two tacos and place an order for them.
While entering information, I intend to provide data in the wrong format to illustrate data validation.
Finally, I check order history to see my previous orders, including the order I've just placed.

* Second, I log out and create a new account. I log in that new account and do the same things as above.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

# Contact

You can contact me via:
* [![GitHub][GitHub-shield]][GitHub-url]
* [![LinkedIn][LinkedIn-shield]][LinkedIn-url]
* ![Gmail][Gmail-shield]:&nbsp;<i>Khiet.To.05012001@gmail.com</i>
* [![Facebook][Facebook-shield]][Facebook-url]
* [![Twitter][Twitter-shield]][Twitter-url]

<br/>
<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- MARKDOWN LINKS & IMAGES -->
<!-- Tech stack -->
[Java-shield]: https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white
[Java-url]: https://www.java.com/
[Spring-shield]: https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white
[Spring-url]: https://spring.io/
[Apache Maven-shield]: https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white
[Apache Maven-url]: https://maven.apache.org/
[Apache Tomcat-shield]: https://img.shields.io/badge/apache%20tomcat-%23F8DC75.svg?style=for-the-badge&logo=apache-tomcat&logoColor=black
[Apache Tomcat-url]: https://tomcat.apache.org/
[HTML5-shield]: https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white
[HTML5-url]: https://www.w3.org/html/
[CSS3-shield]: https://img.shields.io/badge/css3-%231572B6.svg?style=for-the-badge&logo=css3&logoColor=white
[CSS3-url]: https://www.w3.org/Style/CSS/
[Thymeleaf-shield]: https://img.shields.io/badge/Thymeleaf-%23005C0F.svg?style=for-the-badge&logo=Thymeleaf&logoColor=white
[Thymeleaf-url]: https://www.thymeleaf.org/
[MicrosoftSQLServer-shield]: https://img.shields.io/badge/Microsoft%20SQL%20Sever-CC2927?style=for-the-badge&logo=microsoft%20sql%20server&logoColor=white
[MicrosoftSQLServer-url]: https://www.microsoft.com/en-us/sql-server

<!-- Contact -->
[GitHub-shield]: https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white
[GitHub-url]: https://github.com/theEmperorofDaiViet
[LinkedIn-shield]: https://img.shields.io/badge/linkedin-%230077B5.svg?style=for-the-badge&logo=linkedin&logoColor=white
[LinkedIn-url]: https://www.linkedin.com/in/khiet-to/
[Gmail-shield]: https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white
[Facebook-shield]: https://img.shields.io/badge/Facebook-%231877F2.svg?style=for-the-badge&logo=Facebook&logoColor=white
[Facebook-url]: https://www.facebook.com/Khiet.To.Official/
[Twitter-shield]: https://img.shields.io/badge/Twitter-%231DA1F2.svg?style=for-the-badge&logo=Twitter&logoColor=white
[Twitter-url]: https://twitter.com/KhietTo