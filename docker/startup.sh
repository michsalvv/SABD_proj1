#! /bin/bash
docker exec hdfs-master /bin/sh -c "hdfs namenode -format; ./usr/local/hadoop/sbin/start-dfs.sh; hdfs dfs -put /home/data/yellow_tripdata_2021-12.parquet /yellow_tripdata_2021-12.parquet ; hdfs dfs -put /home/handson-spark-1.0.jar /test.jar"