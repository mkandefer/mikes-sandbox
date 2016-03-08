package com.synthapp.embeddedproject.repo;

import com.synthapp.embeddedproject.domain.Store;
import java.util.Optional;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@Transactional
@Rollback(value = true)
@WebAppConfiguration
public class StoreRepositoryTest {
   
    private static final String TEST_STORE = "Pet Store";
    
    @Autowired
    private WebApplicationContext webApplicationContext;
    
    protected MockMvc mockMvc;
    
    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    
    @Autowired
    private StoreRepository storeRepo;
    
    @Test
    public void testConstruction()
    {
        assertNotNull("Web application context is null", webApplicationContext);
        assertNotNull("Store repo is null", storeRepo);
        assertFalse("Database was not populated", storeRepo.findAll().isEmpty());
    }
   
    
    @Test
    public void testFindByName() 
    {
        Optional<Store> store = storeRepo.findFirstByName(TEST_STORE);
        assertTrue(store.isPresent());
        assertEquals(store.get().getName(), TEST_STORE);
    }
    
    
    @Test
    public void restGetStoreProductsEmbeddedWithoutProjection() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/synthapp/api/store"))
                .andExpect(status().isOk()).andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));  
    }
    
    /*
    
    @Test
    public void restGetStoreProductsEmbeddedWithProjection() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/synthapp/api/store?projection=inlineCategories"))
                .andExpect(status().isOk()).andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));  
    }
    
    @Test
    public void restGetProductsOnlyWithProjection() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/synthapp/api/productCategory?projection=inlineChildren"))
                .andExpect(status().isOk()).andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));  
    }
    
    @Test
    public void restGetProductsOnlyWithoutProjection() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/synthapp/api/productCategory"))
                .andExpect(status().isOk()).andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));  
    }
   */
}
