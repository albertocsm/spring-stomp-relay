# Spring-Stomp-Relay

This is a demo project for testing a dedicated stomp relay

## What does it do?
This project uses spring boot and configures a Web Socket Message broker using a dedicated (1) STOMP broker relay.
Provides a REST endpoint and a simple static page to facilitate interacting with the service.

## Run it

    mvn spring-boot:run

## Use it

Just point your browser to http://localhost:5000

## Some considerations

Take a look at [redis-stomp-relay](https://github.com/albertocsm/redis-stomp-relay)
