sudo mkfs.ext4 /dev/xvdf
mkdir /mnt/ebs1
sudo mount /dev/xvdf /mnt/ebs1/
sudo chown -R hadoop:hadoop /mnt/ebs1


#writing content
vim /home/hadoop/conf/hdfs-site.xml


sudo /etc/init.d/hadoop-datanode restart


time bin/ycsb run hbase -p columnfamily=family -P workloads/workloada -p operationcount=200000 -P records.props -threads 50 -s  -target 800 1> nanlin_hbase_summary_file_800 2> nanlin_hbase_results_file_800

time bin/ycsb run hbase -p columnfamily=family -P workloads/workloada -p operationcount=200000 -P records.props -threads 50 -s  -target 1600 1> nanlin_hbase_summary_file_1600 2> nanlin_hbase_results_file_1600


read/write requests:                 1579200 (5262.93 per sec.)
    other operations:                    225600 (751.85 per sec.)

    read/write requests:                 2267356 (7556.49 per sec.)
    other operations:                    323908 (1079.50 per sec.)

