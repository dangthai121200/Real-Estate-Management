package herokuapp.com;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.realestatebk.RealEstateManagementApplication;
import com.herokuapp.realestatebk.entity.Batdongsan;
import com.herokuapp.realestatebk.repository.BatdongsanRepository;
import com.herokuapp.realestatebk.repository.HopdongkyguiRepository;
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
	
	@Autowired
	private BatdongsanRepository batdongsanRepository;
	
	@Autowired
	private HopdongkyguiRepository hopdongkyguiRepository;

	@Test
	@Transactional
	void contextLoads() {
		Batdongsan batdongsan = batdongsanRepository.findById(154).get();
		try {
			System.out.println(batdongsan.getHopdongchuyennhuongs().size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
