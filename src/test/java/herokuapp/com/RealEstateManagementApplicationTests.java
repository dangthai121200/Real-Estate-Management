package herokuapp.com;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Configuration
class RealEstateManagementApplicationTests {
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Test
	void contextLoads() {
		
		System.out.println(passwordEncoder.encode("thai"));
	}

}
