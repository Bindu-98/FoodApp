# FoodApp
 Food Application for Interview

## Summary
The API have 3 Endpoints

1. To get the List of the restaurants.
GET: http://localhost:8080/api/v1/RestaurantList

2. To Get the Item List of a Selected Restaurant
GET: http://localhost:8080/api/v1/Restaurant/{Restaurant_ID}
EX: http://localhost:8080/api/v1/Restaurant/1

3. Select the Item and Customer ID to Place Order
PUT: http://localhost:8080/api/v1/items/{Item_ID}/customer/{Customer_ID}
EX: http://localhost:8080/api/v1/items/1/customer/1

  
## Other Endpoints
#### Assign Items To Restaurants
EX: [PUT] http://localhost:8080/api/v1/items/1/restaurant/1

<br/><br/>
####  Insert a List of Restaurants
 EX: [POST] http://localhost:8080/api/v1/inputListOfRestaurant
 
 SAMPLE BODY :
 
 <sup>
 [
    {
        "address": "Tokyo",
        "name": "Tokyo-Restaurant"
    },
    {
        "address": "Kolkata",
        "name": "Kolkata-Restaurant"
    },
    {
        "address": "Texas",
        "name": "Texas-Restaurant"
    }
]
</sup>


<br/><br/>
#### Insert a List of Items with Restaurants
 EX: [POST] http://localhost:8080/api/v1/inputListOfItemsWithRestaurants
 
 SAMPLE BODY :
 <sup>
[
    {
        "name": "Instert-Item-01",
        "price": 100.5,
        "customersOrders": [],
        "restaurant": {
            "address": "Seoul",
            "name": "Seoul-Restaurant"
        }
    },
    {
        "name": "Instert-Item-02",
        "price": 200.5,
        "customersOrders": [],
        "restaurant": {
            "address": "Melbourne",
            "name": "Melbourne-Restaurant"
        }
    }
]
</sup>




<br/><br/>
#### Get a List of All the Customers
EX: [GET] http://localhost:8080/api/v1/getAllCustomers



<br/><br/>
#### Get a List of All the Items
EX: [GET] http://localhost:8080/api/v1/getAllItems




<br/><br/>
#### Insert a List of Customers
EX: [POST] http://localhost:8080/api/v1/inputListOfCustomers
SAMPLE BODY :

 <sup>
[
    {
        "name": "Babe Ruth",
        "email": "br@example.com",
        "age": 22,
        "dob": "2000-10-18"
    },
    {
        "name": "Nicolas Cage",
        "email": "nc@example.com",
        "age": 23,
        "dob": "1999-11-15"
    },
    {
        "name": "Henry Cavil",
        "email": "HC@example.com",
        "age": 24,
        "dob": "1998-12-19"
    }
]
</sup>




## Note:
1. No need to enterdata to test the Api, Dummy data for Restautant, Customer and Item is already added.
2. The Database Configured in PostgreSQL.

