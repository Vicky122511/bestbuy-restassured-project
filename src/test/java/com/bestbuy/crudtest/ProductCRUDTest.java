package com.bestbuy.crudtest;

import com.bestbuy.model.ProductPojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class ProductCRUDTest extends TestBase {
    Response response;

    @Test
    public void getAllProductInfo()
    {
        response = given()
                .when()
                .get("/products");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getSingleProductInfo()
    {
        response =  given()
                .pathParam("id",127687)
                .when()
                .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();


    }

    @Test
    public void searchProductWithParameter()
    {
        HashMap<String,Object> qParam = new HashMap();
        qParam.put("type","HardGood");
        //qParam.put("limit",2);
        response = given()
                .queryParams(qParam)
                .when()
                .get("/products");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
    public void createProduct()
    {
        ProductPojo productPojo = new ProductPojo();
    }

    @Test
    public void updateAnyProduct()
    {

    }
}
