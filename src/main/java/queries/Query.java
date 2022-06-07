package queries;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.bson.Document;

import java.util.List;

public abstract class Query {
    public String name;
    public SparkSession spark;
    public JavaRDD<Row> dataset;
    public MongoCollection collection;

    public Query(SparkSession spark, JavaRDD<Row> dataset, MongoCollection collection, String name) {
        this.spark = spark;
        this.dataset = dataset;
        this.collection = collection;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void execute();

    public void printResults() {
        System.out.println("\n—————————————————————————————————————————————————————————— "+this.getName()+" ——————————————————————————————————————————————————————————");
        FindIterable<Document> docs = collection.find();
        for (Document doc : docs) {
            System.out.println(doc);
        }
        System.out.println("—————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————\n");
    }

    public void writeResultsOnMongo() {}

    public void writeResultsOnCSV() {}
}
