import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CreateBucketRequest;
import com.amazonaws.services.s3.model.Region;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by neerbans on 10/3/2017.
 */
public class CreateBucket {

    private static AmazonS3 s3 = null;

    public static void main(String[] args)
    {
        String accessKey = "AKIAJXHU3MBVMET2X3SQ"; //AKIAJXHU3MBVMET2X3SQ
        String secretKey = "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"; //6tYP7M54soID2vB9eB/MFt77SSteNOh4o9lVByv7
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

        s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.DEFAULT_REGION)
                .enableForceGlobalBucketAccess().withCredentials(new AWSStaticCredentialsProvider(credentials)).build();

        Region [] regions = Region.values();
        List<String> names = new ArrayList<>();
        for (Region r : regions) {
            if (r.getFirstRegionId() != null) {
                names.add(r.getFirstRegionId());
            }
        }

        List<String> passedRegions = new ArrayList<>();
        List<String> failedRegions = new ArrayList<>();

        String region_name = "ap-northeast-1";

        System.out.println(" - creating bucket with region : " + region_name);
        Region region1 = Region.fromValue(region_name);
        s3.createBucket(new CreateBucketRequest(region_name + "-neeraj-1666661", region1));
        System.out.println("- bucket created with region : " + region_name);


//        new CreateBucket().createBucketWithoutRegion2(names, credentials);
//        new CreateBucket().createBucketWithoutRegion("djdjdj3ffff");
//        System.out.println(s3.getRegionName());
        System.out.println(0/0);

        for (String regionName : names) {
            try {
                System.out.println(" - creating bucket with region : " + regionName);
                Region region = Region.fromValue(regionName);
                s3.createBucket(new CreateBucketRequest(regionName + "-neeraj-1666661", region));
                System.out.println("- bucket created with region : " + regionName);
                passedRegions.add(regionName);
            } catch (AmazonServiceException e) {
               // System.out.println(e.toString());
                failedRegions.add(regionName);
            }
        }
        System.out.println("Done!");
        System.out.println("PassedRegions : " + passedRegions);
        System.out.println("FailedRegions  : " + failedRegions);
    }

    private void createBucketWithoutRegion(String bucketName) {
        s3.createBucket(bucketName);
    }

    private void createBucketWithoutRegion2(List<String> regionNames, AWSCredentials credentials) {

        List<String> passedRegions = new ArrayList<>();
        List<String> failedRegions = new ArrayList<>();
        for (String name : regionNames) {
            try {
                System.out.println(" - creating bucket with region : " + name);
                s3 = AmazonS3ClientBuilder.standard().withRegion(name)
                        .withCredentials(new AWSStaticCredentialsProvider(credentials)).build();
                s3.createBucket(name + "neeraj-1001");
                System.out.println("- bucket created with region : " + name);
                passedRegions.add(name);
            } catch (AmazonServiceException e) {
                failedRegions.add(name);
                //e.printStackTrace();
                //throw new RuntimeException(e);
            }
        }
        System.out.println("Done!");
        System.out.println("PassedRegions : " + passedRegions);
        System.out.println("FailedRegions  : " + failedRegions);
    }

}
