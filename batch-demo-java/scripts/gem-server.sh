if [ -z "$1" ]; then
    echo "Usage: gemfire-server <locator-host>"
    exit 1
fi

loc=$1[10334]


hn=`hostname`
target=/Users/wlundDropbox/git-workspace/wxlund/batch-4-spring-tip/batch-demo-java/target
xml=../xml

cp=$target/classes
#for i in `ls $target/dependency/*.jar`; do 
#    cp=$cp:$i
#done
echo $cp

jvmargs="--J=-XX:+UseParNewGC --J=-XX:+UseConcMarkSweepGC --J=-XX:CMSInitiatingOccupancyFraction=60"
gfargs="--J=-Dgemfire.statistic-archive-file=$hn.gfs --J=-Dgemfire.archive-file-size-limit=100 --J=-Dgemfire.archive-disk-space-limit=1000  --J=-Dgemfire.start-dev-rest-api=true --J=-Dgemfire.http-service-port=8888"

gfsh start server --name=server-$hn  --server-port=0 --locators=$loc --initial-heap=1g --max-heap=1g $jvmargs $gfargs --classpath=$cp 
