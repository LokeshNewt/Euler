import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.*;
import com.amazonaws.util.StringUtils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by neerbans on 9/26/2017.
 */
public class TestS3 {

    private static final String SUFFIX = "/";
    private static final String META_DATA_PARAM_PREFIX = "Metadata.";

    public static void main(String[] args) {
        String s = "       ";
        System.out.println(s.length());
        if (StringUtils.isNullOrEmpty(s)) {
            System.out.println("null/empty");
        }
        System.out.println(0/0);
        saveFiletoS3();
    }

    private static void saveFiletoS3() {
        String accessKey = "AKIAJXHU3MBVMET2X3SQ"; //AKIAJXHU3MBVMET2X3SQ
        String secretKey = "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"; //6tYP7M54soID2vB9eB/MFt77SSteNOh4o9lVByv7
        String bucketName = "test-bucket-0928";
        String regionName = "sa-east-1";
        String folderName = "thursday    ";
        String fileName = "org_feed_test3.txt";

        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

        AmazonS3 s3client = new AmazonS3Client(credentials); // todo - use latest client api's

        // process bucket and region
        boolean isBucketExist = false;
        try {
            // check if bucket exists or not
            for (Bucket bucket : s3client.listBuckets()) {
                if (bucket.getName().equals(bucketName)) {
                    isBucketExist = true;
                }
            }
            // create a bucket if it does not already exist
            if (!isBucketExist) {
                if (StringUtils.isNullOrEmpty(regionName)) {
                    s3client.createBucket(bucketName);
                }
                else {
                    try {
                        // get region from user input value
                        Region region = Region.fromValue(regionName);
                        s3client.createBucket(new CreateBucketRequest(bucketName, region));
                    } catch (IllegalArgumentException e) {
                        throw new RuntimeException("please specify a valid region value");
                    }
                }
            }
        } catch (AmazonS3Exception e) {
            if (e.getErrorCode().equals("SignatureDoesNotMatch")) {
                throw new RuntimeException("invalid secret key value");
            } else if (e.getErrorCode().equals("InvalidAccessKeyId")) {
                throw new RuntimeException("invalid access key value");
            }
        }

        folderName = removeLeadingAndTrailingSpaces(folderName, SUFFIX);

        String key = folderName + SUFFIX + fileName;

        createFolder(bucketName, key, s3client);

        InputStream inputStream;
        try {
            inputStream = new FileInputStream("C:\\Neeraj\\Tenncare\\org_feed.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not Found");
        }

        ObjectMetadata metaData = new ObjectMetadata();
        setUserMetaDataParams(metaData, getDummyMetaDataProps());

        try {
            metaData.setContentLength((long)inputStream.available());
            PutObjectRequest objectRequest = new PutObjectRequest(bucketName, key, inputStream, metaData);
            s3client.putObject(objectRequest);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String removeLeadingAndTrailingSpaces(String s1, String divider) {
        if (s1.startsWith(divider)) {
            s1 = s1.substring(1);
        }
        if (s1.endsWith(divider)) {
            s1 = s1.substring(0, s1.length()-1);
        }
        StringBuilder sb = new StringBuilder();
        for (String s : s1.split(divider)) {
            sb.append(s.trim());
            sb.append(divider);
        }
        s1 = sb.toString();
        return s1.substring(0, s1.length() - 1);
    }

    private static void setUserMetaDataParams(ObjectMetadata metaData, Map<String, String> properties) {
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            String key = entry.getKey();
            if (key.startsWith(META_DATA_PARAM_PREFIX) && key.trim().length() > 9) {
                String paramName = key.substring(key.indexOf(".")+1);
                System.out.println(paramName);
                metaData.addUserMetadata(paramName, entry.getValue());
            }
        }
    }

    private static Map<String, String> getDummyMetaDataProps() {
        Map<String, String> map = new HashMap<>();
        map.put("Metadata.a", "b");
        map.put("Metadat.c", "d");
        map.put("Metadata.x", "y");
        return map;
    }

    private static void createFolder(String bucketName, String folderName, AmazonS3 client) {

        // create meta-data for your folder and set content-length to 0
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(0);

        // create empty content
        InputStream emptyContent = new ByteArrayInputStream(new byte[0]);

        // create a PutObjectRequest passing the folder name suffixed by /
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, folderName, emptyContent, metadata);

        // send request to S3 to create folder
        client.putObject(putObjectRequest);
    }
}
