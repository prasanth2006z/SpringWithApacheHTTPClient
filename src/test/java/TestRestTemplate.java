/**
 * Created by prasanth.p on 17/10/17.
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config.xml")
@WebAppConfiguration
public class TestRestTemplate {

    String urlOverHttps = "https://posttestserver.com/";

    @Autowired
    private SampleBean sampleBean;


    @Test
    public void testSampleBeanFunctions(){
        assertThat(sampleBean.read(),is("Bean wired!!!!"));
    }


    @Autowired
    private RestTemplate restTemplate;

//    @Autowired
//    private RestTemplate restTemplate1;

    @Test
    public void whenHttpsURLisConsumed_thenSuccess() {
        ResponseEntity<String> response = restTemplate.exchange(urlOverHttps, HttpMethod.GET, null, String.class);
        assertThat(response.getStatusCode().toString(),is("200"));

//        ResponseEntity<String> response1 = restTemplate1.exchange(urlOverHttps, HttpMethod.GET, null, String.class);
//        assertThat(response1.getStatusCode().toString(),is("200"));
    }
}
