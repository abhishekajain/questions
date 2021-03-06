# cassandra

* All the nodes in a cluster play the same role. Each node is independent and at the same time interconnected to other nodes.

* Each node in a cluster can accept read and write requests, regardless of where the data is actually located in the cluster.

* When a node goes down, read/write requests can be served from other nodes in the network.
 Cassandra uses the Gossip Protocol in the background to allow the nodes to communicate with each other and detect any faulty nodes in the cluster.
 
## Components of Cassandra
The key components of Cassandra are as follows -

* Node - It is the place where data is stored.

* Data center - It is a collection of related nodes.

* Cluster - A cluster is a component that contains one or more data centers.

* Commit log - The commit log is a crash-recovery mechanism in Cassandra. Every write operation is written to the commit log.

* Mem-table - A mem-table is a memory-resident data structure. After commit log, the data will be written to the mem-table. Sometimes, for a single-column family, there will be multiple mem-tables.

* SSTable - It is a disk file to which the data is flushed from the mem-table when its contents reach a threshold value.

* Bloom filter - These are nothing but quick, nondeterministic, algorithms for testing whether an element is a member of a set. It is a special kind of cache. Bloom filters are accessed after every query.


### Install Cassandra from debain source list

* Add cassandra repo to apt source list
    $ echo "deb http://www.apache.org/dist/cassandra/debian 311x main" | sudo tee -a /etc/apt/sources.list.d/cassandra.sources.list

* Add cassandra repo source key to apt
    $ curl https://www.apache.org/dist/cassandra/KEYS | sudo apt-key add -

* Update system repo
    $ sudo apt-get update
	
* Install Cassandra package using apt-get
    $ sudo apt-get install -y cassandra

* Check Cassandra status
    $ sudo service cassandra status

* To start or stop the service
    $ sudo service cassandra [start|stop]
	
	
### Install cassandra from tar 
* download binary and untar from here http://cassandra.apache.org/download/
* su - root
* mv ~/Downloads/apache-cassandra-3.6-bin.tar.gz /var/lib/cassandra  
* untar file ```tar -xvf apache-cassandra-3.6-bin.tar.gz cassandra```
* add ENV variable as per cassandra location CASSANDRA_HOME=/var/lib/cassandra/cassandra
* make directories 'data' and 'logs' inside CASSANDRA_HOME and chmod to 777
* exit root

### cassandra commands
* start ```$CASSANDRA_HOME/bin/cassandra -f```
* check status ```$CASSANDRA_HOME/bin/nodetool status```

### cassandra pointer
#### Main runtime properties

* Most of configuration in Cassandra is done via yaml properties that can be set in cassandra.yaml. At a minimum you should consider setting the following properties:

    * cluster_name: the name of your cluster.
    * seeds: a comma separated list of the IP addresses of your cluster seeds.
    * storage_port: you don’t necessarily need to change this but make sure that there are no firewalls blocking this port.
    * listen_address: the IP address of your node, this is what allows other nodes to communicate with this node so it is important that you change it. Alternatively, you can set listen_interface to tell Cassandra which interface to use, and consecutively which address to use. Set only one, not both.
    * native_transport_port: as for storage_port, make sure this port is not blocked by firewalls as clients will communicate with Cassandra on this port.

#### Changing the location of directories
* The following yaml properties control the location of directories:

    * data_file_directories: one or more directories where data files are located.
    * commitlog_directory: the directory where commitlog files are located.
    * saved_caches_directory: the directory where saved caches are located.
    * hints_directory: the directory where hints are located.
        * For performance reasons, if you have multiple disks, consider putting commitlog and data files on different disks.

#### Environment variables
JVM-level settings such as heap size can be set in cassandra-env.sh. You can add any additional JVM command line argument to the JVM_OPTS environment variable; when Cassandra starts these arguments will be passed to the JVM.

#### Logging
The logger in use is logback. You can change logging properties by editing logback.xml. By default it will log at INFO level into a file called system.log and at debug level into a file called debug.log. When running in the foreground, it will also log at INFO level to the console.