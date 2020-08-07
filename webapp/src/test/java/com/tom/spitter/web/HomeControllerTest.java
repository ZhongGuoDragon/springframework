package com.tom.spitter.web;

import com.tom.spitter.Spittle;
import com.tom.spitter.data.SpittleRepository;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class HomeControllerTest {
    @Test
    public void testHomePage() throws Exception {
        HomeController controller = new HomeController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.view().name("index"));
    }

//    @Test
//    public void shouldShowRecentSpittles() throws Exception{
//        List<Spittle> expectedSpittles = createSpittleList(20);
//        SpittleRepository mockRepository=
//
//    }

    private List<Spittle> createSpittleList(int count) {
        List<Spittle> spittles=new ArrayList<Spittle>() ;
        for (int i = 0; i < count; i++) {
//            spittles.add(new Spittle((long)count,"spittle"+i,new Date()));
        }
        return spittles;
    }
}
