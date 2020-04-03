Build the application

##requirements -

Apache Maven 3.0.2 

Java version: 1.8.0_101

##Build App -

mvn clean install -X - in debug mode

##To start the application

To start the application we need to run to services

For the enabling the default eureka server 
`java -jar target/product-catalogue-microservice-1.1.0.RELEASE.jar registration` - after this command wait for the server to up completely

Then running the products service
`java -jar target/product-catalogue-microservice-1.1.0.RELEASE.jar products`- after this command wait for the server to up completely


Or you can Import the project as maven project and start the Registeration and Product Server as SpringBoot Applications and test using POSTMAN/BROWSER
##search product by type

`http://localhost:8083//products/price/{productPrice}`

`http://localhost:8083/products/price/1300`

Response Sample
[
    {
        "id": 3,
        "name": "Pant",
        "type": "Torusers",
        "price": 1300.00,
        "brand": "Arrow",
        "color": "RED",
        "size": "M",
        "sku": "112321",
        "sellerId": "2"
    }
]

##Search price by product name

`http://localhost:8083/products/name/{productName}`

`http://localhost:8083/products/name/Tangy`
Response
[
    {
        "id": 0,
        "name": "Tangy",
        "type": "Shirt",
        "price": 1000.00,
        "brand": "Arrow",
        "color": "RED",
        "size": "L",
        "sku": "123456",
        "sellerId": "1"
    },
    {
        "id": 4,
        "name": "Tangy",
        "type": "T-Shirt",
        "price": 1900.00,
        "brand": "Gucci",
        "color": "RED",
        "size": "S",
        "sku": "321212",
        "sellerId": "3"
    }
]


##Search price by product type
http://localhost:8083/products/type/{productType}
http://localhost:8083/products/type/Shirt
Response:
[
    {
        "id": 0,
        "name": "Tangy",
        "type": "Shirt",
        "price": 1000.00,
        "brand": "Arrow",
        "color": "RED",
        "size": "L",
        "sku": "123456",
        "sellerId": "1"
    },
    {
        "id": 1,
        "name": "Formals",
        "type": "Shirt",
        "price": 1020.00,
        "brand": "PEPE",
        "color": "Black",
        "size": "XL",
        "sku": "453532",
        "sellerId": "1"
    }
]

##Search price by product size
http://localhost:8083/products/size/{productSize}
http://localhost:8083/products/size/XL
Sample Response
[
    {
        "id": 1,
        "name": "Formals",
        "type": "Shirt",
        "price": 1020.00,
        "brand": "PEPE",
        "color": "Black",
        "size": "XL",
        "sku": "453532",
        "sellerId": "1"
    },
    {
        "id": 2,
        "name": "Torn",
        "type": "Jeans",
        "price": 1500.00,
        "brand": "GAP",
        "color": "BLACK",
        "size": "XL",
        "sku": "145323",
        "sellerId": "3"
    }
]
##Search price by product color
http://localhost:8083/products/color/{productColor}
http://localhost:8083/products/color/RED
Response
[
    {
        "id": 0,
        "name": "Tangy",
        "type": "Shirt",
        "price": 1000.00,
        "brand": "Arrow",
        "color": "RED",
        "size": "L",
        "sku": "123456",
        "sellerId": "1"
    },
    {
        "id": 3,
        "name": "Pant",
        "type": "Torusers",
        "price": 1300.00,
        "brand": "Arrow",
        "color": "RED",
        "size": "M",
        "sku": "112321",
        "sellerId": "2"
    },
    {
        "id": 4,
        "name": "Tangy",
        "type": "T-Shirt",
        "price": 1900.00,
        "brand": "Gucci",
        "color": "RED",
        "size": "S",
        "sku": "321212",
        "sellerId": "3"
    }
]
##Search price by product sku
http://localhost:8083/products/sku/{productSku}

http://localhost:8083/products/sku/453532
Response
[
    {
        "id": 1,
        "name": "Formals",
        "type": "Shirt",
        "price": 1020.00,
        "brand": "PEPE",
        "color": "Black",
        "size": "XL",
        "sku": "453532",
        "sellerId": "1"
    }
]
##Create Product


`http://localhost:8083/products/create`

Request Payload
{
"name": "Jogging",
"type": "Shorts",
"price":7500.00,
"brand": "Nike",
"color":"White",
"size":"L",
"sku":"12100001",
"sellerid": "3"
}`

##Product count by Seller

http://localhost:8083/produts/seller/{sellerid}
http://localhost:8083/produts/seller/3
Response:
2


##Delete Product

`http://localhost:8083/products/delete/{productId}`
After
`http://localhost:8083/products/delete/0`
`http://localhost:8083/products/delete/1`
Response
[
    {
        "id": 2,
        "name": "Torn",
        "type": "Jeans",
        "price": 1500.00,
        "brand": "GAP",
        "color": "BLACK",
        "size": "XL",
        "sku": "145323",
        "sellerId": "3"
    },
    {
        "id": 3,
        "name": "Pant",
        "type": "Torusers",
        "price": 1300.00,
        "brand": "Arrow",
        "color": "RED",
        "size": "M",
        "sku": "112321",
        "sellerId": "2"
    },
    {
        "id": 4,
        "name": "Tangy",
        "type": "T-Shirt",
        "price": 1900.00,
        "brand": "Gucci",
        "color": "RED",
        "size": "S",
        "sku": "321212",
        "sellerId": "3"
    }
]

