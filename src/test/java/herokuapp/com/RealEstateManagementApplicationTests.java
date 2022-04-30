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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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
		String body ="{\r\n"
				+ "    \"data\": {\r\n"
				+ "        \"id\": \"Y0b0c3x\",\r\n"
				+ "        \"title\": \"44-Copy\",\r\n"
				+ "        \"url_viewer\": \"https://ibb.co/Y0b0c3x\",\r\n"
				+ "        \"url\": \"https://i.ibb.co/fDQDk2s/44-Copy.jpg\",\r\n"
				+ "        \"display_url\": \"https://i.ibb.co/fDQDk2s/44-Copy.jpg\",\r\n"
				+ "        \"width\": \"280\",\r\n"
				+ "        \"height\": \"180\",\r\n"
				+ "        \"size\": 10016,\r\n"
				+ "        \"time\": \"1651297201\",\r\n"
				+ "        \"expiration\": \"0\",\r\n"
				+ "        \"image\": {\r\n"
				+ "            \"filename\": \"44-Copy.jpg\",\r\n"
				+ "            \"name\": \"44-Copy\",\r\n"
				+ "            \"mime\": \"image/jpeg\",\r\n"
				+ "            \"extension\": \"jpg\",\r\n"
				+ "            \"url\": \"https://i.ibb.co/fDQDk2s/44-Copy.jpg\"\r\n"
				+ "        },\r\n"
				+ "        \"thumb\": {\r\n"
				+ "            \"filename\": \"44-Copy.jpg\",\r\n"
				+ "            \"name\": \"44-Copy\",\r\n"
				+ "            \"mime\": \"image/jpeg\",\r\n"
				+ "            \"extension\": \"jpg\",\r\n"
				+ "            \"url\": \"https://i.ibb.co/Y0b0c3x/44-Copy.jpg\"\r\n"
				+ "        },\r\n"
				+ "        \"delete_url\": \"https://ibb.co/Y0b0c3x/02e777f49309d606e1e907e2f89adcb0\"\r\n"
				+ "    },\r\n"
				+ "    \"success\": true,\r\n"
				+ "    \"status\": 200\r\n"
				+ "}";
		ObjectMapper json = new ObjectMapper();
		try {
			JsonNode jsonNode =  json.readTree(body);
			System.out.println(jsonNode.get("data").get("id"));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		Batdongsan batdongsan = batdongsanRepository.findById(154).get();
//		try {
//			System.out.println(batdongsan.getHopdongchuyennhuongs().size());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
	}

}
