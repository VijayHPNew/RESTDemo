package com.loyaltyone.demo;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.loyaltyone.demo.model.Message;
public class MessageControllerTest extends AbstractTest {
   @Override
   @Before
   public void setUp() {
      super.setUp();
   }
   @Test
   public void getMessages() throws Exception {
      String uri = "/messages";
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals("getMessages() Status is 200", 200, status);
      String content = mvcResult.getResponse().getContentAsString();
      
      assertTrue("Content value returned is "+content, content.equals("Hello World!!!"));
   }
   
   @Test
   public void getMessage() throws Exception {
	   
	  String message = "Hello LoyaltyOne folks";
      String uri = "/messages/"+message;
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals("getMessage(message) Status is 200", 200, status);
      String content = mvcResult.getResponse().getContentAsString();
      
      assertTrue("Content value returned is "+content, content.equals("Hello LoyaltyOne folks"));
   }
   
  
   @Test
   public void createProduct() throws Exception {
      String uri = "/messages";
      Message message = new Message();
      message.setId(11);
      message.setMessage("Message to do unit-testing of POST service");
      message.setObjDate(new Date());
      message.setUserName("ShyamKarna");
      String inputJson = super.mapToJson(message);
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
         .contentType(MediaType.APPLICATION_JSON_VALUE)
         .content(inputJson)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals(201, status);
      //String content = mvcResult.getResponse().getContentAsString();
      //assertEquals(content, "Message is created successfully");
   }
   
   /*
   @Test
   public void updateProduct() throws Exception {
      String uri = "/products/2";
      Product product = new Product();
      product.setName("Lemon");
      String inputJson = super.mapToJson(product);
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
         .contentType(MediaType.APPLICATION_JSON_VALUE)
         .content(inputJson)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
      String content = mvcResult.getResponse().getContentAsString();
      assertEquals(content, "Product is updated successsfully");
   }
   @Test
   public void deleteProduct() throws Exception {
      String uri = "/products/2";
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
      String content = mvcResult.getResponse().getContentAsString();
      assertEquals(content, "Product is deleted successsfully");
   }
   */
}