package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ProductExtractionTest
{

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt()
    {
        RestAssured.baseURI="http://localhost";
        RestAssured.port=3030;
        response= given()
                .when()
                .get("/products")
                .then().statusCode(200);


    }

    //21. Extract the limit
    @Test
    public void test21()
    {
            int limit = response.extract().path("limit");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : "+limit );
        System.out.println("------------------End of Test---------------------------");

    }

    //22. Extract the total
    @Test
    public void test22()
    {
        int total = response.extract().path("total");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : "+total );
        System.out.println("------------------End of Test---------------------------");

    }

    //23. Extract the name of 5th product
    @Test
    public void test23()
    {
        List<HashMap<String,?>> name = response.extract().path("data[4].name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Name of 5th Product : "+name);
        System.out.println("------------------End of Test---------------------------");

    }

    //24. Extract the names of all the products
    @Test
    public void test24()
    {
        List<String> products= response.extract().path("data*.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Name of All Product : "+products);
        System.out.println("------------------End of Test---------------------------");

    }

    //25. Extract the productId of all the products
    @Test
    public void test25()
    {
        List<Integer> id= response.extract().path("data*.id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Name of All Product Id : "+id);
        System.out.println("------------------End of Test---------------------------");

    }

    //26. Print the size of the data list
    @Test
    public void test26()
    {
        List<Integer> size= response.extract().path("data*.id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Size of Data List : "+size.size());
        System.out.println("------------------End of Test---------------------------");

    }
    //27. Get all the value of the product where product name = Energizer - MAX Batteries AA (4-
    //Pack)
    @Test
    public void test27()
    {
        List<HashMap<String,?>> value= response.extract().path("data.findAll{it.name == 'Energizer - MAX Batteries AA (4-Pack)'}");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Value of Product : "+value);
        System.out.println("------------------End of Test---------------------------");

    }

    //28. Get the model of the product where product name = Energizer - N Cell E90 Batteries (2-
    //Pack)
    @Test
    public void test28()
    {
        List<HashMap<String,?>> model= response.extract().path("data.findAll{it.name == 'Energizer - N Cell E90 Batteries (2-Pack)'}.model");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Find Model : "+model);
        System.out.println("------------------End of Test---------------------------");

    }

    //29. Get all the categories of 8th products
    @Test
    public void test29()
    {
        List<HashMap<String,?>> categories = response.extract().path("data[7].categories");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Categories of 8th Product : "+categories);
        System.out.println("------------------End of Test---------------------------");
    }

    //30. Get categories of the store where product id = 150115
    @Test
    public void test30()
    {
        List<HashMap<String,?>> categories = response.extract().path("data.findAll{it.id=='150115'}.categories");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Size of Data List : "+categories);
        System.out.println("------------------End of Test---------------------------");
    }

    //31. Get all the descriptions of all the products
    @Test
    public void test31()
    {
        List<HashMap<String,?>> description = response.extract().path("data*.description");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Description of All Products : "+description);
        System.out.println("------------------End of Test---------------------------");
    }

    //32. Get id of all the all categories of all the products
    @Test
    public void test32()
    {
        List<HashMap<String,?>> id = response.extract().path("data*.categories*.id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Id of all Products from Categories : "+id);
        System.out.println("------------------End of Test---------------------------");
    }

    //33. Find the product names Where type = HardGood
    @Test
    public void test33()
    {
        List<HashMap<String,?>> name = response.extract().path("data.findAll{it.type=='HardGood'}.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Product Name : "+name);
        System.out.println("------------------End of Test---------------------------");
    }

    //34. Find the Total number of categories for the product where product name = Duracell - AA
    //1.5V CopperTop Batteries (4-Pack)
    @Test
    public void test34()
    {
        List<HashMap<String,?>> total = response.extract().path("data.findAll{it.name=='Duracell - AA 1.5V CopperTop Batteries (4-Pack)'}.categories");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total Number of categories : "+total.size());
        System.out.println("------------------End of Test---------------------------");
    }

    //35. Find the createdAt for all products whose price < 5.49
    @Test
    public void test35()
    {
        List<HashMap<String,?>> createdAt = response.extract().path("data.findAll{it.price < 5.49}.createdAt");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Find out Created AT : "+createdAt);
        System.out.println("------------------End of Test---------------------------");
    }

    //36. Find the name of all categories Where product name = “Energizer - MAX Batteries AA (4-
    //Pack)”
    @Test
    public void test36()
    {
        List<HashMap<String,?>> categories = response.extract().path("data.findAll{it.name=='Energizer - MAX Batteries AA (4-Pack)'}.categories");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Name of All Categories : "+categories);
        System.out.println("------------------End of Test---------------------------");
    }

    //37. Find the manufacturer of all the products
    @Test
    public void test37()
    {
        List<HashMap<String,?>> categories = response.extract().path("data*.manufacturer");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Name of All Manufacturer : "+categories);
        System.out.println("------------------End of Test---------------------------");
    }

    //38. Find the imge of products whose manufacturer is = Energizer
    @Test
    public void test38()
    {
        List<HashMap<String,?>> images = response.extract().path("data.findAll{it.manufacturer=='Energizer'}.image");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All Images : "+images);
        System.out.println("------------------End of Test---------------------------");
    }

    //39. Find the createdAt for all categories products whose price > 5.99
    @Test
    public void test39()
    {
        List<HashMap<String,?>> createdAt = response.extract().path("data.findAll{it.price > 5.99}.createdAt");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Find out Created AT : "+createdAt);
        System.out.println("------------------End of Test---------------------------");
    }

    //40. Find the uri of all the product
    @Test
    public void test40()
    {
        List<HashMap<String,?>> url = response.extract().path("data.url");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("URL for all products : "+url);
        System.out.println("------------------End of Test---------------------------");
    }


}
