### Rest API

```
/min - given list of numbers and a quantifier (how many) provides min number(s)
/max - given list of numbers and a quantifier (how many) provides max number(s)
/avg - given list of numbers calculates their average
/median - given list of numbers calculates their median
/percentile - given list of numbers and quantifier 'q', compute the qth percentile of the list elements
```

### Input Validation & Exception Handling
- DAO input validation using Spring @NotNull, @Valid annotations
- Input constraint validation in the controller so that empty array and invalid quantifier will throw InputValidationException and then return error 400 to the client

### Unit Tests
- Controller Test for input validation test
- Service Test for logic test
