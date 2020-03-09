# SonarDemo

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 9.0.5.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `--prod` flag for a production build.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running Sonar coverage

Run `npm run sonar` to check the sonar coverage http://3.221.52.178:8080/projects.

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md).

## Step to add sonarqube scanner into project
1. npm install tslint-sonarts --save-dev.
2. npm install sonar-scanner --save-dev.
3. create file sonar-project.properties at the root levl and have the following properties.
sonar.host.url=http://3.221.52.178:8080/
sonar.login=cb13f6bee71b56a3d930736254088c026d74d66a
sonar.password=
sonar.projectKey=sonar-demo
sonar.projectName=sonar-demo
sonar.projectVersion=1.0
sonar.sourceEncoding=UTF-8
sonar.sources=src
sonar.exclusions=**/node_modules/**
sonar.tests=src
sonar.test.inclusions=**/*.spec.ts
sonar.typescript.lcov.reportPaths=coverage/lcov.info
