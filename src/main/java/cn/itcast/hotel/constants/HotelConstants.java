package cn.itcast.hotel.constants;

public class HotelConstants {
    public static final String MAPPING_TAMPLATE = "{\n" + //
            "  \"mappings\": {\n" + //
            "    \"properties\": {\n" + //
            "      \"id\": {\n" + //
            "        \"type\": \"keyword\"\n" + //
            "      },\n" + //
            "      \"name\": {\n" + //
            "        \"type\": \"text\",\n" + //
            "        \"analyzer\": \"ik_max_word\",\n" + //
            "        \"copy_to\": \"name\"\n" + //
            "      },\n" + //
            "      \"address\": {\n" + //
            "        \"type\": \"keyword\",\n" + //
            "        \"index\": false\n" + //
            "      },\n" + //
            "      \"price\": {\n" + //
            "        \"type\": \"integer\",\n" + //
            "        \"copy_to\": \"name\"\n" + //
            "      },\n" + //
            "      \"score\": {\n" + //
            "        \"type\": \"integer\",\n" + //
            "        \"copy_to\": \"name\"\n" + //
            "      },\n" + //
            "      \"brand\": {\n" + //
            "        \"type\": \"keyword\",\n" + //
            "        \"copy_to\": \"name\"\n" + //
            "      },\n" + //
            "      \"city\": {\n" + //
            "        \"type\": \"keyword\",\n" + //
            "        \"copy_to\": \"name\"\n" + //
            "      },\n" + //
            "      \"startName\": {\n" + //
            "        \"type\": \"keyword\",\n" + //
            "        \"copy_to\": \"name\"\n" + //
            "      },\n" + //
            "      \"business\": {\n" + //
            "        \"type\": \"keyword\",\n" + //
            "        \"copy_to\": \"name\"\n" + //
            "      },\n" + //
            "      \"location\": {\n" + //
            "        \"type\": \"geo_point\"\n" + //
            "      },\n" + //
            "      \"pic\": {\n" + //
            "        \"type\": \"keyword\",\n" + //
            "        \"index\": false\n" + //
            "      }\n" + //
            "    }\n" + //
            "  }\n" + //
            "}";
    
}
