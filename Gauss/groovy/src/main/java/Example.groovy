import groovy.json.JsonBuilder
import groovy.json.JsonSlurper

/**
 * Created by neerbans on 9/20/2017.
 */
class Example {


    static void main(String[] args) {
        println('hello world');

        def inputStream = new InputStreamReader(new FileInputStream("C:\\Neeraj\\Tenncare\\org_feed.txt"), "UTF-8");

        List nonEmptyLineList = new ArrayList();

        inputStream.eachLine { line ->
            if (line?.trim()) {
                nonEmptyLineList.add(line)
            }
        }
        inputStream.close()

        String orgFeed = nonEmptyLineList.get(0);
        List<String> orgFeedLine1 = orgFeed.split("~");

        def requestList = [];

        for (String s : nonEmptyLineList) {
            List<String> orgFeedLine = s.split("~");
            for (int i = 0; i < orgFeedLine.size(); i++) {
                if (orgFeedLine.get(i) == '') {
                    orgFeedLine.set(i, null);
                }
            }
            if (orgFeedLine.get(1) != "CMS Facility Number") {
                continue;
            }
            String action = orgFeedLine.get(12);
            if (action != null && action != '') {
                if (action != 'DELETE') {
                    action = 'UPSERT';
                }
            }
            requestList.add(new OrgRequest(associatedOrgQualifier: orgFeedLine.get(1), associatedOrgID: orgFeedLine.get(2), associatedOrgName: orgFeedLine.get(3),
                    associatedOrgType: orgFeedLine.get(4), associatedOrgAddress: orgFeedLine.get(5), associatedOrgCity: orgFeedLine.get(6),
                    associatedOrgState: orgFeedLine.get(7), associatedOrgZip: orgFeedLine.get(8), associatedOrgPhone: orgFeedLine.get(9),
                    associatedOrgAdmin: orgFeedLine.get(10), associatedOrgAdminEmail: orgFeedLine.get(11), action: action));
        }

        def requestBuilder = new JsonBuilder()
        def requestId = orgFeedLine1.get(0);
        requestBuilder {
            requestID requestId
            orgDetails requestList
        }


        def jsonSlurper = new JsonSlurper()
        def data = jsonSlurper.parseText(requestBuilder.toString())

        def data2 = new Example().denull(data) // change

        requestBuilder {
            requestID requestId
            orgDetails data2.get("orgDetails")
        }

        println requestBuilder.toPrettyString()
    }

    def denull(obj) {
        if (obj instanceof Map) {
            obj.collectEntries { k, v ->
                if (v) [(k): denull(v)] else [:]
            }
        } else if (obj instanceof List) {
            obj.collect { denull(it) }.findAll { it != null }
        } else {
            obj
        }
    }

}

class OrgRequest {
    String associatedOrgQualifier
    String associatedOrgID
    String associatedOrgName
    String associatedOrgType
    String associatedOrgAddress
    String associatedOrgCity
    String associatedOrgState
    String associatedOrgZip
    String associatedOrgPhone
    String associatedOrgAdmin
    String associatedOrgAdminEmail
    String action
}