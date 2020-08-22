# spring-boot-microservices-feign-client
micro services based application using spring boot, fiegn client for internal communication, H2 database 

# API to create order:- 
http://localhost:8080/orders/create

payload :-


{
    "customerName": "shiv",
    "orderDate": "2018-03-29T13:34:00.000",
    "shippingAddress": "xyz",
    "total": 420.10,
    "orderItemsDto": [
        {
            "productCode": "ABC",
            "productName": "abc",
            "quantity": 3
        },
        {
            "productCode": "kkk",
            "productName": "KKK",
            "quantity": 5
        }
    ]
}


# API to get order details:- 

http://localhost:8080/orders/get/1
