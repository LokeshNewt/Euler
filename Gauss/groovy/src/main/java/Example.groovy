import groovy.json.JsonBuilder
import groovy.json.JsonSlurper

/**
 * Created by neerbans on 9/20/2017.
 */
class Example {


    static void main(String[] args) {
        println('hello world');

//        def json = new JsonBuilder()
//
//        def status = "jdjdjdj";
//
//        json {
//            status1 status
//        }
//
//        println json.toString();
        def errorList = [];

        def jsonSlurper = new JsonSlurper()
        def reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Neeraj\\Tenncare\\z_cnsi_response.txt"), "UTF-8"))
        def data = jsonSlurper.parse(reader)
        println data.requestID
        if (data.status.code != 200) {
            throw new RuntimeException(" Failed Upload of Orgs ")
        } else {
            def org = data.orgDetails
            org.each {
                if (it.status.code != 200) {
                    println "qualifier : " + it.associatedOrgQualifier
                    println "desc : " + it.status.desc
                    errorList.add(new ErrorResponse(associatedOrgQualifier: it.associatedOrgQualifier, desc: it.status.desc))
//        errorList.add(new ErrorResponse(associatedOrgQualifier: 'dd', desc: 'ff'))
                }
                println it.associatedOrgQualifier
            }
            if (errorList.size() > 0) {
                println errorList;
            }
//        }
//    }
        }

        def builder = new JsonBuilder()
        builder {
            response errorList
        }

        println builder.toPrettyString()
    }

//    class ErrorResponse {
//        Map propMap
//        def ErrorResponse(Map propMap) {
//            this.propMap = propMap
//        }
//    }
//    }
}
class ErrorResponse {
    def associatedOrgQualifier
    def desc
}