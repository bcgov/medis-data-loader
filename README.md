# medis-data-loader
Spring Batch app for loading MEDIS data

## Overview

## Development
### Build
mvn clean package

### Run
mvn spring-boot:run


## Running the data loader

### Dev
`java -jar medis-data-loader-1.0.0.jar --spring.profiles.active=dev`

### Test
`java -jar medis-data-loader-1.0.0.jar --spring.profiles.active=test`

### Prod
`java -jar medis-data-loader-1.0.0.jar --spring.profiles.active=prod`

### Properties
<pre>
spring:
   datasource:
      url: 
      username: 
      password: 
      
   h2:
      datasource:
         driverClassName: org.h2.Driver
         username: medis
         password: medis

batch:
   cron: 0 0 * * * *
   
mail:
   enabled: false
   
sftp:
   hostname: 
   key: 
      username:  
      file: 
   directory: 
   flag-file: 
   
pgp:
   key:
      file: 
</pre>