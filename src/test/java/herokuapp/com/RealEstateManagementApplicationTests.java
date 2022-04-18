package herokuapp.com;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.herokuapp.realestatebk.RealEstateManagementApplication;
import com.herokuapp.realestatebk.repository.NhanvienRepository;
import com.herokuapp.realestatebk.service.NhanvienService;

@SpringBootTest(
		classes = RealEstateManagementApplication.class,
	    webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
//@DataJpaTest
class RealEstateManagementApplicationTests {
	

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private NhanvienRepository nhanvienRepository;
	
	@Autowired
	private NhanvienService nhanvienService;

	@Test
	void contextLoads() {
		System.out.println(nhanvienService.loadUserByUsername("gaonet567"));
	}

}
