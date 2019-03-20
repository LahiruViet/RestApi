package com.lahiru.demo.resource;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.lahiru.demo.entity.Product;
import com.lahiru.demo.service.ProductService;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductResource.class)
public class ProductResourceTest {

	@Autowired
    private MockMvc mockMvc;
 
    @MockBean
    private ProductService productService;
    

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
    
    @Test
    public void whenFindAll_thenReturn_allProducts() throws Exception {
           
        List<Product> allProducts = Arrays.asList(
        		new Product(1, "car"), 
        		new Product(1, "bus"));
     
        when(productService.findAll()).thenReturn(allProducts);
     
        mockMvc.perform(get("/rest/api/products")
        		.accept(MediaType.APPLICATION_JSON))
		        .andDo(print())
		        .andExpect(status().isOk())
		        .andExpect(jsonPath("$.[0].id").exists())
		        .andExpect(jsonPath("$.[0].id").isNotEmpty())
		        .andExpect(jsonPath("$.[0].id").value(1));
    }
    
    

}
