import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import com.amazonaws.util.StringUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by neerbans on 9/26/2017.
 */
public class TestS3 {


    static String accessKey = "AKIAJXHU3MBVMET2X3SQ"; //AKIAJXHU3MBVMET2X3SQ
    static String secretKey = "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"; //6tYP7M54soID2vB9eB/MFt77SSteNOh4o9lVByv7
    static String bucketName = "aa-unit-1101";
    static String regionName = "ap-southeast-2";
    static String folderName = "/tuesday/kkkkjjj";
    static String fileName = "org_feed_test5hhh";

    private static final String SUFFIX = "/";
    private static final String META_DATA_PARAM_PREFIX = "Metadata.";

    public static void main(String[] args) {
//        String s = "       ";
//        System.out.println(s.length());
//        if (StringUtils.isNullOrEmpty(s)) {
//            System.out.println("null/empty");
//        }
//        System.out.println(0/0);
        saveFiletoS3();

//        testCreateS3Client();
    }

    private static void saveFiletoS3() {


        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
//        AmazonS3 s3client = new AmazonS3Client(credentials);
        AmazonS3 s3client = AmazonS3ClientBuilder.standard().withRegion(Regions.DEFAULT_REGION).withForceGlobalBucketAccessEnabled(true)
                .withCredentials(new AWSStaticCredentialsProvider(credentials)).build();

        //System.out.println(!s3client.doesBucketExistV2("test-bucket-1003"));

//        String r = s3client.getBucketLocation("ddd");
//        System.out.println(r);
//        if (!s3client.doesBucketExistV2("test-bucket-1003")) {
//            System.out.println("true");
//        }
//
//        System.out.println(0/0);

        String bucketName = "{Prp[BucketName]}";
        boolean isBucketExist = !s3client.doesBucketExistV2("45kkkkkkkkkddddddddddkdd");
//        boolean isBucketExist = !s3client.doesBucketExistV2(bucketName);

        // process bucket and region
        try {
            // create a bucket if it does not already exist
            if (false) {
//            if (!s3client.doesBucketExistV2(bucketName)) {
                if (StringUtils.isNullOrEmpty(regionName)) {
                    try {
                        s3client.createBucket(bucketName);
                    } catch (IllegalArgumentException e) {
                        throw new RuntimeException("invalid bucket name : " + bucketName);
                    }
                }
                else {
                    try {
//                        s3client = AmazonS3ClientBuilder.standard().withRegion(Regions.DEFAULT_REGION).enableForceGlobalBucketAccess()
//                                .withCredentials(new AWSStaticCredentialsProvider(credentials)).build();
//                        AmazonS3 s3client3 = new AmazonS3Client(credentials);
                        // get region from user input value
                        Region region = Region.fromValue(regionName);
//                        s3client3.createBucket(bucketName);
                        s3client.createBucket(new CreateBucketRequest(bucketName, region));
//                        s3client.shutdown();
                    } catch (IllegalArgumentException | AmazonS3Exception e) {
                        if (e.getMessage().contains("Cannot create enum")) {
                            throw new RuntimeException("invalid region id :" + regionName, e);
                        } else if (e.getMessage().contains("BucketAlreadyOwnedByYou")) {
                            System.out.println(e.getMessage());
                            System.out.println("bucket already exist");
                        }

                    }
                }
            }
        } catch (AmazonS3Exception e) {
            if (e.getErrorCode().equals("SignatureDoesNotMatch")) {
                throw new RuntimeException("invalid secret key value");
            } else if (e.getErrorCode().equals("InvalidAccessKeyId")) {
                throw new RuntimeException("invalid access key value", e);
            }
            throw new RuntimeException(e);
        }

        folderName = removeLeadingAndTrailingSpaces(folderName, SUFFIX);

//        String key = folderName + "" + fileName;
        String key = folderName + SUFFIX + fileName;

        //createFolder(bucketName, key, s3client);

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

//                System.out.println("- storing objects in bucket: " + b.getName());
                PutObjectRequest objectRequest = new PutObjectRequest(bucketName, key, inputStream, metaData);
//                PutObjectRequest objectRequest = new PutObjectRequest(bucketName, key, inputStream, metaData);
                s3client.putObject(objectRequest);
//                System.out.println(" --- objects stored  in bucket: " + b.getName());
            System.out.println(s3client.doesBucketExistV2(bucketName));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String removeLeadingAndTrailingSpaces(String s1, String divider) {
//        if (s1.startsWith(divider)) {
//            s1 = s1.substring(1);
//        }
//        if (s1.endsWith(divider)) {
//            s1 = s1.substring(0, s1.length()-1);
//        }
//        StringBuilder sb = new StringBuilder();
//        for (String s : s1.split(divider)) {
//            sb.append(s.trim());
//            sb.append(divider);
//        }
//        s1 = sb.toString();
//        return s1.substring(0, s1.length() - 1);
        return s1.trim();
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

}
