FROM --platform=linux/amd64 openjdk:17-alpine

WORKDIR /service

COPY ./product-service.jar ./product-service.jar

RUN /bin/sh -c 'touch /service/product-service.jar'

CMD ["java", "-jar", "product-service.jar"]