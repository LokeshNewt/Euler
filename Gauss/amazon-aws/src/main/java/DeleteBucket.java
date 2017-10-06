import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by neerbans on 10/3/2017.
 */
public class DeleteBucket {

    private static List<String> bucketNames = Arrays.asList("route-bucket");

    public static void main(String[] args)
    {
        String accessKey = "AKIAJXHU3MBVMET2X3SQ"; //AKIAJXHU3MBVMET2X3SQ
        String secretKey = "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"; //6tYP7M54soID2vB9eB/MFt77SSteNOh4o9lVByv7
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

        final AmazonS3 s3 = new AmazonS3Client(credentials);

        List<Bucket> buckets = s3.listBuckets();
        //buckets.forEach(b -> System.out.println(b.getName()));
        //System.out.println(0/0);

        for (Bucket bucket : s3.listBuckets())
        {

            String bucket_name = bucket.getName();

            System.out.println("Deleting S3 bucket: " + bucket_name);

            try {
                System.out.println(" - removing objects from bucket");
                ObjectListing object_listing = s3.listObjects(bucket_name);
                while (true) {
                    for (Iterator<?> iterator =
                                 object_listing.getObjectSummaries().iterator();
                         iterator.hasNext(); ) {
                        S3ObjectSummary summary = (S3ObjectSummary) iterator.next();
                        s3.deleteObject(bucket_name, summary.getKey());
                    }

                    // more object_listing to retrieve?
                    if (object_listing.isTruncated()) {
                        object_listing = s3.listNextBatchOfObjects(object_listing);
                    } else {
                        break;
                    }
                }
                ;

                System.out.println(" - removing versions from bucket");
                VersionListing version_listing = s3.listVersions(
                        new ListVersionsRequest().withBucketName(bucket_name));
                while (true) {
                    for (Iterator<?> iterator =
                                 version_listing.getVersionSummaries().iterator();
                         iterator.hasNext(); ) {
                        S3VersionSummary vs = (S3VersionSummary) iterator.next();
                        s3.deleteVersion(

                                bucket_name, vs.getKey(), vs.getVersionId());
                    }

                    if (version_listing.isTruncated()) {
                        version_listing = s3.listNextBatchOfVersions(
                                version_listing);
                    } else {
                        break;
                    }
                }

                System.out.println(" OK, bucket ready to delete!");
                s3.deleteBucket(bucket_name);
            } catch (AmazonServiceException e) {
                //e.printStackTrace();
                System.err.println(e.getErrorMessage());
                //System.exit(1);
            }
        }
        System.out.println("Done!");
    }
}
