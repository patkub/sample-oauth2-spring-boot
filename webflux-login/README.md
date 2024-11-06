# sample-oauth2-spring-boot - WebFlux

## Description

This is a fork of Okta's [Spring Boot Login - MVC](https://github.com/auth0-samples/auth0-spring-boot-login-samples/tree/master/mvc-login), without Okta Spring Boot Starter.

## Requirements

- Java 21

## Configuration

### Auth0 Dashboard
1. On the [Auth0 Dashboard](https://manage.auth0.com/#/clients) create a new Application of type **Regular Web Application**.
1. On the **Settings** tab of your application, add the URL `http://localhost:3001/login/oauth2/code/okta` to the **Allowed Callback URLs** field.
1. On the **Settings** tab of your application, add the URL `http://localhost:3001/` to the **Allowed Logout URLs** field.
1. Save the changes to your application settings. Don't close this page; you'll need some of the settings when configuring the application below.

### Application configuration

Create application.yml by copying example config:

```bash
cp src/main/resources/application.yml.example src/main/resources/application.yml
```

Set the application values in the `src/main/resources/application.yml` file to the values of your Auth0 application.

```yaml
issuer-uri: https://{YOUR-DOMAIN}/
client-id: {YOUR-CLIENT-ID}
client-secret: {YOUR-CLIENT-SECRET}
```

## Running the Spring WebFlux Sample

Open a terminal, go to the project root directory and run the following command:

Linux or MacOS:

```bash
./gradlew bootRun
```

Windows:

```bash
gradlew.bat bootRun 
```

The application will be accessible at http://localhost:3001.

### Running the sample with podman

In order to run the example with [Podman](https://podman.io/docs/installation) you need to have `podman` installed.

You also need to set the client values as explained [previously](#application-configuration).

Execute the command to run Podman for your environment:

Linux or MacOS:

```bash
sh exec.sh
```

Windows:

```bash
.\exec.ps1
```

The application will be accessible at http://localhost:3001.
