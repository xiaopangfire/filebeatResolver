import com.filebeat.FilebeatResolver;
import com.filebeat.model.filebeat.FilebeatMsg;
import com.filebeat.resolver.DefaultResolver;

/**
 * @author Jones chen
 * @Classname Test
 * @description TODO
 * @since 2022/09/01 17:08
 */
public class Test {

    public static void main(String[] args) {
        FilebeatResolver filebeatResolver=FilebeatResolver.getInstance();
       filebeatResolver.registerResolver(new DefaultResolver());
       filebeatResolver.dealMsg("{\n" +
               "  \"@timestamp\": \"2022-09-01T02:03:20.737Z\",\n" +
               "  \"@metadata\": {\n" +
               "    \"beat\": \"filebeat\",\n" +
               "    \"type\": \"_doc\",\n" +
               "    \"version\": \"8.5.0\"\n" +
               "  },\n" +
               "  \"log\": {\n" +
               "    \"offset\": 0,\n" +
               "    \"file\": {\n" +
               "      \"path\": \"/Users/chenjunzhou/work/workspace/company/project/oms_new/logs/oms-server/error.log\"\n" +
               "    }\n" +
               "  },\n" +
               "  \"message\": \"[2022-09-01 09:54:04] ERROR [http-nio-7004-exec-1] com.liantong.oms.server.web.controller.TestController:46-- 这是一个error日志\",\n" +
               "  \"tags\": [\n" +
               "    \"error\"\n" +
               "  ],\n" +
               "  \"input\": {\n" +
               "    \"type\": \"filestream\"\n" +
               "  },\n" +
               "  \"ecs\": {\n" +
               "    \"version\": \"8.0.0\"\n" +
               "  },\n" +
               "  \"host\": {\n" +
               "    \"ip\": [\n" +
               "      \"fe80::342f:54ff:febb:ca4c\",\n" +
               "      \"fe80::342f:54ff:febb:ca4b\",\n" +
               "      \"fe80::1026:133d:9e9c:5e74\",\n" +
               "      \"192.168.1.28\",\n" +
               "      \"fe80::cb9:b8ff:fe47:6d08\",\n" +
               "      \"fe80::cb9:b8ff:fe47:6d08\",\n" +
               "      \"fe80::5517:7728:21a9:3c68\",\n" +
               "      \"fe80::7194:cdcb:185a:f387\",\n" +
               "      \"fe80::ce81:b1c:bd2c:69e\",\n" +
               "      \"fe80::a1e:afd1:cc32:33f5\",\n" +
               "      \"fe80::4456:545:e776:8230\"\n" +
               "    ],\n" +
               "    \"name\": \"chenjunzhoudeMacBook-Air.local\",\n" +
               "    \"mac\": [\n" +
               "      \"0E-B9-B8-47-6D-08\",\n" +
               "      \"36-2F-54-BB-CA-2B\",\n" +
               "      \"36-2F-54-BB-CA-2C\",\n" +
               "      \"36-2F-54-BB-CA-4B\",\n" +
               "      \"36-2F-54-BB-CA-4C\",\n" +
               "      \"36-55-55-B7-60-00\",\n" +
               "      \"36-55-55-B7-60-04\",\n" +
               "      \"50-ED-3C-38-63-FC\",\n" +
               "      \"72-ED-3C-38-63-FC\"\n" +
               "    ],\n" +
               "    \"hostname\": \"chenjunzhoudeMacBook-Air.local\",\n" +
               "    \"architecture\": \"arm64\",\n" +
               "    \"os\": {\n" +
               "      \"kernel\": \"21.6.0\",\n" +
               "      \"build\": \"21G83\",\n" +
               "      \"type\": \"macos\",\n" +
               "      \"platform\": \"darwin\",\n" +
               "      \"version\": \"12.5.1\",\n" +
               "      \"family\": \"darwin\",\n" +
               "      \"name\": \"macOS\"\n" +
               "    },\n" +
               "    \"id\": \"5A3DAEAE-2F2D-505B-87BF-EE51531B7030\"\n" +
               "  },\n" +
               "  \"agent\": {\n" +
               "    \"name\": \"chenjunzhoudeMacBook-Air.local\",\n" +
               "    \"type\": \"filebeat\",\n" +
               "    \"version\": \"8.5.0\",\n" +
               "    \"ephemeral_id\": \"f5570d28-d8c9-416f-8cc9-e4c4a57b8c5a\",\n" +
               "    \"id\": \"24c824a4-d666-486a-a028-1b2e1bf3597d\"\n" +
               "  },\n" +
               "  \"container\": {\n" +
               "    \"id\": \"company\"\n" +
               "  }\n" +
               "}", FilebeatMsg.class);
    }
}
