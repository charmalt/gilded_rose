[![Build Status](https://travis-ci.org/charmalt/gilded_rose.svg?branch=master)](https://travis-ci.org/charmalt/gilded_rose)

[![codecov](https://codecov.io/gh/charmalt/gilded_rose/branch/master/graph/badge.svg)](https://codecov.io/gh/charmalt/gilded_rose)

[![BCH compliance](https://bettercodehub.com/edge/badge/charmalt/gilded_rose?branch=master)](https://bettercodehub.com/)

## Task

The aim was to read, refactor and extend legacy code. This task is a well known kata developed by Terry Hughes.

### Instructions

Choose legacy code (translated by Emily Bache) in the language of your choice. The aim is to practice good design in the language of your choice. Refactor the code in such a way that adding the new "conjured" functionality is easy.


## Approach 

- Wrote tests for legacy code to obtain 100% Test Coverage.
- Used TDD Approach to add in the new functionality to the legacy code. 
- Refactored code whilst ensuring that the code stilled pass the same tests. 


## Further Improvements
- Quality never exceeds 50 (should throw error if item is initialised with quality greater than 50)
- Quality is never below 0 (should throw error if item is initialised with quality less than 50)

## Pre-requisites
- JDK 1.8
- Maven 
- IDE of your choice 

## Developer Instructions 

- Fork or clone repository. 
- Run TexttestFixture File to for an example output. 

## Tests

Junit and Mockito were used for testing. Run the following command: 

```
mvn clean test
```