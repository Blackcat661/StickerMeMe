package cn.itcast.hotel;

// import static org.mockito.Answers.values;

import java.io.IOException;
import static cn.itcast.hotel.constants.HotelConstants.MAPPING_TAMPLATE;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HotelIndexTest {
    private RestHighLevelClient client;

    @Test
    void testInit(){
        System.out.println(client);
    }

    @Test
    void createHotelIndex() throws IOException{
        // 1. 创建Request对象
        CreateIndexRequest request = new CreateIndexRequest("hotel");
        // 2. 准备请求的参数：DSL语句
        request.source(MAPPING_TAMPLATE, XContentType.JSON);
        // 3. 发送请求
        client.indices().create(request, RequestOptions.DEFAULT);
        
    }

    @Test
    void testDeleteHotelIndex() throws IOException{
        DeleteIndexRequest request = new DeleteIndexRequest("hotel");
        client.indices().delete(request, RequestOptions.DEFAULT);
    }

    @Test
    void testExistsHotelIndex() throws IOException{
        
        GetIndexRequest request = new GetIndexRequest("hotel");
        boolean exists = client.indices().exists(request, RequestOptions.DEFAULT);
        System.err.println(exists?"索引库存在！":"索引库不存在！");
    }

    @BeforeEach
    void setUp(){
        this.client = new RestHighLevelClient(RestClient.builder(
            HttpHost.create("http://139.224.103.159:9200")
        ));
    }

    @AfterEach
    void tearDown() throws IOException {
        this.client.close();
    }
}
