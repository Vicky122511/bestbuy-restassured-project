package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StoreExtractionTest
{
static ValidatableResponse response;

    @BeforeClass
    public static void inIt()
    {
        RestAssured.baseURI="http://localhost";
        RestAssured.port=3030;
        response= given()
                .when()
                .get("/stores")
                .then().statusCode(200);
        // response.log().all(); display all details

    }

    //1. Extract the limit
    @Test
    public void test1()
    {
        int limit = response.extract().path("limit");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : "+limit );
        System.out.println("------------------End of Test---------------------------");
    }

    //2. Extract the total
    @Test
    public void test2()
    {
        int total = response.extract().path("total");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : "+total );
        System.out.println("------------------End of Test---------------------------");
    }

    //3. Extract the name of 5th store
    @Test
    public void test3()
    {
        String name= response.extract().path("data[4].name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of 5th Store : "+name );
        System.out.println("------------------End of Test---------------------------");
    }

    //4. Extract the names of all the store
    @Test
    public void test4()
    {
        List<String> name = response.extract().path("data.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of all Store : "+name );
        System.out.println("------------------End of Test---------------------------");

    }

    //5. Extract the storeId of all the store
    @Test
    public void test5()
    {
        List<Integer> id = response.extract().path("data.id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of all StoreId : "+id );
        System.out.println("------------------End of Test---------------------------");

    }

    //6. Print the size of the data list
    @Test
    public void test6()
    {
        List<Integer> id = response.extract().path("data.id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The size of Data List : "+id.size() );
        System.out.println("------------------End of Test---------------------------");

    }

    //7. Get all the value of the store where store name = St Cloud
    @Test
    public void test7()
    {
        List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.name == 'St Cloud'}");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Get All the value of Store : "+values );
        System.out.println("------------------End of Test---------------------------");

    }

    //8. Get the address of the store where store name = Rochester
    @Test
    public void test8()
    {
        List<String> address = response.extract().path("data.findAll{it.name == 'Rochester'}.address");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The Address of particular store : "+address);
        System.out.println("------------------End of Test---------------------------");
    }

    //9. Get all the services of 8th store
    @Test
    public void test9()
    {
        List<HashMap<String,?>> services = response.extract().path("data.findAll{it.name=='Fargo'}.services");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Get the All Services of Store 8 : "+services);
        System.out.println("------------------End of Test---------------------------");
    }

    //10. Get storeservices of the store where service name = Windows Store
    @Test
    public void test10()
    {

        List<HashMap<String,?>> storeServicesWindowsStore = response.extract().path("data.services*.findAll{it.name == 'Windows Store'}.storeservices");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Get the All Services of Store 8 : "+storeServicesWindowsStore);
        System.out.println("------------------End of Test---------------------------");
    }

    //11. Get all the storeId of all the store
    @Test
    public void test11()
    {
        List<Integer> storeId = response.extract().path("data*.services*.storeservices*.storeId");


        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Get the All StoreID of all store : "+storeId);
        System.out.println("------------------End of Test---------------------------");
    }

    //12. Get id of all the store
    @Test
    public void test12()
    {
        List<Integer> id = response.extract().path("data.id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Get the All id : "+id);
        System.out.println("------------------End of Test---------------------------");
    }

    //13. Find the store names Where state = ND
    @Test
    public void test13()
    {
        List<String> name = response.extract().path("data.findAll{it.state=='ND'}.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Store Names where State is ND : "+name);
        System.out.println("------------------End of Test---------------------------");
    }

    //14. Find the Total number of services for the store where store name = Rochester
    @Test
    public void test14()
    {
        List<Integer> total = response.extract().path("data.findAll{it.name=='Rochester'}.services");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total Number of Services for particular Store : "+total.size());
        System.out.println("------------------End of Test---------------------------");
    }

    //15. Find the createdAt for all services whose name = “Windows Store”
    @Test
    public void test15()
    {
        List<String> value = response.extract().path("data.services*.findAll{it.name == 'Windows Store'}.createdAt");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All services whose name = “Windows Store” : "+value);
        System.out.println("------------------End of Test---------------------------");

    }

    //16. Find the name of all services Where store name = “Fargo”
    @Test
    public void test16()
    {
        List<String> name = response.extract().path("data.findAll{it.name=='Fargo'}.services");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All services whose name = “Fargo” : "+name);
        System.out.println("------------------End of Test---------------------------");
    }

    //17. Find the zip of all the store
    @Test
    public void test17()
    {
        List<Integer> zip = response.extract().path("data.zip");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Zip for All Store : "+zip);
        System.out.println("------------------End of Test---------------------------");
    }

    //18. Find the zip of store name = Roseville
    @Test
    public void test18()
    {
        List<Integer> zip = response.extract().path("data.findAll{it.name=='Roseville'}.zip");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Zip for Roseville Store : "+zip);
        System.out.println("------------------End of Test---------------------------");
    }

    //19. Find the storeservices details of the service name = Magnolia Home Theater
    @Test
    public void test19()
    {
        List<String> value = response.extract().path("data.services*.findAll{it.name == 'Magnolia Home Theater'}.storeservices");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Store Services Details: "+value);
        System.out.println("------------------End of Test---------------------------");
    }

    //20. Find the lat of all the stores
    @Test
    public void test20()
    {
        List<Integer> lat = response.extract().path("data.lat");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Find the lat of all store: "+lat);
        System.out.println("------------------End of Test---------------------------");
    }

}
