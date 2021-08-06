## Capitole Consulting API

![Java 8](https://img.shields.io/badge/Java-8-orange.svg)
![Build Gradle](https://img.shields.io/badge/Build-Gradle-blue.svg)
![Technology SpringBoot](https://img.shields.io/badge/Technology-SpringBoot-green.svg)
![Test](https://img.shields.io/badge/Test-JUnit5-white.svg)

***
### Running the app locally

- Start de application
  -  `gradlew clean bootRun`
- See the API Documentation in [Swagger UI](http://localhost:8080/swagger-ui/)

An H2 in memory database is running, too.
So, the stored data is:

| BRAND_ID | START_DATE | END_DATE | PRICE_LIST | PRODUCT_ID | PRIORITY  | PRICE | CURR |
| :---: | :---: | --- | --- | --- | --- | --- | --- |
|1|2020-06-14-00.00.00| 2020-12-31-23.59.59 | 1 | 35455 | 0 | 35.50 | EUR |
|1|2020-06-14-15.00.00| 2020-06-14-18.30.00 | 2 | 35455 | 1 | 25.45 | EUR |
|1|2020-06-15-00.00.00| 2020-06-15-11.00.00 | 3 | 35455 | 1 | 30.50 | EUR |
|1|2020-06-15-16.00.00| 2020-12-31-23.59.59 | 4 | 35455 | 1 | 38.95 | EUR |
