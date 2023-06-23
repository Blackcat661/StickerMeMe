package cn.itcast.hotel;

// import static org.mockito.Answers.values;

import java.io.IOException;
import static cn.itcast.hotel.constants.HotelConstants.MAPPING_TAMPLATE;
import static org.mockito.Mockito.reset;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import com.alibaba.fastjson.JSON;

import cn.itcast.hotel.pojo.Hotel;
import cn.itcast.hotel.pojo.HotelDoc;
import cn.itcast.hotel.service.IHotelService;
@SpringBootTest
public class HotelIndexDocTest {

    private IHotelService iHotelService;
    private RestHighLevelClient client;

    @Test
    void TestAddDocument() throws IOException{
        // 根据Id查询酒店数据
        Long id = (long) 61083;
        Hotel hotel = iHotelService.getById(id);
        // 转换为文档类型
        HotelDoc hotelDoc = new HotelDoc(hotel);

        // 1.准备Request对象
        IndexRequest request = new IndexRequest("hotel").id(hotel.getId().toString());

        // 2.准备JSON文档
        request.source(JSON.toJSONString(hotelDoc), XContentType.JSON);
        // 3.发送请求
        client.index(request, RequestOptions.DEFAULT);
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
