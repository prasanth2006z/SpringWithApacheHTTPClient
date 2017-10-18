import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContexts;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * Created by prasanth.p on 17/10/17.
 */
public class ServiceConfig {




//    @Bean
//    public TrustStrategy trustStrategy(){
//        return new TrustStrategy() {
//            @Override
//            public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
//                return true;
//            }
//        };
//    }
//
//    // SSL context for secure connections can be created either based on
//    // system or application specific properties.
    @Bean
    public SSLContext sslcontext() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
     return SSLContexts.custom().build();//SSLContexts.custom().loadTrustMaterial(null,trustStrategy()).build();
    }
//
//    @Bean
//    public SSLConnectionSocketFactory sslConnectionFactory() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
//        return new SSLConnectionSocketFactory(sslcontext(),NoopHostnameVerifier.INSTANCE);
//    }
//
//    // Create a registry of custom connection socket factories for supported
//    // protocol schemes.
//    @Bean
//    public Registry<ConnectionSocketFactory> socketFactoryRegistry() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException{
//         return RegistryBuilder.<ConnectionSocketFactory>create()
//                .register("http", PlainConnectionSocketFactory.INSTANCE)
//                .register("https", sslConnectionFactory())
//                .build();
//    }
//
//    @Bean
//    public PoolingHttpClientConnectionManager poolingHttpClientConnectionManager() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException{
//        PoolingHttpClientConnectionManager poolingHttpClientConnectionManager= new PoolingHttpClientConnectionManager(socketFactoryRegistry());
//        poolingHttpClientConnectionManager.setMaxTotal(10);//max connection
//        poolingHttpClientConnectionManager.setDefaultMaxPerRoute(20);
//        return poolingHttpClientConnectionManager;
//    }
//
//    @Bean
//    public CloseableHttpClient httpclient() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException{
//     return HttpClients.custom()
//             .setConnectionManager(poolingHttpClientConnectionManager())
//             .setSSLContext(sslcontext())
//             .build();
//    }
//
//    @Bean
//    public HttpComponentsClientHttpRequestFactory requestFactory()  throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException{
//        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
//        requestFactory.setHttpClient(httpclient());
//        return requestFactory;
//    }
//
//    @Bean
//    public RestTemplate restTemplate()  throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException{
//        requestFactory().setReadTimeout(1000);
//        requestFactory().setConnectTimeout(2000);
//        RestTemplate restTemplate = new RestTemplate(requestFactory());
//        return restTemplate;
//    }
//
//    @Bean
//    public RestTemplate restTemplate1()  throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException{
//        requestFactory().setReadTimeout(1000);
//        requestFactory().setConnectTimeout(2000);
//        RestTemplate restTemplate = new RestTemplate(requestFactory());
//        return restTemplate;
//    }
}
