package com.karthitox.oneforum.controller;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.karthitox.oneforum.helper.AppHelper;
import com.karthitox.oneforum.repository.UserRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired 
	UserRepository userRepository;
	
	@BeforeAll
	static void beforeAll(@Autowired AppHelper appHelper) {
		appHelper.clearWholeDB();
	}

	@AfterAll
	static void afterAll(@Autowired AppHelper appHelper) {
		appHelper.clearWholeDB();
	}
	

	@Test
	public void user_should_able_to_register_and_login() throws Exception {

		mockMvc.perform(
				
				post("/api/auth/register")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{ \"email\": \"test@test.com\", \"password\": \"test\" }")
				
				).andExpect(status().isOk())
				.andExpect(jsonPath("$.token").exists())
				.andExpect(jsonPath("$.user.uid").exists())
				.andExpect(jsonPath("$.user.name").exists())
				.andExpect(jsonPath("$.user.email").value("test@test.com"));
		
		assertThat(userRepository.findByEmail("test@test.com").get().getEmail())
				.isEqualTo("test@test.com");
		
		mockMvc.perform(post("/api/auth/login").contentType(MediaType.APPLICATION_JSON)
				.content("{ \"email\": \"test@test.com\", \"password\": \"test\" }")).andExpect(status().isOk())
				.andExpect(jsonPath("$.token").exists())
				.andExpect(jsonPath("$.token").isNotEmpty())
				.andExpect(jsonPath("$.user.uid").exists())
				.andExpect(jsonPath("$.user.name").exists())
				.andExpect(jsonPath("$.user.email").value("test@test.com"));

	}

}

//@RunWith(MockitoJUnitRunner.class)
//public class DepartmentControllerTest {
//
// 
//
//    @InjectMocks
//DepartmentController controller;
//
//    @Mock
//    DepartmentServiceImpl service;
//
//
//    @Test
//    public void testgetDepartments(){
//        Department dept1=Department.builder().departmentId(1L)
//                .departmentAddress("Mumbai").
//                departmentCode("P001")
//                .departmentName("Production").build();
//
//        Department dept2=Department.builder().departmentId(2L)
//                .departmentAddress("Mumbai").
//                departmentCode("P001")
//                .departmentName("Production").build();
//
//        List<Department> expectedDepartments=new ArrayList<Department>();
//        expectedDepartments.add(dept1);
//        expectedDepartments.add(dept2);
//
//        when(service.getDepartments()).thenReturn(expectedDepartments);
//
//        List<Department> actual=controller.getDepartments();
//
//        assertThat(actual).isEqualTo(expectedDepartments);
//    }
//}
