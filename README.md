# sample-oauth2-spring-boot

## Description

This is a fork of Okta's [Spring Boot Login - MVC](https://github.com/auth0-samples/auth0-spring-boot-login-samples/tree/master/mvc-login), without Okta Spring Boot Starter. 

## Requirements

- Java 17

## Configuration

### Auth0 Dashboard
1. On the [Auth0 Dashboard](https://manage.auth0.com/#/clients) create a new Application of type **Regular Web Application**.
1. On the **Settings** tab of your application, add the URL `http://localhost:3000/login/oauth2/code/okta` to the **Allowed Callback URLs** field.
1. On the **Settings** tab of your application, add the URL `http://localhost:3000/` to the **Allowed Logout URLs** field.
1. Save the changes to your application settings. Don't close this page; you'll need some of the settings when configuring the application below.

### Application configuration

Copy `src/main/resources/application.yml.example` to `src/main/resources/application.yml`:

```bash
cp src/main/resources/application.yml.example src/main/resources/application.yml
```

Set the application values in the `src/main/resources/application.yml` file to the values of your Auth0 application.

```yaml
issuer-uri: https://{YOUR-DOMAIN}/
client-id: {YOUR-CLIENT-ID}
client-secret: {YOUR-CLIENT-SECRET}
```

## Running the sample

Open a terminal, go to the project root directory and run the following command:

Linux or MacOS:

```bash
./gradlew bootRun
```

Windows:

```bash
gradlew.bat bootRun 
```

The application will be accessible at http://localhost:3000.

## Upgrading the sample

Use [OpenRewrite](https://docs.openrewrite.org/) to upgrade to latest Java and SpringBoot.

Define latest recipes in `gradle/openrewrite.gradle`, and run:

```
./gradlew rewriteRun
```
