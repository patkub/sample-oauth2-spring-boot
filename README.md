# sample-oauth2-spring-boot

## Description

This is a fork of Okta's [Spring Boot Login Samples](https://github.com/auth0-samples/auth0-spring-boot-login-samples), without Okta Spring Boot Starter. 

## Requirements

- Java 21

## Configuration

### Auth0 Dashboard
1. On the [Auth0 Dashboard](https://manage.auth0.com/#/clients) create a new Application of type **Regular Web Application**.
1. On the **Settings** tab of your application, add the following URLs to the **Allowed Callback URLs** field.
   - `http://localhost:3000/login/oauth2/code/okta, http://localhost:3001/login/oauth2/code/okta`
1. On the **Settings** tab of your application, add the following URLs to the **Allowed Logout URLs** field.
   - `http://localhost:3000, http://localhost:3001`
1. Save the changes to your application settings. Don't close this page; you'll need some of the settings when configuring the application below.

### Application configuration

Create application.yml by copying example config:

```bash
cp mvc-login/src/main/resources/application.yml.example mvc-login/src/main/resources/application.yml
cp webflux-login/src/main/resources/application.yml.example webflux-login/src/main/resources/application.yml
```

Set the application values in the `src/main/resources/application.yml` file to the values of your Auth0 application.

```yaml
issuer-uri: https://{YOUR-DOMAIN}/
client-id: {YOUR-CLIENT-ID}
client-secret: {YOUR-CLIENT-SECRET}
```

## Running the MVC sample

Open a terminal, go to the project root directory and run the following command:

Linux or MacOS:

```bash
./gradlew :mvc-login:bootRun
```

Windows:

```bash
gradlew.bat :mvc-login:bootRun 
```

The application will be accessible at http://localhost:3000.

## Running the WebFlux sample

Open a terminal, go to the project root directory and run the following command:

Linux or MacOS:

```bash
./gradlew :webflux-login:bootRun
```

Windows:

```bash
gradlew.bat :webflux-login:bootRun 
```

The application will be accessible at http://localhost:3001.

## Upgrading the sample

Use [OpenRewrite](https://docs.openrewrite.org/) to upgrade to latest Java and SpringBoot.

Define latest recipes in `gradle/openrewrite.gradle`, and run:

```
./gradlew rewriteRun
```
