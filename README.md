# Store-Service

Used :  Spring Boot REST API, Cassandra DB

Features -
01: Using saveProducts one adds all the products to the store.

02: Using addProduct one can add products, if the product is already there in store it will just add the mentioned quantity, and if it’s not that new product will be added to the store of the mentioned quantity. 

03: Using checkingAvailabilityOfProducts one can check if the desired quantity of the desired product(s) is available at the store or not.
It shows –
- whether the product is there in the store or not,
- if it’s there is the desired quantity is there or not,
- if the desired quantity is not there for by much quantity the store is short of that item from the desired quantity.
