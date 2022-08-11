# springboot-kafka-microservices-playground
Sample project to learn microservices and playground


<h1>Available Microservices</h1>

Click on the microservice link to go to Spring Initialzr

| Microservice                                                                                                                                                                                                                                                                                                                                      | Description                              | Tomcat Port           |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------|-----------------------|
| [order-service](https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.7.2&packaging=jar&jvmVersion=11&groupId=net.dzakirinmd&artifactId=order-service&name=order-service&description=Demo%20Microservice%20project%20for%20Spring%20Boot%20Order%20Service&packageName=net.dzakirinmd.orderservice&dependencies=web,kafka) | Order Producer Service to produce order  | http://localhost:8086 |
| [stock-service](https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.7.2&packaging=jar&jvmVersion=11&groupId=net.dzakirinmd&artifactId=stock-service&name=stock-service&description=Demo%20Microservice%20project%20for%20Spring%20Boot%20Stock%20Service&packageName=net.dzakirinmd.stockservice&dependencies=web,kafka) | Stock Consumer Service to consumer order | http://localhost:8087 |
| [email-service](https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.7.2&packaging=jar&jvmVersion=11&groupId=net.dzakirinmd&artifactId=email-service&name=email-service&description=Demo%20Microservice%20project%20for%20Spring%20Boot%20Stock%20Service&packageName=net.dzakirinmd.emailservice&dependencies=web,kafka) | Email Consumer Service to consume order  | http://localhost:8088 |
| [base-domain](https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.7.2&packaging=jar&jvmVersion=11&groupId=net.dzakirinmd&artifactId=base-domains&name=base-domains&description=Demo%20Microservice%20project%20for%20Spring%20Boot%20Base%20Domains&packageName=net.dzakirinmd.basedomains&dependencies=lombok)          | To keep all domain entity                | N/A                   |

<h1>Project Dependency</h1>

| Project Dependency | Version                                            |
|--------------------|----------------------------------------------------|
| `Spring Boot`      | 2.7.2                                              |